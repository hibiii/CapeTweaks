package hibi.capetweaks;

import java.io.IOException;

import hibi.SimpleConfig;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;

public class Config {

	public static boolean lerpMovement;
	public static boolean elytraTexture;
	public static boolean disableCapes;


	public static void init() {
		CONFIG = SimpleConfig.of("capetweaks").request();
		lerpMovement = CONFIG.getOrDefault("lerpMovement", false);
		elytraTexture = CONFIG.getOrDefault("elytraTexture", true);
		disableCapes = CONFIG.getOrDefault("disableCapes", false);
		CapeLibrary.init(CONFIG);
	}

	public static void save() {
		CONFIG.put("lerpMovement", lerpMovement);
		CONFIG.put("elytraTexture", elytraTexture);
		CONFIG.put("disableCapes", disableCapes);
		CapeLibrary.save(CONFIG);
		try {
			CONFIG.save();
		}
		catch (IOException e) {
			ClientInit.client.getToastManager().add(new SystemToast(
				null,
				Text.translatable("capetweaks.saveError"),
				Text.translatable("capetweaks.saveError.description")
			));
		}
	}

	private Config() {}
	private static SimpleConfig CONFIG;

}
