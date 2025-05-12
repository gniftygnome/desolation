package raltsmc.desolation.client.render.entity.feature;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import raltsmc.desolation.Desolation;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.base.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class GeoGlowLayerRenderer<T extends Entity & GeoAnimatable, R extends GeoRenderState> extends GeoRenderLayer<T, Void, R> {
    private final RenderLayer skin;

    public GeoGlowLayerRenderer(GeoRenderer<T, Void, R> entityRendererIn, String texture) {
        super(entityRendererIn);

        this.skin = RenderLayer.getEyes(Identifier.of(Desolation.MOD_ID, texture));
    }

    @Override
    public void render(R renderState, MatrixStack poseStack, BakedGeoModel bakedModel, @Nullable RenderLayer renderType, VertexConsumerProvider bufferSource, @Nullable VertexConsumer buffer, int packedLight, int packedOverlay, int renderColor) {
        VertexConsumer vertexConsumer = bufferSource.getBuffer(this.getEyesTexture());

        super.render(renderState, poseStack, bakedModel, this.getEyesTexture(), bufferSource, vertexConsumer, 15728640, packedOverlay, renderColor);
    }

    public RenderLayer getEyesTexture() {
        return skin;
    }
}
