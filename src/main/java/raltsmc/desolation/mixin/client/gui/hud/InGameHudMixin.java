package raltsmc.desolation.mixin.client.gui.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.*;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.registry.DesolationItems;

import java.util.Optional;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    @Unique
    private static final Identifier GOGGLES_OVERLAY = Identifier.of(Desolation.MOD_ID, "textures/misc/goggles_overlay.png");

    @Shadow
    @Final
    private MinecraftClient client;

    @Shadow
    protected abstract void renderOverlay(DrawContext context, Identifier texture, float opacity);

    @Inject(method = "renderMiscOverlays", at = @At(value = "INVOKE", target = "net/minecraft/client/network/ClientPlayerEntity.getFrozenTicks()I", ordinal = 0))
    private void desolation$renderGoggles(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(this.client.player);
        if (this.client.options.getPerspective().isFirstPerson()
                && Desolation.CONFIG.showGogglesOverlay
                && component.isPresent()
                && component.get().isEquipped(DesolationItems.GOGGLES)) {
            this.desolation$renderGogglesTranslucency(context);
            this.renderOverlay(context, GOGGLES_OVERLAY, 1.0F);
        }
    }

    private void desolation$renderGogglesTranslucency(DrawContext context) {
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 0.36F);
        //RenderSystem.disableTexture();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(0.0F, context.getScaledWindowHeight(), -90.0F).texture(0.0F, 1.0F);
        bufferBuilder.vertex(context.getScaledWindowWidth(), context.getScaledWindowHeight(), -90.0F).texture(1.0F, 1.0F);
        bufferBuilder.vertex(context.getScaledWindowWidth(), 0.0F, -90.0F).texture(1.0F, 0.0F);
        bufferBuilder.vertex(0.0F, 0.0F, -90.0F).texture(0.0F, 0.0F);
        BufferRenderer.draw(bufferBuilder.end());
        RenderSystem.depthMask(true);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        //RenderSystem.enableTexture();
    }
}