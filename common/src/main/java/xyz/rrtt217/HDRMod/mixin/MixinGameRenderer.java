package xyz.rrtt217.HDRMod.mixin;

import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.rrtt217.HDRMod.core.BeforeBlitRenderer;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {
    @Inject(method = "render", at = @At("RETURN"), cancellable = true)
    private void hdr_mod$setGameRendererState(CallbackInfo ci){
        BeforeBlitRenderer.isGameRenderingCanceled = ci.isCancelled();
    }
}
