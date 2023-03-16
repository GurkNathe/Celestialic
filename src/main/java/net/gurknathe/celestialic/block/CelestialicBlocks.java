package net.gurknathe.celestialic.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.gurknathe.celestialic.Celestialic;
import net.gurknathe.celestialic.block.custom.CelestialGrass;
import net.gurknathe.celestialic.item.CelestialicItemGroup;
import net.gurknathe.celestialic.world.feature.tree.CelestialSapplingGenerator;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CelestialicBlocks {
    // Default settings for a custom grass block
    public static final AbstractBlock.Settings GRASS_BLOCK = FabricBlockSettings.of(Material.SOLID_ORGANIC).sounds(BlockSoundGroup.GRASS).ticksRandomly();

    public static final Block CELESTIAL_GRASS = registerBlock("celestial_grass",
            new CelestialGrass(FabricBlockSettings.copyOf(GRASS_BLOCK).strength(1f).resistance(3f).requiresTool()));

    public static final Block CELESTIAL_LOG = registerBlock("celestial_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));
    public static final Block CELESTIAL_WOOD = registerBlock("celestial_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_CELESTIAL_LOG = registerBlock("stripped_celestial_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_CELESTIAL_WOOD = registerBlock("stripped_celestial_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block CELESTIAL_PLANKS = registerBlock("celestial_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block CELESTIAL_LEAVES = registerBlock("celestial_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)));

    public static final Block CELESTIAL_SAPLING = registerBlock("celestial_sapling",
            new SaplingBlock(new CelestialSapplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)));

    public static final Block MAGNOLIA = registerBlock("magnolia",
            new FlowerBlock(StatusEffects.SATURATION, 5, FabricBlockSettings.copy(Blocks.DANDELION)));

    public static final Block POTTED_MAGNOLIA = registerBlockWithoutItem("potted_magnolia",
            new FlowerPotBlock(CelestialicBlocks.MAGNOLIA, FabricBlockSettings.copy(Blocks.POTTED_DANDELION)));

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(Celestialic.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(Celestialic.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(Celestialic.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(CelestialicItemGroup.CELESTIALIC)));
    }

    public static void registerModBlocks() {
        Celestialic.LOGGER.info("Registering ModBlocks for " + Celestialic.MOD_ID);
    }
}
