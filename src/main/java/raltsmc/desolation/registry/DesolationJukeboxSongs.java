package raltsmc.desolation.registry;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import raltsmc.desolation.Desolation;

@SuppressWarnings("SameParameterValue")
public class DesolationJukeboxSongs {
    public static final RegistryKey<JukeboxSong> ASHES = of("ashes");

    @SuppressWarnings("UnnecessaryReturnStatement")
    private DesolationJukeboxSongs() {
        return;
    }

    public static void bootstrap(Registerable<JukeboxSong> registry) {
        register(registry, ASHES, DesolationSounds.MUSIC_DISC_ASHES_SOUND, 93, 14);
    }

    private static RegistryKey<JukeboxSong> of(String name) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Desolation.MOD_ID, name));
    }

    private static void register(Registerable<JukeboxSong> registry, RegistryKey<JukeboxSong> key, RegistryEntry.Reference<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput) {
        registry.register(key, new JukeboxSong(soundEvent, Text.translatable(Util.createTranslationKey("jukebox_song", key.getValue())), lengthInSeconds, comparatorOutput));
    }
}
