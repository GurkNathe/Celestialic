package net.gurknathe.celestialic.entity.client;

import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.entity.custom.YinKoiEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class YinKoiModel extends AnimatedGeoModel<YinKoiEntity> {
    @Override
    public Identifier getModelLocation(YinKoiEntity object) {
        return new Identifier(CelestialicMod.MOD_ID, "geo/koi.geo.json");
    }

    @Override
    public Identifier getTextureLocation(YinKoiEntity object) {
        return new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi_yin.png");
    }

    @Override
    public Identifier getAnimationFileLocation(YinKoiEntity animatable) {
        return new Identifier(CelestialicMod.MOD_ID, "animations/koi.animation.json");
    }
}
