package raltsmc.desolation.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;
import raltsmc.desolation.registry.DesolationEntities;

import java.util.concurrent.CompletableFuture;

public class DesolationEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {
	protected DesolationEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries) {
		getOrCreateTagBuilder(EntityTypeTags.ARTHROPOD)
			.add(DesolationEntities.ASH_SCUTTLER);

		getOrCreateTagBuilder(EntityTypeTags.SKELETONS)
			.add(DesolationEntities.BLACKENED);
	}
}
