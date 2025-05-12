package raltsmc.desolation.client.render.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import raltsmc.desolation.client.render.entity.feature.GeoGlowLayerRenderer;
import raltsmc.desolation.client.render.entity.model.BlackenedEntityModel;
import raltsmc.desolation.entity.BlackenedEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class BlackenedEntityRenderer<R extends LivingEntityRenderState & GeoRenderState> extends GeoEntityRenderer<BlackenedEntity, R> {
    public BlackenedEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BlackenedEntityModel());

        this.addRenderLayer(new GeoGlowLayerRenderer<>(this, "textures/entity/blackened_glow.png"));
    }
}
