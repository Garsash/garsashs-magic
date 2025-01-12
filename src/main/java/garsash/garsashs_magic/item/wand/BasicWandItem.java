package garsash.garsashs_magic.item.wand;

import garsash.garsashs_magic.GarsashsMagic;
import garsash.garsashs_magic.item.ModComponents;
import garsash.garsashs_magic.item.ModItems;
import garsash.garsashs_magic.item.components.Spell;
import garsash.garsashs_magic.item.spells.FireSpellItem;
import garsash.garsashs_magic.item.spells.WindSpellItem;
import garsash.garsashs_magic.util.ModItemTags;
import net.minecraft.component.Component;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UseCooldownComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BasicWandItem extends Item {
    public BasicWandItem(Settings settings){
        super(settings);
    }

    //public static final Predicate<ItemStack> SPELLS = (stack) -> stack.isIn(ModTags.Items.SPELLS);

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack offHand = user.getOffHandStack();
        ItemStack mainHand = user.getMainHandStack();

        if (offHand.isIn(ModItemTags.SPELLS)) {
            //WindSpell.spell(world, user, hand);
            castSpell(offHand, mainHand, world, user, hand);
            //GarsashsMagic.LOGGER.info("valid");
        }
        //WindSpellItem.spell(world, user, hand);
        //GarsashsMagic.LOGGER.info(offHand.toString());
        //GarsashsMagic.LOGGER.info(offHand.getItem().getRegistryEntry().registryKey().toString());

        return ActionResult.SUCCESS;
    }

    private void castSpell(ItemStack spellItemStack, ItemStack mainHandStack, World world, PlayerEntity user, Hand hand) {
        Spell.SpellComponent spellComponent = spellItemStack.getOrDefault(ModComponents.SPELL_COMPONENT_TYPE, new Spell.SpellComponent("spell", 1.0F, 1.0F));
        String spell = spellComponent.spell();
        Float cooldown = spellComponent.cooldown();
        mainHandStack.set(DataComponentTypes.USE_COOLDOWN, new UseCooldownComponent(cooldown));

        GarsashsMagic.LOGGER.info(spell);

        switch (spell) {
            case "garsashs_magic:wind_spell":
                WindSpellItem.spell(world, user, hand);
                break;
            case "garsashs_magic:fire_spell":
                FireSpellItem.spell(world, user, hand);
                break;
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            ItemStack offHand = player.getOffHandStack();
            ItemStack mainHand = player.getMainHandStack();
            Spell.SpellComponent spellComponent = offHand.getOrDefault(ModComponents.SPELL_COMPONENT_TYPE, new Spell.SpellComponent("spell", 1.0F, 1.0F));
            Float cooldown = spellComponent.cooldown();

            mainHand.set(DataComponentTypes.USE_COOLDOWN, new UseCooldownComponent(cooldown));
        }
    }
}
