# Minecraft HDR Mod
A minecraft mod that enables native HDR on Windows/Linux with Iris shaders. Currently in early development.
## What the mod have achieved
- Native HDR, both for Windows scRGB and HDR10/PQ;
- UI color correction by a BEFORE_BLIT pass;
- Ingame config using Cloth Config API(May switch to Sodium Options API later)
## For shader patches
### Macros
- HDR_MOD_INSTALLED
- HDR_ENABLED
- CURRENT_PRIMARIES: One of SRGB, PAL_M, PAL, NTSC, GENERIC_FILM, BT2020, CIE1931_XYZ, DCI_P3, DISPLAY_P3, ADOBE_RGB;
- CURRENT_TRANSFER_FUNCTION: One of BT1886, GAMMA22, GAMMA28, ST240, EXT_LINEAR, LOG_100, LOG_316, XVYCC, SRGB, EXT_SRGB, ST2084_PQ, ST428, HLG.
### Uniforms
- float MinBrightness;
- float MaxBrightness;
- float SDRWhiteLevel;
- float UIBrightness;

Use these uniforms inside `#if HDR_MOD_INSTALLED` block.
## Known Issue
Ingame screenshot is broken.
## Credits
Tom94, for [glfw fork with color management](https://github.com/Tom94/glfw/tree/color-management);
IMS212, for [Iris shaders](https://github.com/IrisShaders/Iris) and [original gifw patch idea](https://github.com/IMS212/glfw/tree/hdr);
XgarhontX and some other fellows, for working on RenoDX Minecraft HDR and shader patches, and helping me to make color transform correct.
