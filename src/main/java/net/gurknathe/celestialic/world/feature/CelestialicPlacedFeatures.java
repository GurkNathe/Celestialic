package net.gurknathe.celestialic.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class CelestialicPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> CELESTIAL_PLACED = PlacedFeatures.register("celestial_placed",
            CelestialicConfiguredFeatures.CELESTIAL_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));

    public static final RegistryEntry<PlacedFeature> MAGNOLIA = PlacedFeatures.register("magnolia_placed",
            CelestialicConfiguredFeatures.MAGNOLIA, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
}
