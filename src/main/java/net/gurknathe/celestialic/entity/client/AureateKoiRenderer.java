package net.gurknathe.celestialic.entity.client;

import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.entity.custom.AureateKoiEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AureateKoiRenderer extends GeoEntityRenderer<AureateKoiEntity> {
    public AureateKoiRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new AureateKoiModel<>());
    }

    @Override
    public Identifier getTextureLocation(AureateKoiEntity instance) {
        return new Identifier(CelestialicMod.MOD_ID, "textures/entity/koi_aureate.png");
    }

    @Override
    public RenderLayer getRenderType(AureateKoiEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {

        stack.scale(1.25f,1.25f,1.25f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder,
                packedLightIn, textureLocation);
    }
}
