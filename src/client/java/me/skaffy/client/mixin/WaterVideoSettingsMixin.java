package me.skaffy.client.mixin;

import java.util.ArrayList;
import java.util.List;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;

import me.skaffy.client.water.WaterOptions;

import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.client.gui.screens.options.VideoSettingsScreen;
import net.minecraft.network.chat.Component;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** Adds the "Water Settings..." button to the vanilla Video Settings screen (Ultra Realistic Water lite). */
@Mixin(VideoSettingsScreen.class)
public abstract class WaterVideoSettingsMixin extends OptionsSubScreen {
	private WaterVideoSettingsMixin(Screen lastScreen, Options options, Component title) {
		super(lastScreen, options, title);
	}

	@ModifyReturnValue(method = "displayOptions", at = @At("RETURN"))
	private static OptionInstance<?>[] skaffy$waterRow(OptionInstance<?>[] options) {
		List<OptionInstance<?>> list = new ArrayList<>(List.of(options));
		int api = list.indexOf(Minecraft.getInstance().options.preferredGraphicsBackend());
		list.add(api >= 0 ? api + 1 : list.size(), WaterOptions.WATER_SETTINGS);
		return list.toArray(OptionInstance[]::new);
	}
}
