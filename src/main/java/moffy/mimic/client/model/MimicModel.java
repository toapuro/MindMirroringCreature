package moffy.mimic.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import moffy.mimic.entity.MimicEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class MimicModel extends HumanoidModel<MimicEntity> {
    public MimicModel(ModelPart pRoot) {
        super(pRoot);
    }

    public MimicModel(ModelPart pRoot, Function<ResourceLocation, RenderType> pRenderType) {
        super(pRoot, pRenderType);
    }

    @Override
    public void setupAnim(@NotNull MimicEntity mimic, float v, float v1, float v2, float v3, float v4) {
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int i, int i1, float v, float v1, float v2, float v3) {
    }
}
