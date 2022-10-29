package net.gurknathe.celestialic.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.entity.ModEntities;
import net.gurknathe.celestialic.item.custom.ModArmorItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item HEAVENLY_SCALE;
    public static final Item KOI_SPAWN_EGG;
    public static final Item AUREATE_KOI_SPAWN_EGG;
    public static final Item YANG_KOI_SPAWN_EGG;
    public static final Item YIN_KOI_SPAWN_EGG;
    public static final Item KOI_BUCKET;
    public static final Item RAW_KOI;
    public static final Item COOKED_KOI;
    public static final Item SHIMMERING_SCALE;
    public static final Item SHIMMERING_HELMET;
    public static final Item SHIMMERING_CHESTPLATE;
    public static final Item SHIMMERING_GREAVES;
    public static final Item SHIMMERING_BOOTS;

    static {
        HEAVENLY_SCALE = registerItem("heavenly_scale",
                new Item(new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));
        SHIMMERING_SCALE = registerItem("shimmering_scale",
                new Item(new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));
        KOI_SPAWN_EGG = registerItem("koi_spawn_egg",
                new SpawnEggItem(
                        ModEntities.KOI,
                        0xffffff,
                        0xfd4141,
                        new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));
        KOI_BUCKET = registerItem("bucket_of_koi",
                new EntityBucketItem(
                        ModEntities.KOI,
                        Fluids.WATER,
                        SoundEvents.ITEM_BUCKET_EMPTY_FISH,
                        new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));
        RAW_KOI = registerItem("raw_koi",
                new Item(new FabricItemSettings().group(ModItemGroup.CELESTIALIC)
                                .food(ModFoodComponents.RAW_KOI)));
        COOKED_KOI = registerItem("cooked_koi",
                new Item(new FabricItemSettings().group(ModItemGroup.CELESTIALIC)
                                .food(ModFoodComponents.COOKED_KOI)));
        AUREATE_KOI_SPAWN_EGG = registerItem("aureate_koi_spawn_egg",
                new SpawnEggItem(
                        ModEntities.AUREATE_KOI,
                        0xffbb00,
                        0x00f7ff,
                        new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));
        YANG_KOI_SPAWN_EGG = registerItem("yang_koi_spawn_egg",
                new SpawnEggItem(
                        ModEntities.YANG_KOI,
                        0x000000,
                        0xffffff,
                        new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));
        YIN_KOI_SPAWN_EGG = registerItem("yin_koi_spawn_egg",
                new SpawnEggItem(
                        ModEntities.YIN_KOI,
                        0xffffff,
                        0x000000,
                        new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));

        SHIMMERING_HELMET = registerItem("shimmering_helmet",
                new ModArmorItem(ModArmorMaterials.SHIMMERING, EquipmentSlot.HEAD,
                        new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));

        SHIMMERING_CHESTPLATE = registerItem("shimmering_chestplate",
                new ArmorItem(ModArmorMaterials.SHIMMERING, EquipmentSlot.CHEST,
                        new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));

        SHIMMERING_GREAVES = registerItem("shimmering_greaves",
                new ArmorItem(ModArmorMaterials.SHIMMERING, EquipmentSlot.LEGS,
                        new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));

        SHIMMERING_BOOTS = registerItem("shimmering_boots",
                new ArmorItem(ModArmorMaterials.SHIMMERING, EquipmentSlot.FEET,
                        new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(CelestialicMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CelestialicMod.LOGGER.info("Registering Mod Items for " + CelestialicMod.MOD_ID);
    }
}
