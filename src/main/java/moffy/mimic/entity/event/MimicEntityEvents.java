package moffy.mimic.entity.event;

import moffy.mimic.client.renderer.MimicNakedRenderer;
import moffy.mimic.registries.MimicEntities;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class MimicEntityEvents {
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(
                MimicEntities.MIMIC_ENTITY.get(),
                MimicNakedRenderer::new
        );
    }
}
