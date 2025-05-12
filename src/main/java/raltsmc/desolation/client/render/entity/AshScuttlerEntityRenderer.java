package raltsmc.desolation.client.render.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import raltsmc.desolation.client.render.entity.feature.GeoGlowLayerRenderer;
import raltsmc.desolation.client.render.entity.model.AshScuttlerEntityModel;
import raltsmc.desolation.entity.AshScuttlerEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class AshScuttlerEntityRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<AshScuttlerEntity, R> {
    public AshScuttlerEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new AshScuttlerEntityModel());

        this.addRenderLayer(new GeoGlowLayerRenderer<>(this, "textures/entity/ash_scuttler_glow.png"));
    }
}
