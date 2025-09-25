package moffy.mimic.core;

import moffy.mimic.core.config.MimicConfig;
import moffy.mimic.registries.MimicEntities;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Mimic.MODID)
public class Mimic {

    public static final String MODID = "mind_mirroring_creature";

    @SuppressWarnings("removal")
    public Mimic() {
        FMLJavaModLoadingContext context = FMLJavaModLoadingContext.get();
        IEventBus modEventBus = context.getModEventBus();

        MimicConfig.buildModuleConfig(context);

        MimicEntities.ENTITY_TYPES.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MimicConfig.COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MimicConfig.MODULE_SPEC, MimicConfig.getConfigName(Mimic.MODID, "modules"));
    }
}
