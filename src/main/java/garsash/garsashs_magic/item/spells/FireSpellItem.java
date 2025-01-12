package garsash.garsashs_magic.item.spells;

import garsash.garsashs_magic.GarsashsMagic;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FireSpellItem extends Item {
    public FireSpellItem(Settings settings) {
        super(settings);
    }

    public static void spell(World world, PlayerEntity user, Hand hand){
        if (world instanceof ServerWorld serverWorld) {
            ItemStack fake = new ItemStack(RegistryEntry.of(Items.FIRE_CHARGE),1);
            //ProjectileEntity.spawnWithVelocity((world2, shooter, stack) -> new WindChargeEntity(user, world, user.getPos().getX(), user.getEyePos().getY(), user.getPos().getZ()), serverWorld, fake, user, 0.0F, 1.5F, 1.0F);
            //ProjectileEntity projectile = ProjectileEntity.spawnWithVelocity((world2, shooter, stack) -> new FireballEntity(world, user, user.getRotationVec(1.0F), 1), serverWorld, fake, user, 0.0F, 1.5F, 1.0F);
            //projectile.setPosition(user.getEyePos());
            ProjectileEntity.spawnWithVelocity((world2, shooter, stack) -> new SmallFireballEntity(world, user.getPos().getX(), user.getEyePos().getY(), user.getPos().getZ(), user.getRotationVec(1.0F)), serverWorld, fake, user, 0.0F, 1.5F, 1.0F);

            if (!world.isClient()) {
                world.playSound(user, user.getX(), user.getY(), user.getZ(),SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.PLAYERS, 1F, 1F);
            }
        }
        GarsashsMagic.LOGGER.info("click");
    }
}