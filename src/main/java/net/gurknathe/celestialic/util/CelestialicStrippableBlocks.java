package net.gurknathe.celestialic.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.gurknathe.celestialic.block.CelestialicBlocks;

public class CelestialicStrippableBlocks {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(CelestialicBlocks.CELESTIAL_LOG, CelestialicBlocks.STRIPPED_CELESTIAL_LOG);
        StrippableBlockRegistry.register(CelestialicBlocks.CELESTIAL_WOOD, CelestialicBlocks.STRIPPED_CELESTIAL_WOOD);
    }
}
