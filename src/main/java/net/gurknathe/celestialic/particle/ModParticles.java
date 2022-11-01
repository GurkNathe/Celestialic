package net.gurknathe.celestialic.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.gurknathe.celestialic.CelestialicMod;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModParticles {
    public static final DefaultParticleType AUREATE_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(CelestialicMod.MOD_ID, "aureate_particle"),
                AUREATE_PARTICLE);
    }
}
