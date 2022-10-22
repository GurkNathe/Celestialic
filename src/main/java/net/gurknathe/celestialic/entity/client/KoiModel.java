package net.gurknathe.celestialic.entity.client;

import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.entity.custom.KoiEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KoiModel extends AnimatedGeoModel<KoiEntity> {
    @Override
    public Identifier getModelLocation(KoiEntity object) {
        return new Identifier(CelestialicMod.MOD_ID, "geo/koi.geo.json");
    }

    @Override
    public Identifier getTextureLocation(KoiEntity object) {
        return new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi/koi_base.png");
    }

    @Override
    public Identifier getAnimationFileLocation(KoiEntity animatable) {
        return new Identifier(CelestialicMod.MOD_ID, "animations/koi.animation.json");
    }
}
