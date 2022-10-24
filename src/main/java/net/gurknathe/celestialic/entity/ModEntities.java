package net.gurknathe.celestialic.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.entity.custom.KoiEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<KoiEntity> KOI;

    static {
        KOI = Registry.register(
                Registry.ENTITY_TYPE,
                new Identifier(CelestialicMod.MOD_ID, "koi"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, KoiEntity::new)
                        .dimensions(EntityDimensions.changing(0.5f, 0.3f)).build()
        );
    }
}
