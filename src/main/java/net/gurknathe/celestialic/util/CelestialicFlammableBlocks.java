package net.gurknathe.celestialic.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.gurknathe.celestialic.block.CelestialicBlocks;

public class CelestialicFlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(CelestialicBlocks.CELESTIAL_LOG, 5, 5);
        registry.add(CelestialicBlocks.CELESTIAL_WOOD, 5, 5);
        registry.add(CelestialicBlocks.STRIPPED_CELESTIAL_LOG, 5, 5);
        registry.add(CelestialicBlocks.STRIPPED_CELESTIAL_WOOD, 5, 5);

        registry.add(CelestialicBlocks.CELESTIAL_PLANKS, 5, 20);
        registry.add(CelestialicBlocks.CELESTIAL_LEAVES, 30, 60);
    }
}
