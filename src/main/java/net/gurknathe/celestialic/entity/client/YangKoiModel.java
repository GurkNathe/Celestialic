package net.gurknathe.celestialic.entity.client;

import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.entity.custom.YangKoiEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class YangKoiModel extends AnimatedGeoModel<YangKoiEntity> {
    @Override
    public Identifier getModelLocation(YangKoiEntity object) {
        return new Identifier(CelestialicMod.MOD_ID, "geo/koi.geo.json");
    }

    @Override
    public Identifier getTextureLocation(YangKoiEntity object) {
        return new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi_yang.png");
    }

    @Override
    public Identifier getAnimationFileLocation(YangKoiEntity animatable) {
        return new Identifier(CelestialicMod.MOD_ID, "animations/koi.animation.json");
    }
}
