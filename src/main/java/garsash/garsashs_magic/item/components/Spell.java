package garsash.garsashs_magic.item.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import garsash.garsashs_magic.GarsashsMagic;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Spell {
    public record SpellComponent(String spell, float strength, float cooldown) {
        public static final Codec<SpellComponent> CODEC = RecordCodecBuilder.create(builder -> {
            return builder.group(
                    Codec.STRING.fieldOf("spell").forGetter(SpellComponent::spell),
                    Codec.FLOAT.optionalFieldOf("strength", 1.0f).forGetter(SpellComponent::strength),
                    Codec.FLOAT.optionalFieldOf("cooldown", 1.0f).forGetter(SpellComponent::cooldown)
            ).apply(builder, SpellComponent::new);
        });
    }
}
