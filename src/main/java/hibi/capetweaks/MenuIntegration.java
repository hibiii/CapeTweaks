package hibi.capetweaks;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import me.shedaniel.clothconfiglite.api.ConfigScreen;
import net.minecraft.text.TranslatableText;

public class MenuIntegration implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> {
			ConfigScreen screen = ConfigScreen.create(new TranslatableText("capetweaks.options"), parent);
			screen.add(new TranslatableText("capetweaks.options.unclamp"), Config.unclamp, () -> false, (in) -> { Config.unclamp = (boolean) in; });
			screen.add(new TranslatableText("capetweaks.options.lerpMovement"), Config.lerpMovement, () -> false, (in) -> { Config.lerpMovement = (boolean) in; });
			screen.add(new TranslatableText("capetweaks.options.elytraTexture"), Config.elytraTexture, () -> true, (in) -> { Config.elytraTexture = (boolean) in; });
			return screen.get();
		};
	}
}
