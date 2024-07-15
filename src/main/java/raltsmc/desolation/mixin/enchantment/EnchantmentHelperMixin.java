package raltsmc.desolation.mixin.enchantment;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import raltsmc.desolation.registry.DesolationStatusEffects;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @Inject(method = "onTargetDamaged(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/Entity;Lnet/minecraft/entity/damage/DamageSource;Lnet/minecraft/item/ItemStack;)V",
            at = @At("TAIL")
    )
    private static void desolation$cinderSoulAttackIgnite(ServerWorld world, Entity target, DamageSource damageSource, ItemStack weapon, CallbackInfo ci) {
        if (target instanceof LivingEntity && damageSource.getAttacker() instanceof PlayerEntity attacker) {
            if (attacker.hasStatusEffect(Registries.STATUS_EFFECT.getEntry(DesolationStatusEffects.CINDER_SOUL))) {
                target.setOnFireFor(6.0f);
            }
        }
    }
}
