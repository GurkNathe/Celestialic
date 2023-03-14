package net.gurknathe.celestialic.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.gurknathe.celestialic.entity.CelestialicEntities;
import net.gurknathe.celestialic.entity.custom.AureateKoiEntity;
import net.gurknathe.celestialic.entity.custom.KoiEntity;
import net.gurknathe.celestialic.entity.custom.YangKoiEntity;
import net.gurknathe.celestialic.entity.custom.YinKoiEntity;

public class CelestialicRegistries {

    public static void registerModStuffs() {
        registerAttributes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(CelestialicEntities.KOI, KoiEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(CelestialicEntities.AUREATE_KOI, AureateKoiEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(CelestialicEntities.YANG_KOI, YangKoiEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(CelestialicEntities.YIN_KOI, YinKoiEntity.setAttributes());
    }
}
