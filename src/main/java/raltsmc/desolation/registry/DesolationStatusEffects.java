package raltsmc.desolation.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.entity.effect.CinderSoulStatusEffect;

@SuppressWarnings("SameParameterValue")
public class DesolationStatusEffects {
    public static final StatusEffect CINDER_SOUL = register("cinder_soul", new CinderSoulStatusEffect());

    @SuppressWarnings("UnnecessaryReturnStatement")
    private DesolationStatusEffects() {
        return;
    }

    private static StatusEffect register(String name, StatusEffect entry) {
        return Registry.register(Registries.STATUS_EFFECT, Identifier.of(Desolation.MOD_ID, name), entry);
    }

    public static void init() { }
}
