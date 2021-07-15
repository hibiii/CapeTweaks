package hibi.capetweaks;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.TranslatableText;

public class CapeOptionsScreen extends GameOptionsScreen {
	public CapeOptionsScreen(Screen parent) {
		super(parent, ClientInit.client.options, new TranslatableText("capetweaks.options"));
	}

	@Override
	protected void init() {
		this.<CyclingButtonWidget<Boolean>>addDrawable(
			CyclingButtonWidget.onOffBuilder(Config.unclamp).build(
				this.width / 2 - 155, this.height / 6,
				150, 20,
				new TranslatableText("capetweaks.options.unclamp"),
				(button, enabled) -> {Config.unclamp = enabled;}
			)
		);
		this.<CyclingButtonWidget<Boolean>>addDrawable(
			CyclingButtonWidget.onOffBuilder(Config.lerpMovement).build(
				this.width / 2 + 5, this.height / 6,
				150, 20,
				new TranslatableText("capetweaks.options.lerpMovement"),
				(button, enabled) -> {Config.lerpMovement = enabled;}
			)
		);
		this.<CyclingButtonWidget<Boolean>>addDrawable(
			CyclingButtonWidget.onOffBuilder(Config.elytraTexture).build(
				this.width / 2 - 155, this.height / 6 + 24,
				150, 20,
				new TranslatableText("capetweaks.options.elytraTexture"),
				(button, enabled) -> {Config.elytraTexture = enabled;}
			)
		);
		this.<CyclingButtonWidget<Boolean>>addDrawable(
			CyclingButtonWidget.onOffBuilder(Config.withElytra).build(
				this.width / 2 + 5, this.height / 6 + 24,
				150, 20,
				new TranslatableText("capetweaks.options.withElytra"),
				(button, enabled) -> {Config.withElytra = enabled;}
			)
		);
        this.<ButtonWidget>addDrawableChild(
			new ButtonWidget(
				this.width / 2 - 100, this.height / 6 + 48,
				200, 20,
				ScreenTexts.DONE,
				button -> this.client.setScreen(this.parent)
			)
		);
	}

	@Override
	public void removed() {
		this.save();
	}

	private void save() {
		try {
			Config.save();
		} catch (Exception e) {
			this.client.getToastManager().add(
				new SystemToast(
					null,
					new TranslatableText("capetweaks.saveError"),
					new TranslatableText("capetweaks.saveError.description")
				)
			);
		}
	}
	
}
