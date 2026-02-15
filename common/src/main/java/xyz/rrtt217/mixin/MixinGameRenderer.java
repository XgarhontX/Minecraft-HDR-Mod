package xyz.rrtt217.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.rrtt217.HDRMod;
import xyz.rrtt217.config.HDRModConfig;
import xyz.rrtt217.core.BeforeBlitRenderer;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {
    @Inject(method = "render", at = @At("RETURN"), cancellable = true)
    private void hdr_mod$setGameRendererState(CallbackInfo ci){
        BeforeBlitRenderer.isGameRenderingCanceled = ci.isCancelled();
        HDRMod.LOGGER.info(String.valueOf(ci.isCancelled()));
    }
}
