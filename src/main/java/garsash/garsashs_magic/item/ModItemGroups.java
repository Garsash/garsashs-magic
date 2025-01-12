package garsash.garsashs_magic.item;

import garsash.garsashs_magic.GarsashsMagic;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> MAGIC_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(GarsashsMagic.MOD_ID, "magic_item_group"));

    public static final ItemGroup MAGIC_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.AMETHYST_DUST))
            .displayName(Text.translatable("itemGroup.garsashs_magic.magic_item_group"))
            .build();

    public static void registerModItemGroups() {
        Registry.register(Registries.ITEM_GROUP, MAGIC_ITEM_GROUP_KEY, MAGIC_ITEM_GROUP);
    }
}
