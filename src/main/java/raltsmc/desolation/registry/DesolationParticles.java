package raltsmc.desolation.registry;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;

public class DesolationParticles {
    public static final ParticleType<SimpleParticleType> SPARK = register("spark", FabricParticleTypes.simple());

    @SuppressWarnings("UnnecessaryReturnStatement")
    private DesolationParticles() {
        return;
    }

    public static <T extends ParticleType<?>> T register(String name, T type) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Desolation.MOD_ID, name), type);
    }

    public static void init() { }
}
