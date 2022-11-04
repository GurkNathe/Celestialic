package net.gurknathe.celestialic.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class AureateParticle extends SpriteBillboardParticle {
    private final SpriteProvider spriteProvider;
    protected AureateParticle(ClientWorld world, double xCoord, double yCoord, double zCoord,
                              double xd, double yd, double zd, SpriteProvider spriteProvider) {
        super(world, xCoord, yCoord, zCoord, xd, yd, zd);
        this.spriteProvider = spriteProvider;

        this.velocityMultiplier = 0.5F;
        this.x = xd;
        this.y = yd;
        this.z = zd;
        this.scale *= 0.75F;
        this.maxAge = 10;
        this.red = 1f;
        this.green = 1f;
        this.blue = 1f;

        this.setSpriteForAge(spriteProvider);
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteForAge(this.spriteProvider);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new AureateParticle(level, x, y, z, dx, dy, dz, this.sprites);
        }
    }
}
