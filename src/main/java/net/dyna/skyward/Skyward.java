package net.dyna.skyward;

import net.dyna.skyward.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Skyward implements ModInitializer {
	public static final String MOD_ID = "skyward";
    public static final Logger LOGGER = LoggerFactory.getLogger("skyward");

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
	}
}