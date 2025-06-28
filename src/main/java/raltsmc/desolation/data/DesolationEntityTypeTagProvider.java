package raltsmc.desolation.data;

import com.terraformersmc.terraform.boat.api.data.TerraformBoatData;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEntityTypeTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;
import raltsmc.desolation.registry.DesolationBoats;
import raltsmc.desolation.registry.DesolationEntities;

import java.util.concurrent.CompletableFuture;

public class DesolationEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {
	protected DesolationEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries) {
		/*
		 * Basic entity type tags
		 */

		valueLookupBuilder(EntityTypeTags.ARTHROPOD)
			.add(DesolationEntities.ASH_SCUTTLER);

		getTagBuilder(EntityTypeTags.BOAT)
			.add(TerraformBoatData.get(DesolationBoats.CHARRED).boatEntityTypeId());

		valueLookupBuilder(EntityTypeTags.SKELETONS)
			.add(DesolationEntities.BLACKENED);


		/*
		 * Conventional entity type tags
		 */

		getTagBuilder(ConventionalEntityTypeTags.BOATS)
			.add(TerraformBoatData.get(DesolationBoats.CHARRED).chestBoatEntityTypeId());

	}

	@Override
	public String getName() {
		return "Desolation Entity Type Tags";
	}
}
