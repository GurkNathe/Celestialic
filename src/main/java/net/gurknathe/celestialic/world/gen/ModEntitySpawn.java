package net.gurknathe.celestialic.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.gurknathe.celestialic.entity.ModEntities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;

public class ModEntitySpawn {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.RIVER, Biome.Category.SWAMP),
                SpawnGroup.WATER_AMBIENT,
                ModEntities.KOI,
                2,
                0,
                5);
        SpawnRestrictionAccessor.callRegister(
                ModEntities.KOI,
                SpawnRestriction.Location.IN_WATER,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                WaterCreatureEntity::canSpawn);
    }
}
