package raltsmc.desolation.registry;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;

public class DesolationBoatTypes {
	public static Item CHARRED_BOAT;
	public static Item CHARRED_CHEST_BOAT;

	@SuppressWarnings("UnnecessaryReturnStatement")
	private DesolationBoatTypes() {
		return;
	}

	public static void init() {
		final Identifier CHARRED_BOAT_ID = Identifier.of(Desolation.MOD_ID, "charred_boat");
		final Identifier CHARRED_CHEST_BOAT_ID = Identifier.of(Desolation.MOD_ID, "charred_chest_boat");
		final RegistryKey<TerraformBoatType> CHARRED_BOAT_KEY = TerraformBoatTypeRegistry.createKey(Identifier.of(Desolation.MOD_ID, "charred"));

		CHARRED_BOAT = TerraformBoatItemHelper.registerBoatItem(CHARRED_BOAT_ID, CHARRED_BOAT_KEY, false);
		CHARRED_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(CHARRED_CHEST_BOAT_ID, CHARRED_BOAT_KEY, true);

		TerraformBoatType CHARRED = new TerraformBoatType.Builder()
				.item(CHARRED_BOAT)
				.chestItem(CHARRED_CHEST_BOAT)
				.planks(DesolationBlocks.CHARRED_PLANKS.asItem())
				.build();

		Registry.register(TerraformBoatTypeRegistry.INSTANCE, CHARRED_BOAT_KEY, CHARRED);
	}
}
