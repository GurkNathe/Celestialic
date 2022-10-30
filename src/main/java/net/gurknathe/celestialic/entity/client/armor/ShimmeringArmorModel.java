package net.gurknathe.celestialic.entity.client.armor;

import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.item.custom.ShimmeringArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShimmeringArmorModel extends AnimatedGeoModel<ShimmeringArmorItem> {

    @Override
    public Identifier getModelLocation(ShimmeringArmorItem object) {
        return new Identifier(CelestialicMod.MOD_ID, "geo/shimmering_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(ShimmeringArmorItem object) {
        return new Identifier(CelestialicMod.MOD_ID, "textures/models/armor/shimmering_armor.png");
    }

    @Override
    public Identifier getAnimationFileLocation(ShimmeringArmorItem animatable) {
        return new Identifier(CelestialicMod.MOD_ID, "animations/armor_animation.json");
    }
}
