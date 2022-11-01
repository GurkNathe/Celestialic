package net.gurknathe.celestialic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.gurknathe.celestialic.entity.ModEntities;
import net.gurknathe.celestialic.entity.client.AureateKoiRenderer;
import net.gurknathe.celestialic.entity.client.KoiRenderer;
import net.gurknathe.celestialic.entity.client.YangKoiRenderer;
import net.gurknathe.celestialic.entity.client.YinKoiRenderer;
import net.gurknathe.celestialic.entity.client.armor.ShimmeringArmorRenderer;
import net.gurknathe.celestialic.item.ModItems;
import net.gurknathe.celestialic.particle.ModParticles;
import net.gurknathe.celestialic.particle.custom.AureateParticle;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CelestialicClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.KOI, KoiRenderer::new);
        EntityRendererRegistry.register(ModEntities.AUREATE_KOI, AureateKoiRenderer::new);
        EntityRendererRegistry.register(ModEntities.YANG_KOI, YangKoiRenderer::new);
        EntityRendererRegistry.register(ModEntities.YIN_KOI, YinKoiRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.AUREATE_PARTICLE, AureateParticle.Factory::new);

        GeoArmorRenderer.registerArmorRenderer(new ShimmeringArmorRenderer(), ModItems.SHIMMERING_BOOTS,
                ModItems.SHIMMERING_GREAVES, ModItems.SHIMMERING_CHESTPLATE, ModItems.SHIMMERING_HELMET);
    }
}
