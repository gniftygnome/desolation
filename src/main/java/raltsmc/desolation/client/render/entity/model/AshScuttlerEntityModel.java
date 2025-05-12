package raltsmc.desolation.client.render.entity.model;

import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;
import raltsmc.desolation.entity.AshScuttlerEntity;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class AshScuttlerEntityModel extends DefaultedEntityGeoModel<AshScuttlerEntity> {
	public AshScuttlerEntityModel() {
		super(Identifier.of(Desolation.MOD_ID, "ash_scuttler"), true);
	}
}