package net.gurknathe.celestialic;

import net.fabricmc.api.ModInitializer;
import net.gurknathe.celestialic.block.ModBlocks;
import net.gurknathe.celestialic.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CelestialicMod implements ModInitializer {
	public static final String MOD_ID = "celestialic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
