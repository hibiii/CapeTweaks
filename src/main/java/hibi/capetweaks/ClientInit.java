package hibi.capetweaks;

import net.fabricmc.api.ClientModInitializer;

public class ClientInit implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		Config.init();
	}
}
