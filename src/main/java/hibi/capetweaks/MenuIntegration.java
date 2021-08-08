package hibi.capetweaks;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.TranslatableText;

public class MenuIntegration implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> {
			ConfigBuilder builder = ConfigBuilder.create()
				.setParentScreen(parent)
				.setTitle(new TranslatableText("capetweaks.options"));
			ConfigEntryBuilder entryBuilder = builder.entryBuilder();

			ConfigCategory general = builder.getOrCreateCategory(new TranslatableText("capetweaks.options.category.general"));
			
			general.addEntry(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.options.unclamp"), Config.unclamp)
				.setDefaultValue(false)
				.setSaveConsumer(in -> Config.unclamp = in)
			.build());
			
			general.addEntry(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.options.lerpMovement"), Config.unclamp)
				.setDefaultValue(false)
				.setSaveConsumer(in -> Config.lerpMovement = in)
			.build());
			
			general.addEntry(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.options.elytraTexture"), Config.elytraTexture)
				.setDefaultValue(true)
				.setSaveConsumer(in -> Config.elytraTexture = in)
			.build());

			general.addEntry(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.options.disableCapes"), Config.disableCapes)
				.setDefaultValue(false)
				.setSaveConsumer(in -> Config.disableCapes = in)
			.build());

			builder.setSavingRunnable(() -> Config.save());
			return builder.build();
		};
	}
}
