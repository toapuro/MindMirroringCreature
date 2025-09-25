package moffy.mimic.mixin.accessor;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(EntityRenderer.class)
public interface EntityRendererAccessor<T extends Entity> {
    @Invoker("getSkyLightLevel")
    int invokeGetSkyLightLevel(T pEntity, BlockPos pPos);

    @Invoker("getBlockLightLevel")
    int invokeGetBlockLightLevel(T pEntity, BlockPos pPos);

    @Invoker("shouldShowName")
    boolean invokeShouldShowName(T pEntity);

    @Invoker("renderNameTag")
    void invokeRenderNameTag(T pEntity, Component pDisplayName, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight);
}
