package net.gurknathe.celestialic.entity.client;

import net.gurknathe.celestialic.Celestialic;
import net.gurknathe.celestialic.entity.custom.AureateKoiEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AureateKoiModel extends AnimatedGeoModel<AureateKoiEntity> {
    @Override
    public Identifier getModelLocation(AureateKoiEntity object) {
        return new Identifier(Celestialic.MOD_ID, "geo/koientity.geo.json");
    }

    @Override
    public Identifier getTextureLocation(AureateKoiEntity object) {
        return new Identifier(Celestialic.MOD_ID, "textures/entity/koi_aureate.png");
    }

    @Override
    public Identifier getAnimationFileLocation(AureateKoiEntity animatable) {
        return new Identifier(Celestialic.MOD_ID, "animations/koientity.animation.json");
    }
}
