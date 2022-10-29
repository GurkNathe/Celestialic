package net.gurknathe.celestialic.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.World;

public class YangKoiEntity extends AureateKoiEntity{
    public YangKoiEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
        super(entityType, world);
    }
}
