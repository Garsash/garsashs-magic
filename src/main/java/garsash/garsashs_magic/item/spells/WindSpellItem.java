package garsash.garsashs_magic.item.spells;

import garsash.garsashs_magic.GarsashsMagic;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.WindChargeEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class WindSpellItem extends Item {
    public WindSpellItem(Settings settings) {
        super(settings);
    }

    public static void spell(World world, PlayerEntity user, Hand hand){
        if (world instanceof ServerWorld serverWorld) {
            ItemStack fake = new ItemStack(RegistryEntry.of(Items.WIND_CHARGE),1);
            ProjectileEntity.spawnWithVelocity((world2, shooter, stack) -> new WindChargeEntity(user, world, user.getPos().getX(), user.getEyePos().getY(), user.getPos().getZ()), serverWorld, fake, user, 0.0F, 1.5F, 1.0F);
        }
        GarsashsMagic.LOGGER.info("click");
    }
}