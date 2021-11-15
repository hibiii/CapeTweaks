package hibi.capetweaks;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
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

			SubCategoryBuilder capeCategory = entryBuilder.startSubCategory(new TranslatableText("capetweaks.options.capeSub")).setExpanded(false);

			capeCategory.add(entryBuilder.startTextDescription(new TranslatableText("capetweaks.options.capeSub.relog")).build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.migrator"), CapeLibrary.db.get(CapeLibrary.MIGRATOR))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MIGRATOR, bool))
				.build());
			
				general.addEntry(capeCategory.build());

			builder.setSavingRunnable(() -> Config.save());
			return builder.build();
		};
	}
}
