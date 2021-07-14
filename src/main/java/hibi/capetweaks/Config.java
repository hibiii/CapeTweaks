package hibi.capetweaks;

import java.io.IOException;

import hibi.SimpleConfig;

public class Config {

	public static boolean unclamp;
	public static boolean lerpMovement;
	public static boolean elytraTexture;
	public static boolean withElytra;

	public static void init() {
		CONFIG = SimpleConfig.of("capetweaks").request();
		unclamp = CONFIG.getOrDefault("unclamp", false);
		lerpMovement = CONFIG.getOrDefault("lerpMovement", false);
		elytraTexture = CONFIG.getOrDefault("elytraTexture", true);
		withElytra = CONFIG.getOrDefault("withElytra", false);
	}

	public static void save() throws IOException {
		CONFIG.put("unclamp", unclamp);
		CONFIG.put("lerpMovement", lerpMovement);
		CONFIG.put("elytraTexture", elytraTexture);
		CONFIG.put("withElytra", withElytra);
		CONFIG.save();
	}

	private Config() {}
	private static SimpleConfig CONFIG;

}
