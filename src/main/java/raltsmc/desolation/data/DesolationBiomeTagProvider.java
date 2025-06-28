package raltsmc.desolation.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;
import raltsmc.desolation.registry.DesolationBiomes;
import raltsmc.desolation.tag.DesolationBiomeTags;

import java.util.concurrent.CompletableFuture;

public class DesolationBiomeTagProvider extends FabricTagProvider<Biome> {
	protected DesolationBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, RegistryKeys.BIOME, registriesFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries) {
		/*
		 * Vanilla biome categories
		 */
		builder(BiomeTags.IS_FOREST)
			.addOptional(DesolationBiomes.CHARRED_FOREST)
			.addOptional(DesolationBiomes.CHARRED_FOREST_SMALL);


		/*
		 * Conventional biome categories
		 */
		builder(ConventionalBiomeTags.IS_TEMPERATE_OVERWORLD)
			.addOptional(DesolationBiomes.CHARRED_FOREST)
			.addOptional(DesolationBiomes.CHARRED_FOREST_CLEARING)
			.addOptional(DesolationBiomes.CHARRED_FOREST_SMALL);

		builder(ConventionalBiomeTags.IS_OVERWORLD)
			.addOptional(DesolationBiomes.CHARRED_FOREST)
			.addOptional(DesolationBiomes.CHARRED_FOREST_CLEARING)
			.addOptional(DesolationBiomes.CHARRED_FOREST_SMALL);


		/*
		 * Biome structure generation tags
		 */
		builder(BiomeTags.MINESHAFT_HAS_STRUCTURE)
			.addOptional(DesolationBiomes.CHARRED_FOREST)
			.addOptional(DesolationBiomes.CHARRED_FOREST_CLEARING)
			.addOptional(DesolationBiomes.CHARRED_FOREST_SMALL);

		builder(BiomeTags.RUINED_PORTAL_STANDARD_HAS_STRUCTURE)
			.addOptional(DesolationBiomes.CHARRED_FOREST)
			.addOptional(DesolationBiomes.CHARRED_FOREST_CLEARING)
			.addOptional(DesolationBiomes.CHARRED_FOREST_SMALL);

		builder(BiomeTags.STRONGHOLD_HAS_STRUCTURE)
			.addOptional(DesolationBiomes.CHARRED_FOREST)
			.addOptional(DesolationBiomes.CHARRED_FOREST_CLEARING)
			.addOptional(DesolationBiomes.CHARRED_FOREST_SMALL);

		builder(BiomeTags.TRIAL_CHAMBERS_HAS_STRUCTURE)
			.addOptional(DesolationBiomes.CHARRED_FOREST)
			.addOptional(DesolationBiomes.CHARRED_FOREST_CLEARING)
			.addOptional(DesolationBiomes.CHARRED_FOREST_SMALL);

		builder(DesolationBiomeTags.ASH_TINKER_BASE_HAS_STRUCTURE)
			.addOptional(DesolationBiomes.CHARRED_FOREST)
			.addOptional(DesolationBiomes.CHARRED_FOREST_CLEARING)
			.addOptional(DesolationBiomes.CHARRED_FOREST_SMALL);
	}

	@Override
	public String getName() {
		return "Desolation Biome Tags";
	}
}
