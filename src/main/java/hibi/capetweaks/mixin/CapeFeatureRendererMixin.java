package hibi.capetweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import hibi.capetweaks.Config;
import net.minecraft.client.render.entity.feature.CapeFeatureRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mixin(CapeFeatureRenderer.class)
public class CapeFeatureRendererMixin {
	@Redirect(
		method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/Entity;FFFFFF)V",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/item/Item;isOf(Lnet/minecraft/item/Item;)Z"
		)
	)
	private boolean hasElytra(ItemStack is, Item i) {
		if(Config.withElytra)
			return false;
		else
			return is.isOf(i);
	}
}
