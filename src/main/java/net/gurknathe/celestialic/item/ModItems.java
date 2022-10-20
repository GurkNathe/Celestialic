package net.gurknathe.celestialic.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.gurknathe.celestialic.CelestialicMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

//    public static final Item CELESTIAL_GRASS = registerItem("celestial_grass",
//            new Item(new FabricItemSettings().group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(CelestialicMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CelestialicMod.LOGGER.info("Registering Mod Items for " + CelestialicMod.MOD_ID);
    }
}
