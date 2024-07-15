package raltsmc.desolation.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;

@SuppressWarnings("SameParameterValue")
public class DesolationSounds {
    public static final RegistryEntry.Reference<SoundEvent> MUSIC_DISC_ASHES_SOUND = registerReference("music_disc.ashes");
    public static final SoundEvent EMBER_BLOCK_POP_1 = register("block.ember_pop1");
    public static final SoundEvent EMBER_BLOCK_POP_2 = register("block.ember_pop2");
    public static final SoundEvent EMBER_BLOCK_POP_3 = register("block.ember_pop3");
    public static final SoundEvent EMBER_BLOCK_POP_4 = register("block.ember_pop4");

    @SuppressWarnings("UnnecessaryReturnStatement")
    private DesolationSounds() {
        return;
    }

    private static SoundEvent register(String name) {
        Identifier id = Identifier.of(Desolation.MOD_ID, name);
        SoundEvent event = SoundEvent.of(id);

        return Registry.register(Registries.SOUND_EVENT, id, event);
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(String name) {
        Identifier id = Identifier.of(Desolation.MOD_ID, name);
        SoundEvent event = SoundEvent.of(id);

        return Registry.registerReference(Registries.SOUND_EVENT, id, event);
    }

    public static void init() { }
}
