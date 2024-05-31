package raltsmc.desolation.mixin.client.network;

import com.mojang.authlib.GameProfile;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EntityPose;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import raltsmc.desolation.init.server.CinderSoulC2SPacket;
import raltsmc.desolation.registry.DesolationStatusEffects;
import raltsmc.desolation.init.client.DesolationClient;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {
    @Unique
    private static final int CINDER_DASH_COOLDOWN_MAX = 200;
    @Unique
    public int cinderDashCooldown = 200;
    @Unique
    public boolean isDashing = false;
    @Unique
    public int dashLengthMax = 10;
    @Unique
    public int dashLength = 0;
    @Unique
    public Vec3d dashVector;

    public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void desolation$tickClientPlayer(CallbackInfo info) {
        if (this.hasStatusEffect(Registries.STATUS_EFFECT.getEntry(DesolationStatusEffects.CINDER_SOUL))) {
            if (cinderDashCooldown < CINDER_DASH_COOLDOWN_MAX) {
                ++cinderDashCooldown;
                if (cinderDashCooldown == CINDER_DASH_COOLDOWN_MAX) {

                    if (ClientPlayNetworking.canSend(CinderSoulC2SPacket.ID)) {
                        ClientPlayNetworking.send(new CinderSoulC2SPacket(CinderSoulC2SPacket.TYPE.READY));
                    }
                    this.playSound(SoundEvents.BLOCK_NOTE_BLOCK_CHIME.value(), 1F, 1.2F);
                }
            }

            if (random.nextDouble() < 0.3) {
                if (ClientPlayNetworking.canSend(CinderSoulC2SPacket.ID)) {
                    ClientPlayNetworking.send(new CinderSoulC2SPacket(CinderSoulC2SPacket.TYPE.TICK));
                }
            }

            if (DesolationClient.cinderDashBinding.isPressed() && cinderDashCooldown >= CINDER_DASH_COOLDOWN_MAX) {
                dashVector = this.getRotationVector().normalize().multiply(0.75);
                cinderDashCooldown = 0;
                isDashing = true;
                if (ClientPlayNetworking.canSend(CinderSoulC2SPacket.ID)) {
                    ClientPlayNetworking.send(new CinderSoulC2SPacket(CinderSoulC2SPacket.TYPE.DASH));
                }
            }

            if (isDashing) {
                if (dashLength < dashLengthMax) {
                    if (this.getWorld().isClient) {
                        this.setVelocity(dashVector);
                        this.velocityDirty = true;
                    }
                    this.setPose(EntityPose.SWIMMING);
                    this.fallDistance = 0;
                    ++dashLength;
                } else {
                    isDashing = false;
                    dashLength = 0;
                }
            }
        } else {
            dashLength = 0;
            isDashing = false;
        }
    }
}

