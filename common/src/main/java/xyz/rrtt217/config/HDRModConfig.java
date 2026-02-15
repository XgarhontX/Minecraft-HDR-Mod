package xyz.rrtt217.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import xyz.rrtt217.util.Enums.*;

@Config(name = "hdr_mod")
public class HDRModConfig implements ConfigData {
    public boolean enableHDR = true;

    public float uiBrightness = -1.0f;
    public float customGamePaperWhiteBrightness = -1.0f;
    public float customGamePeakBrightness = 1000.0f;
    public float customGameMinimumBrightness = 0.0f;
    public float customEotfEmulate = System.getProperty("os.name").startsWith("Windows") ? -1.0f : 0.0f;

    public boolean autoSetPrimaries = true;
    public Primaries customPrimaries = Primaries.SRGB;
    public boolean autoSetTransferFunction = true;
    public TransferFunction customTransferFunction = TransferFunction.SRGB;

    public boolean forceDisableGlfwWorkound = false;
}
