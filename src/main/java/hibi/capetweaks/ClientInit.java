package hibi.capetweaks;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class ClientInit implements ClientModInitializer {
	public static MinecraftClient client = MinecraftClient.getInstance();
	@Override
	public void onInitializeClient() {
		Config.init();
	}
}
