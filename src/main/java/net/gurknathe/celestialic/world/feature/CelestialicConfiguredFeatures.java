package net.gurknathe.celestialic.world.feature;

import net.gurknathe.celestialic.Celestialic;
import net.gurknathe.celestialic.block.CelestialicBlocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class CelestialicConfiguredFeatures {
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CELESTIAL_TREE =
            ConfiguredFeatures.register("celestial_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(CelestialicBlocks.CELESTIAL_LOG),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.of(CelestialicBlocks.CELESTIAL_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                    new TwoLayersFeatureSize(1,0,2))
                    .build());

    public static final RegistryEntry<PlacedFeature> CELESTIAL_CHECKED = PlacedFeatures.register("celestial_checked",
            CelestialicConfiguredFeatures.CELESTIAL_TREE,
            List.of(PlacedFeatures.wouldSurvive(CelestialicBlocks.CELESTIAL_SAPLING)));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CELESTIAL_SPAWN =
            ConfiguredFeatures.register("celestial_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(CELESTIAL_CHECKED, 0.5f)),
                            CELESTIAL_CHECKED));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> MAGNOLIA =
            ConfiguredFeatures.register("flower_magnolia", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(64, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(CelestialicBlocks.MAGNOLIA)))));
    public static void registerConfiguredFeatures() {
        Celestialic.LOGGER.debug("Registering the CelestialicConfiguredFeatures for " + Celestialic.MOD_ID);
    }
}
