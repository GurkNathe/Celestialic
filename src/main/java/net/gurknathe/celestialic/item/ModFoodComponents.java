package net.gurknathe.celestialic.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent RAW_KOI = new FoodComponent
            .Builder().hunger(2).saturationModifier(0.2f).build();

    public static final FoodComponent COOKED_KOI = new FoodComponent
            .Builder().hunger(6).saturationModifier(7.8f).build();
}
