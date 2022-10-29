package net.gurknathe.celestialic.entity.client;

import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.entity.custom.YangKoiEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class YangKoiRenderer extends GeoEntityRenderer<YangKoiEntity> {

    public YangKoiRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new YangKoiModel());
    }


    @Override
    public Identifier getTextureLocation(YangKoiEntity instance) {
        return new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi_yang.png");
    }

    @Override
    public RenderLayer getRenderType(YangKoiEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {

        stack.scale(1.25f,1.25f,1.25f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder,
                packedLightIn, textureLocation);
    }
}
