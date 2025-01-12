package garsash.garsashs_magic.item;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import garsash.garsashs_magic.GarsashsMagic;
import garsash.garsashs_magic.item.components.Spell;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModComponents {

    public static final ComponentType<Spell.SpellComponent> SPELL_COMPONENT_TYPE = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(GarsashsMagic.MOD_ID, "spell"),
            ComponentType.<Spell.SpellComponent>builder().codec(Spell.SpellComponent.CODEC).build()
    );

    public static void registerModComponents() {
        GarsashsMagic.LOGGER.info("Registering {} components", GarsashsMagic.MOD_ID);
    }
}
