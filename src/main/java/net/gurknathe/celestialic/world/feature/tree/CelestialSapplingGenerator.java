package net.gurknathe.celestialic.world.feature.tree;

import net.gurknathe.celestialic.world.feature.CelestialicConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CelestialSapplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return CelestialicConfiguredFeatures.CELESTIAL_TREE;
    }
}
