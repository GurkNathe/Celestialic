package net.gurknathe.celestialic.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.entity.ModEntities;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item HEAVENLY_SCALE = registerItem("heavenly_scale",
            new Item(new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));

    public static final Item KOI_SPAWN_EGG = registerItem("koi_spawn_egg",
            new SpawnEggItem(ModEntities.KOI,0xffffff, 0xfd4141,
                    new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));

    public static final Item KOI_BUCKET = registerItem("bucket_of_koi",
            new EntityBucketItem(ModEntities.KOI, Fluids.WATER,
                    SoundEvents.ITEM_BUCKET_EMPTY_FISH,
                    new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));

    public static final Item RAW_KOI = registerItem("raw_koi",
            new Item(new FabricItemSettings().group(ModItemGroup.CELESTIALIC).food(ModFoodComponents.RAW_KOI)));

    public static final Item COOKED_KOI = registerItem("cooked_koi",
            new Item(new FabricItemSettings().group(ModItemGroup.CELESTIALIC).food(ModFoodComponents.COOKED_KOI)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(CelestialicMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CelestialicMod.LOGGER.info("Registering Mod Items for " + CelestialicMod.MOD_ID);
    }
}
