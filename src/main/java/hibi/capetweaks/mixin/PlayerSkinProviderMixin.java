package hibi.capetweaks.mixin;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.texture.PlayerSkinProvider;
import net.minecraft.util.Identifier;

@Mixin(PlayerSkinProvider.class)
public final class PlayerSkinProviderMixin {

	@Inject(
		at = @At("HEAD"),
		method = "loadSkin(Lcom/mojang/authlib/minecraft/MinecraftProfileTexture;Lcom/mojang/authlib/minecraft/MinecraftProfileTexture$Type;Lnet/minecraft/client/texture/PlayerSkinProvider$SkinTextureAvailableCallback;)Lnet/minecraft/util/Identifier;",
		cancellable = true)
	protected void filterCapes(MinecraftProfileTexture texture, MinecraftProfileTexture.Type type, PlayerSkinProvider.SkinTextureAvailableCallback callback, CallbackInfoReturnable<Identifier> info) {
		System.out.println(texture.getUrl());
		if(texture.getUrl().endsWith("/2340c0e03dd24a11b15a8b33c2a7e9e32abb2051b2481d0ba7defd635ca7a933")) {
			info.setReturnValue(null);
			info.cancel();
		}
		//"http://textures.minecraft.net/texture/2340c0e03dd24a11b15a8b33c2a7e9e32abb2051b2481d0ba7defd635ca7a933"
	}
}
