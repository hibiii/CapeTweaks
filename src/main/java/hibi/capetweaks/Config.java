package hibi.capetweaks;

import java.io.IOException;

import hibi.SimpleConfig;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.TranslatableText;

public class Config {

	public static boolean unclamp;
	public static boolean lerpMovement;
	public static boolean elytraTexture;
	public static boolean disableCapes;


	public static void init() {
		CONFIG = SimpleConfig.of("capetweaks").request();
		unclamp = CONFIG.getOrDefault("unclamp", false);
		lerpMovement = CONFIG.getOrDefault("lerpMovement", false);
		elytraTexture = CONFIG.getOrDefault("elytraTexture", true);
		disableCapes = CONFIG.getOrDefault("disableCapes", false);
	}

	public static void save() {
		CONFIG.put("unclamp", unclamp);
		CONFIG.put("lerpMovement", lerpMovement);
		CONFIG.put("elytraTexture", elytraTexture);
		CONFIG.put("disableCapes", disableCapes);
		try {
			CONFIG.save();
		}
		catch (IOException e) {
			ClientInit.client.getToastManager().add(new SystemToast(
				null,
				new TranslatableText("capetweaks.saveError"),
				new TranslatableText("capetweaks.saveError.description")
			));
		}
	}

	private Config() {}
	private static SimpleConfig CONFIG;

}
