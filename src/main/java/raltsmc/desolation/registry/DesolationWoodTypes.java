package raltsmc.desolation.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;

public class DesolationWoodTypes {
	public static final WoodType CHARRED = WoodTypeBuilder.copyOf(WoodType.OAK)
			.register(Identifier.of(Desolation.MOD_ID, "charred"), DesolationBlockSetTypes.CHARRED);
}
