package xyz.rrtt217.fabric.client;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;
import xyz.rrtt217.HDRMod;
import xyz.rrtt217.config.HDRModConfig;
import xyz.rrtt217.mixin.MixinWindow;
import xyz.rrtt217.util.GLFWColorManagement;

import static xyz.rrtt217.HDRMod.LOGGER;

public final class HDRModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        // Only for debug.
//        HDRModConfig config = AutoConfig.getConfigHolder(HDRModConfig.class).getConfig();
//        ClientTickEvents.START_CLIENT_TICK.register(client -> {
//           if(HDRMod.UiLuminanceUBO != null) HDRMod.UiLuminanceUBO.update(config.useSDRWhiteLevelAsUiLuminance ? GLFWColorManagement.glfwGetWindowSdrWhiteLevel(Minecraft.getInstance().getWindow().handle()) : config.UiLuminance);
//        });
    }
}
