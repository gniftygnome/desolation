package raltsmc.desolation.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.registry.DesolationBiomes;
import raltsmc.desolation.world.feature.DesolationConfiguredFeatures;
import raltsmc.desolation.world.feature.DesolationPlacedFeatures;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DesolationDynamicRegistryProvider extends FabricDynamicRegistryProvider {
	protected DesolationDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	public static void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, DesolationConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, DesolationPlacedFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.BIOME, DesolationBiomes::bootstrap);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
		addAll(entries, registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), Desolation.MOD_ID);
		addAll(entries, registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), Desolation.MOD_ID);
		addAll(entries, registries.getWrapperOrThrow(RegistryKeys.BIOME), Desolation.MOD_ID);
	}

	@Override
	public String getName() {
		return "Desolation";
	}

	/**
	 * Version of FabricDynamicRegistryProvider.Entries.addAll() using specified mod ID.
	 */
	@SuppressWarnings("UnusedReturnValue")
	public <T> List<RegistryEntry<T>> addAll(Entries entries, RegistryWrapper.Impl<T> registry, String modId) {
		return registry.streamKeys()
				.filter(registryKey -> registryKey.getValue().getNamespace().equals(modId))
				.map(key -> entries.add(registry, key))
				.toList();
	}
}
