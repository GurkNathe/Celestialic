package net.gurknathe.celestialic.entity.client;

import net.gurknathe.celestialic.Celestialic;
import net.gurknathe.celestialic.entity.custom.AeroKoiEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AeroKoiRenderer extends GeoEntityRenderer<AeroKoiEntity> {
    public AeroKoiRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new AeroKoiModel());
    }

    @Override
    public Identifier getTextureLocation(AeroKoiEntity instance) {
        return new Identifier(Celestialic.MOD_ID, "textures/entity/koi_aero.png");
    }

    @Override
    public RenderLayer getRenderType(AeroKoiEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {

        stack.scale(1.25f,1.25f,1.25f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder,
                packedLightIn, textureLocation);
    }
}
