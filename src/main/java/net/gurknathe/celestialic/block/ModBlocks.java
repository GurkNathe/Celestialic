package net.gurknathe.celestialic.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.block.custom.CelestialGrass;
import net.gurknathe.celestialic.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final CelestialGrass CELESTIAL_GRASS = (CelestialGrass)registerBlock("celestial_grass",
            new CelestialGrass(FabricBlockSettings.of(Material.SOIL).strength(2f).requiresTool()), ModItemGroup.CELESTIALIC);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(CelestialicMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(CelestialicMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        CelestialicMod.LOGGER.info("Registering ModBlocks for " + CelestialicMod.MOD_ID);
    }
}
