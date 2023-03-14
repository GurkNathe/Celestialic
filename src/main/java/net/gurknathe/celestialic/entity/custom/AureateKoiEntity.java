package net.gurknathe.celestialic.entity.custom;

import net.gurknathe.celestialic.particle.CelestialicParticles;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.EnumSet;
import java.util.Random;

public class AureateKoiEntity extends NeutralWaterMob implements IAnimatable {
    /* For model animation and rendering */
    private final AnimationFactory factory = new AnimationFactory(this);

    public AureateKoiEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 14.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,3.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 4.0f);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(2, new RangedAttackGoal(this));
        this.goalSelector.add(4, new BreatheAirGoal(this));
    }

    /* Gekolib animation controllers */
    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (!this.isTouchingWater()) {
            event.getController().setAnimation(new AnimationBuilder()
                    .addAnimation("animation.koi.flop", true));
        } else {
            event.getController().setAnimation(new AnimationBuilder()
                    .addAnimation("animation.koi.idle", true));
        }

        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    /* Sounds */

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_COD_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_COD_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COD_DEATH;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_FISH_SWIM;
    }

    /* From FishEntity */

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return dimensions.height * 0.65F;
    }

    public boolean cannotDespawn() {
        return true;
    }

    protected EntityNavigation createNavigation(World world) {
        return new SwimNavigation(this, world);
    }

    public void travel(Vec3d movementInput) {
        if (this.canMoveVoluntarily() && this.isTouchingWater()) {
            this.updateVelocity(0.01F, movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9));
            if (this.getTarget() == null) {
                this.setVelocity(this.getVelocity().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(movementInput);
        }
    }

    public void tickMovement() {
        if (!this.isTouchingWater() && this.onGround && this.verticalCollision) {
            this.setVelocity(this.getVelocity().add(((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F),
                    0.4, ((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
            this.onGround = false;
            this.velocityDirty = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getSoundPitch());
        }

        if (this.world.isClient) {
            if (this.random.nextDouble() > 0.85) {
                this.world.addParticle(CelestialicParticles.AUREATE_PARTICLE,
                        this.getParticleX(0.5),
                        this.getRandomBodyY(),
                        this.getParticleZ(0.5),

                        (this.random.nextDouble() - 0.5),
                        0,
                        (this.random.nextDouble() - 0.5)
                );
            }
        }

        if (!this.world.isClient) {
            this.tickAngerLogic((ServerWorld)this.world, true);
        }

        super.tickMovement();
    }

    private static class RangedAttackGoal extends Goal {
        private final AureateKoiEntity koi;
        private int counter;


        public RangedAttackGoal(AureateKoiEntity koi) {
            this.koi = koi;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        public boolean canStart() {
            LivingEntity livingEntity = this.koi.getTarget();
            if (livingEntity != null && livingEntity.isAlive()) {
                return this.koi.getAngryAt() != null;
            } else {
                return false;
            }
        }

        public void start() {
            this.counter = 20;
        }

        public void stop() {}

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            if (this.koi.world.getDifficulty() != Difficulty.PEACEFUL) {
                --this.counter;
                LivingEntity livingEntity = this.koi.getTarget();
                if (livingEntity != null) {
                    this.koi.getLookControl().lookAt(livingEntity, 180.0F, 180.0F);
                    if (this.koi.squaredDistanceTo(livingEntity) > 25.0) {
                        if (this.counter <= 25) {
                            this.counter = 20 + this.koi.random.nextInt(10) * 20 / 2;
                            // Add ranged attack entity here
                            this.koi.playSound(SoundEvents.ENTITY_SHULKER_SHOOT, 2.0F, (this.koi.random.nextFloat() - this.koi.random.nextFloat()) * 0.2F + 1.0F);
                            this.koi.world.spawnEntity(new ShulkerBulletEntity(this.koi.world, this.koi, livingEntity, Direction.Axis.pickRandomAxis(new Random())));
                        }
                    } else {
                        this.koi.setTarget(null);
                    }

                    super.tick();
                }
            }
        }
    }
}
