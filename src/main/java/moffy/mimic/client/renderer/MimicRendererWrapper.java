package moffy.mimic.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import moffy.mimic.mixin.accessor.EntityRendererAccessor;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class MimicRendererWrapper<T extends Entity, WRAPPER extends Entity> extends EntityRenderer<WRAPPER> {

    @SuppressWarnings("DataFlowIssue")
    private static final EntityRendererProvider.Context FAKE_CONTEXT = new EntityRendererProvider.Context(
            null,
            null,
            null,
            null,
            null,
            null,
            null
    );

    protected final T delegateEntity;
    protected final EntityRenderer<T> delegate;

    public MimicRendererWrapper(T delegateEntity, EntityRenderer<T> delegate) {
        super(FAKE_CONTEXT);
        this.delegateEntity = delegateEntity;
        this.delegate = delegate;
    }

    @SuppressWarnings("unchecked")
    public static <R extends Entity> EntityRendererAccessor<R> access(EntityRenderer<R> renderer) {
        return (EntityRendererAccessor<R>) renderer;
    }

    @Override
    protected int getSkyLightLevel(@NotNull WRAPPER pEntity, @NotNull BlockPos pPos) {
        return access(delegate).invokeGetSkyLightLevel(delegateEntity, pPos);
    }

    @Override
    protected int getBlockLightLevel(@NotNull WRAPPER pEntity, @NotNull BlockPos pPos) {
        return access(delegate).invokeGetBlockLightLevel(delegateEntity, pPos);
    }

    @Override
    public boolean shouldRender(@NotNull WRAPPER pLivingEntity, @NotNull Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        return delegate.shouldRender(delegateEntity, pCamera, pCamX, pCamY, pCamZ);
    }

    @Override
    public @NotNull Vec3 getRenderOffset(@NotNull WRAPPER pEntity, float pPartialTicks) {
        return delegate.getRenderOffset(delegateEntity, pPartialTicks);
    }

    @Override
    public void render(@NotNull WRAPPER pEntity, float pEntityYaw, float pPartialTick, @NotNull PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        delegate.render(delegateEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    protected boolean shouldShowName(@NotNull WRAPPER pEntity) {
        return access(delegate).invokeShouldShowName(delegateEntity);
    }

    @Override
    public @NotNull Font getFont() {
        return delegate.getFont();
    }

    @Override
    protected void renderNameTag(@NotNull WRAPPER pEntity, @NotNull Component pDisplayName, @NotNull PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        access(delegate).invokeRenderNameTag(delegateEntity, pDisplayName, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull WRAPPER mimic) {
        return delegate.getTextureLocation(delegateEntity);
    }
}
