package moffy.mimic.core.config;

import moffy.addonapi.AddonModuleRegistry;
import moffy.mimic.modules.MimicModuleProvider;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class MimicConfig {

    public static ForgeConfigSpec COMMON_SPEC;
    public static ForgeConfigSpec MODULE_SPEC;

    private static void buildCommonConfig() {
        ForgeConfigSpec.Builder common = new ForgeConfigSpec.Builder();


        COMMON_SPEC = common.build();
    }

    public static void buildModuleConfig(FMLJavaModLoadingContext context) {
        ForgeConfigSpec.Builder module = new ForgeConfigSpec.Builder();

        AddonModuleRegistry.INSTANCE.LoadModule(new MimicModuleProvider(context), module);

        MODULE_SPEC = module.build();
    }

    static {
        buildCommonConfig();
    }
}
