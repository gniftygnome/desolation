package raltsmc.desolation.mixin.potion;

import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import raltsmc.desolation.registry.DesolationStatusEffects;

import java.util.function.Consumer;

@Mixin(PotionContentsComponent.class)
public abstract class PotionContentsComponentMixin {
    @Inject(method = "buildTooltip(Ljava/lang/Iterable;Ljava/util/function/Consumer;FF)V",
            at = @At("TAIL"),
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private static void desolation$addTooltip(Iterable<StatusEffectInstance> effects, Consumer<Text> textConsumer, float durationMultiplier, float tickRate, CallbackInfo ci) {
        for (StatusEffectInstance effect : effects) {
            if (DesolationStatusEffects.CINDER_SOUL.equals(effect.getEffectType().value())) {
                textConsumer.accept(Text.translatable("potion.cinder_soul.tooltip_a").formatted(Formatting.GOLD));
                textConsumer.accept(Text.translatable("potion.cinder_soul.tooltip_b").formatted(Formatting.GOLD));

                break;
            }
        }
    }
}