package raltsmc.desolation.client.render.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class HeadTrinketModel extends BipedEntityModel<BipedEntityRenderState> {
    public HeadTrinketModel(ModelPart part, Function<Identifier, RenderLayer> renderLayerFactory) {
        super(part, renderLayerFactory);
    }

    public HeadTrinketModel(ModelPart part) {
        super(part, RenderLayer::getEntityCutoutNoCull);
    }

    @Override
    public ModelPart getHead() {
        return head;
    }

    public static ModelData createEmptyHat(ModelPartBuilder head) {
        ModelData data = getModelData(Dilation.NONE, 0);
        data.getRoot().addChild("head", head, ModelTransform.NONE);

        return data;
    }

    public static TexturedModelData createGogglesData() {
        ModelPartBuilder head = ModelPartBuilder.create();

        head.uv(0, 0);
        head.cuboid(-5F, -6F, -5F, 10F, 4F, 9F, new Dilation(0.25f));

        return TexturedModelData.of(createEmptyHat(head), 64, 32);
    }

    public static TexturedModelData createMaskData() {
        ModelPartBuilder head = ModelPartBuilder.create();

        head.uv(0, 13);
        head.cuboid(-4.5F, -2.5F, -4F, 9F, 4F, 8F, new Dilation(0.6f));

        return TexturedModelData.of(createEmptyHat(head), 64, 32);
    }
}
