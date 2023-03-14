package net.gurknathe.celestialic.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class CelestialicPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> CELESTIAL_PLACED = PlacedFeatures.register("celestial_placed",
            CelestialicConfiguredFeatures.CELESTIAL_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));
}
