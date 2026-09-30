package com.github.mnesikos.orchard;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue DAILY_GROWTH = BUILDER
            .comment("Whether fruit node growth stages advance on a daily basis instead of the vanilla random tick system.")
            .define("dailyGrowth", false);

    public static final ModConfigSpec.IntValue DAILY_TIME_MIN = BUILDER
            .comment("The time of day, in ticks, dailyGrowth will take place, if enabled.")
            .defineInRange("dailyTimeMin", 5, 0, 24000);

    static final ModConfigSpec SPEC = BUILDER.build();
}
