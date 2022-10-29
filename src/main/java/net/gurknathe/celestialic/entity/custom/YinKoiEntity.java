package net.gurknathe.celestialic.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.world.World;

public class YinKoiEntity extends KoiEntity {
    public YinKoiEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
        super(entityType, world);
    }
}
