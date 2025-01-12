package garsash.garsashs_magic.util;

import garsash.garsashs_magic.GarsashsMagic;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> SPELLS = createTag("spells");
    public static final TagKey<Item> WANDS = createTag("wands");

    private static TagKey<Item> createTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(GarsashsMagic.MOD_ID, name));
    }
}
