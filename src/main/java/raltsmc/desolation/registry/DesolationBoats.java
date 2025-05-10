package raltsmc.desolation.registry;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;

public class DesolationBoats {
	public static final Identifier CHARRED = Identifier.of(Desolation.MOD_ID, "charred");
	public static final Item CHARRED_BOAT = TerraformBoatItemHelper.registerBoatItem(CHARRED, false);
	public static final Item CHARRED_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(CHARRED, true);

	@SuppressWarnings("UnnecessaryReturnStatement")
	private DesolationBoats() {
		return;
	}

	public static void init() {
	}
}
