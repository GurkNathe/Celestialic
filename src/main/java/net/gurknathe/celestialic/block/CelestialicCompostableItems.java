package net.gurknathe.celestialic.block;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

public class CelestialicCompostableItems {
    public static void registerCompostableItems() {
        CompostingChanceRegistry.INSTANCE.add(CelestialicBlocks.CELESTIAL_SAPLING, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(CelestialicBlocks.CELESTIAL_LEAVES, 0.3f);
    }
}
