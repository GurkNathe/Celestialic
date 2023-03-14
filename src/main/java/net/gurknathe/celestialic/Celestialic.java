package net.gurknathe.celestialic;

import net.fabricmc.api.ModInitializer;
import net.gurknathe.celestialic.block.CelestialicBlocks;
import net.gurknathe.celestialic.item.CelestialicItems;
import net.gurknathe.celestialic.particle.CelestialicParticles;
import net.gurknathe.celestialic.util.CelestialicFlammableBlocks;
import net.gurknathe.celestialic.util.CelestialicStrippableBlocks;
import net.gurknathe.celestialic.util.CelestialicRegistries;
import net.gurknathe.celestialic.world.feature.CelestialicConfiguredFeatures;
import net.gurknathe.celestialic.world.gen.CelestialicWorldGen;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class Celestialic implements ModInitializer {
	public static final String MOD_ID = "celestialic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static TagKey<Item> PIGLIN_SAFE_ARMOR = TagKey.of(Registry.ITEM_KEY,
			new Identifier(MOD_ID, "piglin_safe_armor"));

	@Override
	public void onInitialize() {
		CelestialicConfiguredFeatures.registerConfiguredFeatures();

		CelestialicItems.registerModItems();
		CelestialicBlocks.registerModBlocks();

		CelestialicRegistries.registerModStuffs();

		CelestialicWorldGen.generateWorldGen();

		CelestialicParticles.registerParticles();

		CelestialicFlammableBlocks.registerFlammableBlocks();
		CelestialicStrippableBlocks.registerStrippables();

		GeckoLib.initialize();

	}
}
