package garsash.garsashs_magic;

import garsash.garsashs_magic.item.ModComponents;
import garsash.garsashs_magic.item.ModItemGroups;
import garsash.garsashs_magic.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GarsashsMagic implements ModInitializer {
	public static final String MOD_ID = "garsashs_magic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();

		ModComponents.registerModComponents();

		ModItems.registerModItems();
	}
}