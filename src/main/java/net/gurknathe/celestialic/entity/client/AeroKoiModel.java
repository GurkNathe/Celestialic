package net.gurknathe.celestialic.entity.client;

import net.gurknathe.celestialic.Celestialic;
import net.gurknathe.celestialic.entity.custom.AeroKoiEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AeroKoiModel extends AnimatedGeoModel<AeroKoiEntity> {
    @Override
    public Identifier getModelLocation(AeroKoiEntity object) {
        return new Identifier(Celestialic.MOD_ID, "geo/koientity.geo.json");
    }

    @Override
    public Identifier getTextureLocation(AeroKoiEntity object) {
        return new Identifier(Celestialic.MOD_ID, "textures/entity/koi_aero.png");
    }

    @Override
    public Identifier getAnimationFileLocation(AeroKoiEntity animatable) {
        return new Identifier(Celestialic.MOD_ID, "animations/koientity.animation.json");
    }
}
