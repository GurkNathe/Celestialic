package net.gurknathe.celestialic.entity.client;

import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.entity.custom.YinKoiEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class YinKoiRenderer extends GeoEntityRenderer<YinKoiEntity> {
    public YinKoiRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new YinKoiModel());
    }



    @Override
    public Identifier getTextureLocation(YinKoiEntity instance) {
        return new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi_yin.png");
    }

    @Override
    public RenderLayer getRenderType(YinKoiEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {

        stack.scale(1.25f,1.25f,1.25f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder,
                packedLightIn, textureLocation);
    }
}
