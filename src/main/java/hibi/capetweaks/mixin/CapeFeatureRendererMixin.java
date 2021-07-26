package hibi.capetweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

import hibi.capetweaks.Config;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.CapeFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

@Mixin(CapeFeatureRenderer.class)
public class CapeFeatureRendererMixin {
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

	@ModifyVariable(method = "render", at = @At("STORE"), ordinal = 6)
	private float lerpMovement(float n, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l) {
		if(Config.lerpMovement)
    		return MathHelper.lerp(h, abstractClientPlayerEntity.prevBodyYaw, abstractClientPlayerEntity.bodyYaw);
		return abstractClientPlayerEntity.bodyYaw;
	}
}
