package moffy.mimic.client.renderer;

import moffy.mimic.client.model.MimicModel;
import moffy.mimic.core.Mimic;
import moffy.mimic.entity.MimicEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MimicNakedRenderer extends LivingEntityRenderer<MimicEntity, MimicModel> {
    public MimicNakedRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MimicModel(pContext.bakeLayer(ModelLayers.ARMOR_STAND)), 0);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull MimicEntity mimic) {
        return Mimic.getResource("mimic");
    }
}
