package moffy.mimic.registries;

import moffy.mimic.core.Mimic;
import moffy.mimic.entity.MimicEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MimicEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Mimic.MODID);

    public static final RegistryObject<EntityType<MimicEntity>> MIMIC_ENTITY = ENTITY_TYPES.register(
            "mimic",
            () -> EntityType.Builder.of(MimicEntity::new, MobCategory.MISC)
                    .sized(0.5F, 1.975F)
                    .build(Mimic.getResource("mimic").toString())
    );
}
