package raltsmc.desolation.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;

public class DesolationBlockSetTypes {
	public static final BlockSetType CHARRED = BlockSetTypeBuilder.copyOf(BlockSetType.OAK)
			.register(Identifier.of(Desolation.MOD_ID, "charred"));
}
