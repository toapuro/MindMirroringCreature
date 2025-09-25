package moffy.mimic.modules;

import moffy.addonapi.AddonModuleProvider;
import moffy.mimic.core.Mimic;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class MimicModuleProvider extends AddonModuleProvider {
    public MimicModuleProvider(FMLJavaModLoadingContext context) {
        super(context);
    }

    @Override
    public void registerRawModules() {
    }

    @Override
    public String getModId() {
        return Mimic.MODID;
    }
}
