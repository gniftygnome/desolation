package raltsmc.desolation.client.render.entity.model;

import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.entity.BlackenedEntity;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class BlackenedEntityModel extends DefaultedEntityGeoModel<BlackenedEntity> {
	public BlackenedEntityModel() {
		super(Identifier.of(Desolation.MOD_ID, "blackened"), true);
	}
}