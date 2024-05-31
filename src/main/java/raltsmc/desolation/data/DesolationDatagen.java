package raltsmc.desolation.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;

public class DesolationDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		FabricDataGenerator.Pack pack = dataGenerator.createPack();

		pack.addProvider(DesolationDynamicRegistryProvider::new);
		pack.addProvider(DesolationBiomeTagProvider::new);
		pack.addProvider(DesolationBlockLootTableProvider::new);
		DesolationBlockTagProvider blockTagProvider = pack.addProvider(DesolationBlockTagProvider::new);
		pack.addProvider((output, registries) -> new DesolationItemTagProvider(output, registries, blockTagProvider));
		pack.addProvider(DesolationEntityTypeTagProvider::new);
		pack.addProvider(DesolationRecipeProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		DesolationDynamicRegistryProvider.buildRegistry(registryBuilder);
	}
}
