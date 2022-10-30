package net.gurknathe.celestialic.entity.client.armor;

import net.gurknathe.celestialic.item.custom.ShimmeringArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ShimmeringArmorRenderer extends GeoArmorRenderer<ShimmeringArmorItem> {
    public ShimmeringArmorRenderer() {
        super(new ShimmeringArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}
