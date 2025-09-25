package moffy.mimic.mixin;

import moffy.mimic.client.renderer.MimicRendererWrapper;
import moffy.mimic.entity.MimicEntity;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderDispatcher.class)
public abstract class EntityRenderDispatcherMixin {

    @Shadow public abstract <T extends Entity> EntityRenderer<? super T> getRenderer(T pEntity);

    @Inject(method = "getRenderer", at = @At("HEAD"), cancellable = true)
    public <T extends Entity> void modifyRenderer(T entity, CallbackInfoReturnable<EntityRenderer<? super T>> cir) {
        if(entity instanceof MimicEntity mimic) {
            Player attachedPlayer = mimic.getAttachedPlayer();
            if(attachedPlayer instanceof AbstractClientPlayer clientPlayer) {
                var renderer = this.getRenderer(clientPlayer);
                cir.setReturnValue(new MimicRendererWrapper<>(clientPlayer, renderer));
            }
        }
    }
}
