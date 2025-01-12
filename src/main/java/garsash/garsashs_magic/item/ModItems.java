package garsash.garsashs_magic.item;

import garsash.garsashs_magic.GarsashsMagic;
import garsash.garsashs_magic.item.components.Spell;
import garsash.garsashs_magic.item.spells.FireSpellItem;
import garsash.garsashs_magic.item.wand.BasicWandItem;
import garsash.garsashs_magic.item.spells.WindSpellItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item AMETHYST_DUST = registerItem("amethyst_dust", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GarsashsMagic.MOD_ID, "amethyst_dust")))));

    public static final Item WIND_SPELL = registerItem("wind_spell", new WindSpellItem(new Item.Settings()
            .maxCount(1)
            .component(ModComponents.SPELL_COMPONENT_TYPE, new Spell.SpellComponent("garsashs_magic:wind_spell",1.0F, 0.5F))
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GarsashsMagic.MOD_ID, "wind_spell")))));

    public static final Item FIRE_SPELL = registerItem("fire_spell", new FireSpellItem(new Item.Settings()
            .maxCount(1)
            .component(ModComponents.SPELL_COMPONENT_TYPE, new Spell.SpellComponent("garsashs_magic:fire_spell",1.0F, 0.5F))
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GarsashsMagic.MOD_ID, "fire_spell")))));

    public static final Item BASIC_WAND = registerItem("basic_wand", new BasicWandItem(new Item.Settings()
            .maxCount(1)
            .useCooldown(1.0F)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GarsashsMagic.MOD_ID, "basic_wand")))));


    private  static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GarsashsMagic.MOD_ID, name), item);

    }


    public static void registerModItems() {
        GarsashsMagic.LOGGER.info("Registering Mod Items for " + GarsashsMagic.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(AMETHYST_DUST);
        });

        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.MAGIC_ITEM_GROUP_KEY).register(entries -> {
            entries.add(BASIC_WAND);
            entries.add(WIND_SPELL);
            entries.add(FIRE_SPELL);
        });
    }
}
