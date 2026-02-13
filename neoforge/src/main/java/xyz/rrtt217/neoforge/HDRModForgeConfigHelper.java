package xyz.rrtt217.neoforge;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.AutoConfigClient;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import xyz.rrtt217.HDRMod;
import xyz.rrtt217.config.HDRModConfig;

import static xyz.rrtt217.HDRMod.LOGGER;

public class HDRModForgeConfigHelper {

    public static void registerConfig() {
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (container, parent) -> {
            return AutoConfigClient.getConfigScreen(HDRModConfig.class, parent).get();
        });
        LOGGER.debug("Registered Config Screen");
    }
}
