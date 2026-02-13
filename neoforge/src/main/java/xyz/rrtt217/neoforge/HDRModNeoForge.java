package xyz.rrtt217.neoforge;

import net.neoforged.fml.common.Mod;

import net.neoforged.fml.loading.FMLEnvironment;
import xyz.rrtt217.HDRMod;

@Mod(HDRMod.MOD_ID)
public final class HDRModNeoForge {
    public HDRModNeoForge() {
        // Run our common setup.
        HDRMod.init();
        if (FMLEnvironment.getDist().isClient()) {
            HDRModForgeConfigHelper.registerConfig();
        }
    }
}
