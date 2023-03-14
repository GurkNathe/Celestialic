package net.gurknathe.celestialic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.gurknathe.celestialic.block.CelestialicBlocks;
import net.gurknathe.celestialic.entity.CelestialicEntities;
import net.gurknathe.celestialic.entity.client.AureateKoiRenderer;
import net.gurknathe.celestialic.entity.client.KoiRenderer;
import net.gurknathe.celestialic.entity.client.YangKoiRenderer;
import net.gurknathe.celestialic.entity.client.YinKoiRenderer;
import net.gurknathe.celestialic.entity.client.armor.ShimmeringArmorRenderer;
import net.gurknathe.celestialic.item.CelestialicItems;
import net.gurknathe.celestialic.particle.CelestialicParticles;
import net.gurknathe.celestialic.particle.custom.AureateParticle;
import net.minecraft.client.render.RenderLayer;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CelestialicClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(CelestialicEntities.KOI, KoiRenderer::new);
        EntityRendererRegistry.register(CelestialicEntities.AUREATE_KOI, AureateKoiRenderer::new);
        EntityRendererRegistry.register(CelestialicEntities.YANG_KOI, YangKoiRenderer::new);
        EntityRendererRegistry.register(CelestialicEntities.YIN_KOI, YinKoiRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(CelestialicBlocks.CELESTIAL_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CelestialicBlocks.CELESTIAL_SAPLING, RenderLayer.getCutout());

        ParticleFactoryRegistry.getInstance().register(CelestialicParticles.AUREATE_PARTICLE, AureateParticle.Factory::new);

        GeoArmorRenderer.registerArmorRenderer(new ShimmeringArmorRenderer(), CelestialicItems.SHIMMERING_BOOTS,
                CelestialicItems.SHIMMERING_GREAVES, CelestialicItems.SHIMMERING_CHESTPLATE, CelestialicItems.SHIMMERING_HELMET);
    }
}
