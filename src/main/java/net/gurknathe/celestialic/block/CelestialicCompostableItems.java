package net.gurknathe.celestialic.block;

import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import net.minecraft.item.ItemConvertible;

public class CelestialicCompostableItems {
    public static final Object2FloatMap<ItemConvertible> ITEM_TO_LEVEL_INCREASE_CHANCE = new Object2FloatOpenHashMap();

    public static void registerCompostableItems() {
        ITEM_TO_LEVEL_INCREASE_CHANCE.defaultReturnValue(-1.0f);
        registerCompostableItem(0.3f, CelestialicBlocks.CELESTIAL_SAPLING);
        registerCompostableItem(0.3f, CelestialicBlocks.CELESTIAL_LEAVES);
    }

    private static void registerCompostableItem(float levelIncreaseChance, ItemConvertible item) {
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(item.asItem(), levelIncreaseChance);
    }
}
