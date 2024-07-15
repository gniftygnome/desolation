package raltsmc.desolation.entity.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;

public class CinderSoulStatusEffect extends StatusEffect {
    public CinderSoulStatusEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xff5900);
        this.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, Identifier.of(Desolation.MOD_ID, "effect.cindersoul_strength"), 7.0D, EntityAttributeModifier.Operation.ADD_VALUE)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, Identifier.of(Desolation.MOD_ID, "effect.cindersoul_knockback"), 0.5D, EntityAttributeModifier.Operation.ADD_VALUE)
                .addAttributeModifier(EntityAttributes.GENERIC_ARMOR, Identifier.of(Desolation.MOD_ID, "effect.cindersoul_resistance"), 4.0D, EntityAttributeModifier.Operation.ADD_VALUE)
                .addAttributeModifier(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, Identifier.of(Desolation.MOD_ID, "effect.cindersoul_knockback_resistance"), 1.5D, EntityAttributeModifier.Operation.ADD_VALUE);
    }
}
