package net.gurknathe.celestialic.entity.custom;

import net.gurknathe.celestialic.entity.variant.KoiVariant;
import net.gurknathe.celestialic.item.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class KoiEntity extends SchoolingFishEntity implements IAnimatable {
    private static final TrackedData<Boolean> FROM_BUCKET =
            DataTracker.registerData(KoiEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(KoiEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private AnimationFactory factory = new AnimationFactory(this);

    public KoiEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty,
                                 SpawnReason spawnReason, @Nullable EntityData entityData,
                                 @Nullable NbtCompound entityNbt) {
        super.initialize(world, difficulty, spawnReason, entityData, entityNbt);

        /*
        * From TropicalFishEntity :
        *   checks if koi was picked up by a bucket or not
        *   and spawns the variant koi accordingly
        */
        if (spawnReason == SpawnReason.BUCKET && entityNbt != null && entityNbt.contains("BucketVariantTag", 3)) {
            this.setVariant(KoiVariant.byId(entityNbt.getInt("BucketVariantTag")));
            return entityData;
        }

        /*
        * From SchoolingFishEntity :
        *   used to check whether there is a group of koi to follow,
        *   if not, makes this the new leader
        */
        if (entityData == null) {
            entityData = new FishData(this);
        } else {
            this.joinGroupOf(((FishData)entityData).leader);
        }

        // Gets a random koi morph for this koi
        KoiVariant variant = Util.getRandom(KoiVariant.values(), this.random);
        setVariant(variant);

        return entityData;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
        nbt.putBoolean("FromBucket", this.dataTracker.get(FROM_BUCKET));
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
        this.dataTracker.set(FROM_BUCKET, nbt.getBoolean("FromBucket"));
    }

    @Override
    public void copyDataToStack(ItemStack stack) {
        super.copyDataToStack(stack);
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        nbtCompound.putInt("BucketVariantTag", this.dataTracker.get(DATA_ID_TYPE_VARIANT));
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(DATA_ID_TYPE_VARIANT, 0);
        this.dataTracker.startTracking(FROM_BUCKET, false);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return SchoolingFishEntity.createFishAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0f);
    }

    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new MoveIntoWaterGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 5));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, PlayerEntity.class,
                20.0f, 1, 10));
        this.goalSelector.add(2, new BreatheAirGoal(this));
    }

    /* Variants controllers */

    public KoiVariant getVariant() {
        return KoiVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(KoiVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    /* Gekolib animation controllers */

    private <E extends IAnimatable>PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder()
                .addAnimation("animation.koi.idle", true));

        return PlayState.CONTINUE;
    }

    @SuppressWarnings({ "unsafe" })
    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    /* Sound functions */

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

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }

    /* Extra features */

    public boolean canBeLeashedBy(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModItems.KOI_BUCKET);
    }
}
