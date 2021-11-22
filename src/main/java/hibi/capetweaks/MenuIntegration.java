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
				new TranslatableText("capetweaks.options.lerpMovement"), Config.lerpMovement)
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

			capeCategory.add(entryBuilder.startTextDescription(new TranslatableText("capetweaks.options.capeSub.minecon")).build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.minecon_2011"), CapeLibrary.db.get(CapeLibrary.MINECON_2011))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MINECON_2011, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.minecon_2012"), CapeLibrary.db.get(CapeLibrary.MINECON_2012))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MINECON_2012, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.minecon_2013"), CapeLibrary.db.get(CapeLibrary.MINECON_2013))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MINECON_2013, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.minecon_2015"), CapeLibrary.db.get(CapeLibrary.MINECON_2015))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MINECON_2015, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.minecon_2016"), CapeLibrary.db.get(CapeLibrary.MINECON_2016))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MINECON_2016, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.minecon_2022"), CapeLibrary.db.get(CapeLibrary.MINECON_2022))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MINECON_2022, bool))
				.build());

			capeCategory.add(entryBuilder.startTextDescription(new TranslatableText("capetweaks.options.capeSub.community")).build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.translator"), CapeLibrary.db.get(CapeLibrary.TRANSLATOR))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.TRANSLATOR, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.translator_chinese"), CapeLibrary.db.get(CapeLibrary.TRANSLATOR_CHINESE))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.TRANSLATOR_CHINESE, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.map_maker"), CapeLibrary.db.get(CapeLibrary.MAP_MAKER))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MAP_MAKER, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.moderator"), CapeLibrary.db.get(CapeLibrary.MODERATOR))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MODERATOR, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.cobalt"), CapeLibrary.db.get(CapeLibrary.COBALT))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.COBALT, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.scrolls"), CapeLibrary.db.get(CapeLibrary.SCROLLS_CHAMP))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.SCROLLS_CHAMP, bool))
				.build());

			capeCategory.add(entryBuilder.startTextDescription(new TranslatableText("capetweaks.options.capeSub.personal")).build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.millionth_sale"), CapeLibrary.db.get(CapeLibrary.MILLIONTH_SALE))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MILLIONTH_SALE, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.dannybstyle"), CapeLibrary.db.get(CapeLibrary.DANNYBSTYLE))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.DANNYBSTYLE, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.julianclark"), CapeLibrary.db.get(CapeLibrary.JULIANCLARK))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.JULIANCLARK, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.cheapshot"), CapeLibrary.db.get(CapeLibrary.CHEAPSHOT))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.CHEAPSHOT, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.mrmessiah"), CapeLibrary.db.get(CapeLibrary.MRMESSIAH))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MRMESSIAH, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.prismarine"), CapeLibrary.db.get(CapeLibrary.PRISMARINE))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.PRISMARINE, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.turtle"), CapeLibrary.db.get(CapeLibrary.TURTLE))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.TURTLE, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.birthday"), CapeLibrary.db.get(CapeLibrary.BIRTHDAY))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.BIRTHDAY, bool))
				.build());
				
			capeCategory.add(entryBuilder.startTextDescription(new TranslatableText("capetweaks.options.capeSub.mojang")).build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.mojang_old"), CapeLibrary.db.get(CapeLibrary.MOJANG_OLD))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MOJANG_OLD, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.mojang"), CapeLibrary.db.get(CapeLibrary.MOJANG))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MOJANG, bool))
				.build());
			capeCategory.add(entryBuilder.startBooleanToggle(
				new TranslatableText("capetweaks.cape.mojang_new"), CapeLibrary.db.get(CapeLibrary.MOJANG_NEW))
				.setDefaultValue(true)
				.setSaveConsumer(bool -> CapeLibrary.db.put(CapeLibrary.MOJANG_NEW, bool))
				.build());

				general.addEntry(capeCategory.build());

			builder.setSavingRunnable(() -> Config.save());
			return builder.build();
		};
	}
}
