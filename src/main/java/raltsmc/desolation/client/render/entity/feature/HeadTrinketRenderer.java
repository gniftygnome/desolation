package raltsmc.desolation.client.render.entity.feature;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import raltsmc.desolation.Desolation;

public class HeadTrinketRenderer implements TrinketRenderer {
    private final Identifier texture;
    private final BipedEntityModel<BipedEntityRenderState> model;

    public HeadTrinketRenderer(String path, BipedEntityModel<BipedEntityRenderState> model) {
        this(Identifier.of(Desolation.MOD_ID, path), model);
    }

    public HeadTrinketRenderer(Identifier texture, BipedEntityModel<BipedEntityRenderState> model) {
        this.texture = texture;
        this.model = model;
    }

    protected Identifier getTexture() {
        return texture;
    }

    protected BipedEntityModel<BipedEntityRenderState> getModel() {
        return model;
    }

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntityRenderState> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntityRenderState renderState, float limbAngle, float limbDistance) {
        if (!(contextModel instanceof BipedEntityModel entity && renderState instanceof BipedEntityRenderState state)) {
            return;
        }

        BipedEntityModel<BipedEntityRenderState> model = getModel();

        model.setAngles(state);
        TrinketRenderer.followBodyRotations(contextModel, model);
        render(matrices, vertexConsumers, light);
    }

    protected void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        RenderLayer layer = model.getLayer(getTexture());
        VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(vertexConsumers, layer, false);
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
    }
}
