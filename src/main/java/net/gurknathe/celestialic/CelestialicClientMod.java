package net.gurknathe.celestialic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.gurknathe.celestialic.entity.ModEntities;
import net.gurknathe.celestialic.entity.client.AureateKoiRenderer;
import net.gurknathe.celestialic.entity.client.KoiRenderer;
import net.gurknathe.celestialic.entity.client.YangKoiRenderer;
import net.gurknathe.celestialic.entity.client.YinKoiRenderer;

public class CelestialicClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.KOI, KoiRenderer::new);
        EntityRendererRegistry.register(ModEntities.AUREATE_KOI, AureateKoiRenderer::new);
        EntityRendererRegistry.register(ModEntities.YANG_KOI, YangKoiRenderer::new);
        EntityRendererRegistry.register(ModEntities.YIN_KOI, YinKoiRenderer::new);
    }
}
