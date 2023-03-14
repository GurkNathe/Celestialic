package net.gurknathe.celestialic.item;

import net.minecraft.item.FoodComponent;

public class CelestialicFoodComponents {
    public static final FoodComponent RAW_KOI;
    public static final FoodComponent COOKED_KOI;

    static {
        COOKED_KOI = new FoodComponent
                .Builder().hunger(6).saturationModifier(7.8f).build();
        RAW_KOI = new FoodComponent
                .Builder().hunger(2).saturationModifier(0.2f).build();
    }
}
