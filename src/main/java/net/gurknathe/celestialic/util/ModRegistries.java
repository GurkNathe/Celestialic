package net.gurknathe.celestialic.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.gurknathe.celestialic.entity.ModEntities;
import net.gurknathe.celestialic.entity.custom.AureateKoiEntity;
import net.gurknathe.celestialic.entity.custom.KoiEntity;

public class ModRegistries {

    public static void registerModStuffs() {
        registerAttributes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.KOI, KoiEntity.setAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.AUREATE_KOI, AureateKoiEntity.setAttributes());
    }
}
