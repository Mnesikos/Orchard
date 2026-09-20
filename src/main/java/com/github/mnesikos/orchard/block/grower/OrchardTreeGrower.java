package com.github.mnesikos.orchard.block.grower;

import com.github.mnesikos.orchard.data.OrchardFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class OrchardTreeGrower {
    public static final TreeGrower CHERRY = new TreeGrower("cherry", Optional.empty(), Optional.of(OrchardFeatures.CHERRY), Optional.empty());
    public static final TreeGrower CINNAMON = new TreeGrower("cinnamon", Optional.empty(), Optional.of(OrchardFeatures.CINNAMON), Optional.empty());
    public static final TreeGrower HAZELNUT = new TreeGrower("hazelnut", Optional.empty(), Optional.of(OrchardFeatures.HAZELNUT), Optional.empty());
    public static final TreeGrower LEMON = new TreeGrower("lemon", Optional.empty(), Optional.of(OrchardFeatures.LEMON), Optional.empty());
    public static final TreeGrower LYCHEE = new TreeGrower("lychee", Optional.empty(), Optional.of(OrchardFeatures.LYCHEE), Optional.empty());
    public static final TreeGrower MANGO = new TreeGrower("mango", Optional.empty(), Optional.of(OrchardFeatures.MANGO), Optional.empty());
    public static final TreeGrower ORANGE = new TreeGrower("orange", Optional.empty(), Optional.of(OrchardFeatures.ORANGE), Optional.empty());
    public static final TreeGrower PAWPAW = new TreeGrower("pawpaw", Optional.empty(), Optional.of(OrchardFeatures.PAWPAW), Optional.empty());
    public static final TreeGrower PEACH = new TreeGrower("peach", Optional.empty(), Optional.of(OrchardFeatures.PEACH), Optional.empty());
    public static final TreeGrower PLUM = new TreeGrower("plum", Optional.empty(), Optional.of(OrchardFeatures.PLUM), Optional.empty());
    public static final TreeGrower RED_APPLE = new TreeGrower("red_apple", Optional.empty(), Optional.of(OrchardFeatures.RED_APPLE), Optional.empty());
    public static final TreeGrower STARFRUIT = new TreeGrower("starfruit", Optional.empty(), Optional.of(OrchardFeatures.STARFRUIT), Optional.empty());
}
