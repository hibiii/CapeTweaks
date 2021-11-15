package hibi.capetweaks.mixin;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import hibi.capetweaks.CapeLibrary;
import net.minecraft.client.texture.PlayerSkinProvider;
import net.minecraft.util.Identifier;

@Mixin(PlayerSkinProvider.class)
public final class PlayerSkinProviderMixin {

	@Inject(
		at = @At("HEAD"),
		method = "loadSkin(Lcom/mojang/authlib/minecraft/MinecraftProfileTexture;Lcom/mojang/authlib/minecraft/MinecraftProfileTexture$Type;Lnet/minecraft/client/texture/PlayerSkinProvider$SkinTextureAvailableCallback;)Lnet/minecraft/util/Identifier;",
		cancellable = true)
	protected void filterCapes(MinecraftProfileTexture texture, MinecraftProfileTexture.Type type, PlayerSkinProvider.SkinTextureAvailableCallback callback, CallbackInfoReturnable<Identifier> info) {
		if(CapeLibrary.isBlocked(texture.getUrl())) {
			info.setReturnValue(null);
			info.cancel();
		}
	}
}
