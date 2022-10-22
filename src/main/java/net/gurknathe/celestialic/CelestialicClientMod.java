package net.gurknathe.celestialic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.gurknathe.celestialic.entity.ModEntities;
import net.gurknathe.celestialic.entity.client.KoiRenderer;

public class CelestialicClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.KOI, KoiRenderer::new);
    }
}
