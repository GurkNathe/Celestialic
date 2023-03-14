package net.gurknathe.celestialic.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.gurknathe.celestialic.Celestialic;
import net.gurknathe.celestialic.entity.custom.AureateKoiEntity;
import net.gurknathe.celestialic.entity.custom.KoiEntity;
import net.gurknathe.celestialic.entity.custom.YangKoiEntity;
import net.gurknathe.celestialic.entity.custom.YinKoiEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CelestialicEntities {
    public static final EntityType<KoiEntity> KOI;
    public static final EntityType<AureateKoiEntity> AUREATE_KOI;
    public static final EntityType<YangKoiEntity> YANG_KOI;
    public static final EntityType<YinKoiEntity> YIN_KOI;

    static {
        KOI = Registry.register(
                Registry.ENTITY_TYPE,
                new Identifier(Celestialic.MOD_ID, "koi"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, KoiEntity::new)
                        .dimensions(EntityDimensions.changing(1.0f, 0.75f)).build()
        );
        AUREATE_KOI = Registry.register(
                Registry.ENTITY_TYPE,
                new Identifier(Celestialic.MOD_ID, "aureate_koi"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, AureateKoiEntity::new)
                        .dimensions(EntityDimensions.changing(1.0f, 0.75f)).build()
        );
        YANG_KOI = Registry.register(
                Registry.ENTITY_TYPE,
                new Identifier(Celestialic.MOD_ID, "yang_koi"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, YangKoiEntity::new)
                        .dimensions(EntityDimensions.changing(1.0f, 0.75f)).build()
        );
        YIN_KOI = Registry.register(
                Registry.ENTITY_TYPE,
                new Identifier(Celestialic.MOD_ID, "yin_koi"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, YinKoiEntity::new)
                        .dimensions(EntityDimensions.changing(1.0f, 0.75f)).build()
        );
    }
}
