package moffy.mimic.entity.event;

import moffy.mimic.client.renderer.MimicNakedRenderer;
import moffy.mimic.entity.MimicEntity;
import moffy.mimic.registries.MimicEntities;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.Event;

public class MimicEntityEvents {
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(
                MimicEntities.MIMIC_ENTITY.get(),
                MimicNakedRenderer::new
        );
    }

    public static void onLivingHurt(LivingHurtEvent event){
        if(event.getEntity().level().isClientSide()){
            return;
        }
        if(event.getEntity() instanceof MimicEntity mimic){
            float damage = event.getAmount();
            float health = mimic.getRealHealth();
            if(damage/health>=0.3) {
                mimic.setMimicHP(mimic.getHealth()-40);
                mimic.setRealHealth(mimic.getRealMaxHealth());
            }
        }
    }
}
