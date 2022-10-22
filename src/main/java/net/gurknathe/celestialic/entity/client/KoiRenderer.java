package net.gurknathe.celestialic.entity.client;

import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.entity.custom.KoiEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class KoiRenderer extends GeoEntityRenderer<KoiEntity> {
    public KoiRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new KoiModel());
    }

    @Override
    public Identifier getTextureLocation(KoiEntity instance) {
        return new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi/koi_base.png");
    }
}
