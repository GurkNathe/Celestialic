package net.gurknathe.celestialic;

import net.fabricmc.api.ModInitializer;
import net.gurknathe.celestialic.block.ModBlocks;
import net.gurknathe.celestialic.item.ModItems;
import net.gurknathe.celestialic.particle.ModParticles;
import net.gurknathe.celestialic.util.ModRegistries;
import net.gurknathe.celestialic.world.gen.ModWorldGen;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class CelestialicMod implements ModInitializer {
	public static final String MOD_ID = "celestialic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static TagKey<Item> PIGLIN_SAFE_ARMOR = TagKey.of(Registry.ITEM_KEY,
			new Identifier(MOD_ID, "piglin_safe_armor"));

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();

		ModWorldGen.generateModWorld();

		ModParticles.registerParticles();

		GeckoLib.initialize();

	}
}
