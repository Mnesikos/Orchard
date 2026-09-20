package com.github.mnesikos.orchard.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.util.TriState;

import java.util.function.Supplier;

public class FruitBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private final Supplier<? extends Item> fruitItem;

    public FruitBlock(Supplier<? extends Item> fruitItem, Properties properties) {
        super(properties);
        this.fruitItem = fruitItem;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape[] shapeByAge = new VoxelShape[]{
                Block.box(6.0D, 12.0D, 6.0D, 10.0D, 16.0D, 10.0D),
                Block.box(5.0D, 10.0D, 5.0D, 11.0D, 16.0D, 11.0D),
                Block.box(4.0D, 8.0D, 4.0D, 12.0D, 16.0D, 12.0D),
                Block.box(3.0D, 6.0D, 3.0D, 13.0D, 16.0D, 13.0D)
        };
        Vec3 vec3 = state.getOffset(level, pos);
        return shapeByAge[getAge(state)].move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.LEAVES);
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1))
            return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (level.getRawBrightness(pos, 0) >= 9) {
            int i = getAge(state);
            if (i < getMaxAge()) { //todo config tick vs daily growth
                float f = FruitBlock.getGrowthSpeed(state, level, pos);
                if (CommonHooks.canCropGrow(level, pos, state, random.nextInt((int) (25.0F / f) + 1) == 0)) {
                    level.setBlock(pos, getStateForAge(i + 1), 2);
                    CommonHooks.fireCropGrowPost(level, pos, state);
                }
            }
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        return !isMaxAge(state) && stack.is(Items.BONE_MEAL) ? ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION : super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!isMaxAge(state)) return InteractionResult.PASS;

        else if (isMaxAge(state)) {
            popResource(level, pos, new ItemStack(getBaseSeedId(), 1));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState resetAgeState = state.setValue(AGE, 0);
            level.setBlock(pos, resetAgeState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, resetAgeState));
            return InteractionResult.sidedSuccess(level.isClientSide);

        } else return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return super.getBonemealAgeIncrease(level) / 3;
    }

    protected static float getGrowthSpeed(BlockState state, BlockGetter level, BlockPos pos) {
        Block block = state.getBlock();
        float f = 1.0F;
        BlockPos abovePos = pos.above();

        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                float f1;
                label77:
                {
                    f1 = 0.0F;
                    BlockState blockstate = level.getBlockState(abovePos.offset(i, 0, j));
                    TriState canSustainPlant = blockstate.canSustainPlant(level, abovePos.offset(i, 0, j), Direction.DOWN, state);
                    if (canSustainPlant.isDefault()) {
                        if (!(blockstate.getBlock() instanceof LeavesBlock)) {
                            break label77;
                        }
                    } else if (!canSustainPlant.isTrue()) {
                        break label77;
                    }

                    f1 = 1.0F;
                    if (blockstate.isFertile(level, pos.offset(i, 0, j))) {
                        f1 = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos northPos = pos.north();
        BlockPos southPos = pos.south();
        BlockPos westPos = pos.west();
        BlockPos eastPos = pos.east();
        boolean flag = level.getBlockState(westPos).is(block) || level.getBlockState(eastPos).is(block);
        boolean flag1 = level.getBlockState(northPos).is(block) || level.getBlockState(southPos).is(block);
        if (flag && flag1) {
            f /= 2.0F;
        } else {
            boolean flag2 = level.getBlockState(westPos.north()).is(block) || level.getBlockState(eastPos.north()).is(block) || level.getBlockState(eastPos.south()).is(block) || level.getBlockState(westPos.south()).is(block);
            if (flag2) {
                f /= 2.0F;
            }
        }

        return f;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos abovePos = pos.above();
        TriState canSustainPlant = level.getBlockState(abovePos).canSustainPlant(level, abovePos, Direction.DOWN, state);
        if (!canSustainPlant.isDefault())
            return canSustainPlant.isTrue();
        return hasSufficientLight(level, pos) && this.mayPlaceOn(level.getBlockState(abovePos), level, abovePos);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return fruitItem.get();
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return player.isCreative() ? new ItemStack(this) : super.getCloneItemStack(state, target, level, pos, player);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return !isMaxAge(state); //todo config
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
