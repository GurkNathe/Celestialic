package net.gurknathe.celestialic.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.gurknathe.celestialic.CelestialicMod;
import net.gurknathe.celestialic.block.custom.CelestialGrass;
import net.gurknathe.celestialic.item.ModItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    // Default settings for a custom grass block
    public static final AbstractBlock.Settings GRASS_BLOCK = FabricBlockSettings.of(Material.SOLID_ORGANIC).sounds(BlockSoundGroup.GRASS).ticksRandomly();

    public static final Block CELESTIAL_GRASS = registerBlock("celestial_grass",
            new CelestialGrass(FabricBlockSettings.copyOf(GRASS_BLOCK).strength(2f).resistance(3f).requiresTool()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(CelestialicMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(CelestialicMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.CELESTIALIC)));
    }

    public static void registerModBlocks() {
        CelestialicMod.LOGGER.info("Registering ModBlocks for " + CelestialicMod.MOD_ID);
    }
}
