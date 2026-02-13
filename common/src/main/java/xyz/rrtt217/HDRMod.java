package xyz.rrtt217;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import org.lwjgl.system.Configuration;
import org.slf4j.LoggerFactory;
import xyz.rrtt217.core.SingleFloatUBO;
import xyz.rrtt217.util.Enums.*;
import org.slf4j.Logger;
import xyz.rrtt217.config.HDRModConfig;
import xyz.rrtt217.util.LibraryExtractor;

import java.util.HashMap;

public final class HDRMod {
    public static final String MOD_ID = "hdr_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Default Internal values for HDR. We should register a hook to change them before shaderpack preload, and after window init.
    public static Primaries WindowPrimaries = Primaries.SRGB;
    public static TransferFunction WindowTransferFunction = TransferFunction.SRGB;

    // Whether we have the glfw lib for the platform.
    public static boolean hasglfwLib = false;

    // Global UI brightness UBO.
    public static SingleFloatUBO UiLuminanceUBO;
    public HDRMod() {
    }

    public static void init() {
        // Write common init code here.
        AutoConfig.register(HDRModConfig.class, Toml4jConfigSerializer::new);
        HashMap<String, String> glfwLibNames = new HashMap<>();
        glfwLibNames.put("win", "glfw3");
        glfwLibNames.put("mac", "LibGLFW");
        glfwLibNames.put("linux", "libglfw");
        String glfwLibPath = "";
        boolean loaded = false;
        try {
            glfwLibPath = LibraryExtractor.extractLibraries(glfwLibNames,"glfw").toString();
            loaded = true;
        }
        catch (Exception ignored) {
        }
        if(loaded) {
            Configuration.GLFW_LIBRARY_NAME.set(glfwLibPath);
            hasglfwLib = true;
        }
        LOGGER.info("HDRMod Initialized!");
    }
}