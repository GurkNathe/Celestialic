package net.gurknathe.celestialic.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.gurknathe.celestialic.Celestialic;
import net.gurknathe.celestialic.entity.CelestialicEntities;
import net.gurknathe.celestialic.item.custom.ShimmeringArmorItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CelestialicItems {
    public static final Item HEAVENLY_SCALE;
    public static final Item YANG_CRYSTAL;
    public static final Item YIN_CRYSTAL;
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
                new Item(new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));
        YANG_CRYSTAL = registerItem("yang_crystal",
                new Item(new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));
        YIN_CRYSTAL = registerItem("yin_crystal",
                new Item(new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));
        SHIMMERING_SCALE = registerItem("shimmering_scale",
                new Item(new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));
        KOI_SPAWN_EGG = registerItem("koi_spawn_egg",
                new SpawnEggItem(
                        CelestialicEntities.KOI,
                        0xffffff,
                        0xfd4141,
                        new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));
        KOI_BUCKET = registerItem("bucket_of_koi",
                new EntityBucketItem(
                        CelestialicEntities.KOI,
                        Fluids.WATER,
                        SoundEvents.ITEM_BUCKET_EMPTY_FISH,
                        new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));
        RAW_KOI = registerItem("raw_koi",
                new Item(new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)
                                .food(CelestialicFoodComponents.RAW_KOI)));
        COOKED_KOI = registerItem("cooked_koi",
                new Item(new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)
                                .food(CelestialicFoodComponents.COOKED_KOI)));
        AUREATE_KOI_SPAWN_EGG = registerItem("aureate_koi_spawn_egg",
                new SpawnEggItem(
                        CelestialicEntities.AUREATE_KOI,
                        0xffbb00,
                        0x00f7ff,
                        new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));
        YANG_KOI_SPAWN_EGG = registerItem("yang_koi_spawn_egg",
                new SpawnEggItem(
                        CelestialicEntities.YANG_KOI,
                        0x000000,
                        0xffffff,
                        new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));
        YIN_KOI_SPAWN_EGG = registerItem("yin_koi_spawn_egg",
                new SpawnEggItem(
                        CelestialicEntities.YIN_KOI,
                        0xffffff,
                        0x000000,
                        new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));

        SHIMMERING_HELMET = registerItem("shimmering_helmet",
                new ShimmeringArmorItem(CelestialicArmorMaterials.SHIMMERING, EquipmentSlot.HEAD,
                        new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));

        SHIMMERING_CHESTPLATE = registerItem("shimmering_chestplate",
                new ShimmeringArmorItem(CelestialicArmorMaterials.SHIMMERING, EquipmentSlot.CHEST,
                        new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));

        SHIMMERING_GREAVES = registerItem("shimmering_greaves",
                new ShimmeringArmorItem(CelestialicArmorMaterials.SHIMMERING, EquipmentSlot.LEGS,
                        new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));

        SHIMMERING_BOOTS = registerItem("shimmering_boots",
                new ShimmeringArmorItem(CelestialicArmorMaterials.SHIMMERING, EquipmentSlot.FEET,
                        new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Celestialic.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Celestialic.LOGGER.info("Registering Mod Items for " + Celestialic.MOD_ID);
    }
}
