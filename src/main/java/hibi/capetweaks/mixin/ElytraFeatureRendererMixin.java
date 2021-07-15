package hibi.capetweaks.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import hibi.capetweaks.Config;

@Mixin(ElytraFeatureRenderer.class)
public class ElytraFeatureRendererMixin {
	@Redirect(
		method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/Entity;FFFFFF)V",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;canRenderElytraTexture()Z"
		)
	)
	private boolean canElytra(AbstractClientPlayerEntity acpe) {
		return Config.elytraTexture && acpe.canRenderElytraTexture();
	}

	@Redirect(
		method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/Entity;FFFFFF)V",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;canRenderCapeTexture()Z"
		)
	)
	private boolean canCape(AbstractClientPlayerEntity acpe) {
		return Config.elytraTexture && acpe.canRenderCapeTexture();
	}
}
