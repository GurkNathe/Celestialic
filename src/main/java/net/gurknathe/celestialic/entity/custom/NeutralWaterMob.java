package net.gurknathe.celestialic.entity.custom;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class NeutralWaterMob extends WaterCreatureEntity implements Angerable {

    /* For neutral mob function */
    private static final UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);
    @Nullable
    private UUID angryAt;
    private static final TrackedData<Integer> ANGER = DataTracker.registerData(NeutralWaterMob.class,
            TrackedDataHandlerRegistry.INTEGER);
    protected NeutralWaterMob(EntityType<? extends WaterCreatureEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FishMoveControl(this);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2, true));
        this.goalSelector.add(2, new MoveIntoWaterGoal(this));
        this.goalSelector.add(4, new WanderAroundGoal(this, 1.0, 80));
        this.targetSelector.add(3, new TargetGoal(this));
        this.targetSelector.add(4, new RevengeGoal(this, new Class[0]));
    }

    @Override
    public void writeAngerToNbt(NbtCompound nbt) {
        Angerable.super.writeAngerToNbt(nbt);
    }

    @Override
    public void readAngerFromNbt(World world, NbtCompound nbt) {
        Angerable.super.readAngerFromNbt(world, nbt);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ANGER, 0);
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.setAngryAt(null);
        this.setAngerTime(0);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    /* Neutral Mob Handling */

    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }

    public void setAngerTime(int angerTime) {
        this.dataTracker.set(ANGER, angerTime);
    }

    public int getAngerTime() {
        return this.dataTracker.get(ANGER);
    }

    public void setAngryAt(@Nullable UUID angryAt) {
        this.angryAt = angryAt;
    }

    @Nullable
    public UUID getAngryAt() {
        return this.angryAt;
    }

    @Override
    public void tickAngerLogic(ServerWorld world, boolean angerPersistent) {
        Angerable.super.tickAngerLogic(world, angerPersistent);
    }

    public boolean shouldAngerAt(LivingEntity entity) {
        if (!this.canTarget(entity)) {
            return false;
        } else {
            return entity.getType() == EntityType.PLAYER && this.isUniversallyAngry(entity.world) ||
                    entity.getUuid().equals(this.getAngryAt());
        }
    }


    public boolean hasAngerTime() {
        return this.getAngerTime() > 0;
    }

    /* Extra Stuff */

    private static class TargetGoal extends ActiveTargetGoal<PlayerEntity> {

        TargetGoal(NeutralWaterMob aKoi) {
            super(aKoi, PlayerEntity.class, 10, true,
                    false, aKoi::shouldAngerAt);
        }

        public boolean canStart() {
            return this.angry() && super.canStart();
        }

        public boolean shouldContinue() {
            boolean bl = this.angry();
            if (bl && this.mob.getTarget() != null) {
                return super.shouldContinue();
            } else {
                this.target = null;
                return false;
            }
        }

        public boolean angry() {
            NeutralWaterMob koi = (NeutralWaterMob)this.mob;
            return koi.hasAngerTime();
        }
    }

    static class FishMoveControl extends MoveControl {
        private final WaterCreatureEntity fish;

        FishMoveControl(WaterCreatureEntity owner) {
            super(owner);
            this.fish = owner;
        }

        public void tick() {
            if (this.fish.isSubmergedIn(FluidTags.WATER)) {
                this.fish.setVelocity(this.fish.getVelocity().add(0.0, 0.005, 0.0));
            }

            if (this.state == State.MOVE_TO && !this.fish.getNavigation().isIdle()) {
                float f = (float)(this.speed * this.fish.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
                this.fish.setMovementSpeed(MathHelper.lerp(0.125F, this.fish.getMovementSpeed(), f));
                double d = this.targetX - this.fish.getX();
                double e = this.targetY - this.fish.getY();
                double g = this.targetZ - this.fish.getZ();
                if (e != 0.0) {
                    double h = Math.sqrt(d * d + e * e + g * g);
                    this.fish.setVelocity(this.fish.getVelocity().add(0.0,
                            (double)this.fish.getMovementSpeed() * (e / h) * 0.1, 0.0));
                }

                if (d != 0.0 || g != 0.0) {
                    float i = (float)(MathHelper.atan2(g, d) * 57.2957763671875) - 90.0F;
                    this.fish.setYaw(this.wrapDegrees(this.fish.getYaw(), i, 90.0F));
                    this.fish.bodyYaw = this.fish.getYaw();
                }

            } else {
                this.fish.setMovementSpeed(0.0F);
            }
        }
    }
}
