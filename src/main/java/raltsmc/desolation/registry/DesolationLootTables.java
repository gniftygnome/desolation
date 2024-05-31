package raltsmc.desolation.registry;

import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import raltsmc.desolation.Desolation;

public class DesolationLootTables {
    public static final RegistryKey<LootTable> ASH_SCUTTLER_DIG = RegistryKey.of(RegistryKeys.LOOT_TABLE, Desolation.id("misc/ash_scuttler_dig"));
    public static final RegistryKey<LootTable> ASH_TINKER_BASE = RegistryKey.of(RegistryKeys.LOOT_TABLE, Desolation.id("chests/ash_tinker_base"));
}
