package raltsmc.desolation.mixin.entity.player;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.registry.DesolationItems;

import java.util.Optional;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    @Shadow
    @Override
    public abstract Iterable<ItemStack> getArmorItems();

    @Shadow
    @Override
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Shadow
    @Override
    public abstract void equipStack(EquipmentSlot slot, ItemStack stack);

    @Shadow
    @Override
    public abstract Arm getMainArm();

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void desolation$tickPlayerEntity(CallbackInfo info) {
        World world = this.getWorld();

        if (!world.isClient) {
            Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(this);
            Identifier biomeId = world.getRegistryManager().get(RegistryKeys.BIOME).getId(world.getBiome(this.getBlockPos()).value());

            if (this.getY() >= world.getSeaLevel() - 10 && biomeId != null && Desolation.MOD_ID.equals(biomeId.getNamespace())) {
                if (component.isEmpty() || !component.get().isEquipped(DesolationItems.MASK)) {
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 308));
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 308));
                }
            }

            if (this.hasStatusEffect(StatusEffects.BLINDNESS) && component.isPresent() && component.get().isEquipped(DesolationItems.GOGGLES)) {
                this.removeStatusEffect(StatusEffects.BLINDNESS);
            }
        }
    }
}
