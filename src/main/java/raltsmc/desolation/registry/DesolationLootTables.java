package raltsmc.desolation.registry;

import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;

public class DesolationLootTables {
    public static final RegistryKey<LootTable> ASH_SCUTTLER_DIG = RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(Desolation.MOD_ID, "misc/ash_scuttler_dig"));
    public static final RegistryKey<LootTable> ASH_TINKER_BASE = RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(Desolation.MOD_ID, "chests/ash_tinker_base"));

    @SuppressWarnings("UnnecessaryReturnStatement")
    private DesolationLootTables() {
        return;
    }
}
