package hibi.capetweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import hibi.capetweaks.Config;
import net.minecraft.client.render.entity.feature.CapeFeatureRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

@Mixin(CapeFeatureRenderer.class)
public class CapeFeatureRendererMixin {
	@Redirect(
		method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
		)
	)
	private boolean hasElytra(ItemStack is, Item i) {
		if(Config.withElytra)
			return false;
		else
			return is.isOf(i);
	}

	@Redirect(
		method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/util/math/MathHelper;clamp(FFF)F"
		)
	)
	private float unclamp(float v, float m, float n) {
		if(Config.unclamp)
			return v;
		return MathHelper.clamp(v, m, n);
	}
}
