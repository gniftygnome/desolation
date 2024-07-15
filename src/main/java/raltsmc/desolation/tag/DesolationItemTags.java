package raltsmc.desolation.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;

@SuppressWarnings("SameParameterValue")
public final class DesolationItemTags {
	public static final TagKey<Item> CHARRED_LOGS = DesolationItemTags.of("charred_logs");

	@SuppressWarnings("UnnecessaryReturnStatement")
	private DesolationItemTags() {
		return;
	}

	private static TagKey<Item> of(String path) {
		return DesolationItemTags.of(Identifier.of(Desolation.MOD_ID, path));
	}

	private static TagKey<Item> of(Identifier id) {
		return TagKey.of(RegistryKeys.ITEM, id);
	}
}
