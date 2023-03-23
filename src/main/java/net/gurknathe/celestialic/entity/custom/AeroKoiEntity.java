package net.gurknathe.celestialic.entity.custom;

import net.gurknathe.celestialic.particle.CelestialicParticles;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.*;

public class AeroKoiEntity extends FlyingEntity implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);
    Vec3d targetPosition;

    public AeroKoiEntity(EntityType<? extends FlyingEntity> entityType, World world) {
        super(entityType, world);
        this.targetPosition = Vec3d.ZERO;
        this.experiencePoints = 5;
        this.moveControl = new FlightMoveControl(this, 10, true);
    }
    public static DefaultAttributeContainer.Builder setAttributes() {
        return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 14.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,3.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0f)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 4.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0f);
    }


    protected BodyControl createBodyControl() {
        return new AeroKoiEntity.AeroKoiBodyControl(this);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(5, new AeroKoiEntity.FlyRandomlyGoal(this));
        this.targetSelector.add(1, new AeroKoiEntity.FindTargetGoal());
    }

    /* Gekolib animation controllers */
    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder()
                .addAnimation("animation.koi.idle", true));
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
        return false;
    }

    protected boolean isDisallowedInPeaceful() {
        return true;
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

        super.tickMovement();
    }

    private class AeroKoiBodyControl extends BodyControl {
        public AeroKoiBodyControl(MobEntity entity) {
            super(entity);
        }

        public void tick() {
            AeroKoiEntity.this.headYaw = AeroKoiEntity.this.bodyYaw;
            AeroKoiEntity.this.bodyYaw = AeroKoiEntity.this.getYaw();
        }
    }

    private class FlyRandomlyGoal extends MovementGoal {
        private final AeroKoiEntity koi;

        public FlyRandomlyGoal(AeroKoiEntity koi) {
            this.koi = koi;
        }

        public boolean canStart() {
            MoveControl moveControl = this.koi.getMoveControl();
            if (!moveControl.isMoving()) {
                return true;
            } else {
                double d = moveControl.getTargetX() - this.koi.getX();
                double e = moveControl.getTargetY() - this.koi.getY();
                double f = moveControl.getTargetZ() - this.koi.getZ();
                double g = d * d + e * e + f * f;
                return g < 1.0 || g > 3600.0;
            }
        }

        public boolean shouldContinue() {
            return false;
        }

        public void start() {
            Random random = this.koi.getRandom();
            double d = this.koi.getX() + (double)((random.nextFloat() * 2.0F - 1.0F));
            double e = this.koi.getY() + (double)((random.nextFloat() * 2.0F - 1.0F));
            double f = this.koi.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F));
            this.koi.getMoveControl().moveTo(d, e, f, 4.0);
        }
    }

    abstract class MovementGoal extends Goal {
        public MovementGoal() {
            this.setControls(EnumSet.of(Control.MOVE));
        }

        protected boolean isNearTarget() {
            return AeroKoiEntity.this.targetPosition.squaredDistanceTo(AeroKoiEntity.this.getX(), AeroKoiEntity.this.getY(), AeroKoiEntity.this.getZ()) < 4.0;
        }
    }

    class FindTargetGoal extends Goal {
        private final TargetPredicate PLAYERS_IN_RANGE_PREDICATE = TargetPredicate.createAttackable().setBaseMaxDistance(64.0);
        private int delay = toGoalTicks(20);

        FindTargetGoal() {
        }

        public boolean canStart() {
            if (this.delay > 0) {
                --this.delay;
                return false;
            } else {
                this.delay = toGoalTicks(60);
                List<PlayerEntity> list = AeroKoiEntity.this.world.getPlayers(this.PLAYERS_IN_RANGE_PREDICATE, AeroKoiEntity.this, AeroKoiEntity.this.getBoundingBox().expand(16.0, 64.0, 16.0));
                if (!list.isEmpty()) {
                    list.sort(Comparator.comparing(Entity::getY).reversed());
                    Iterator var2 = list.iterator();

                    while(var2.hasNext()) {
                        PlayerEntity playerEntity = (PlayerEntity)var2.next();
                        if (AeroKoiEntity.this.isTarget(playerEntity, TargetPredicate.DEFAULT)) {
                            AeroKoiEntity.this.setTarget(playerEntity);
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        public boolean shouldContinue() {
            LivingEntity livingEntity = AeroKoiEntity.this.getTarget();
            return livingEntity != null ? AeroKoiEntity.this.isTarget(livingEntity, TargetPredicate.DEFAULT) : false;
        }
    }
}
