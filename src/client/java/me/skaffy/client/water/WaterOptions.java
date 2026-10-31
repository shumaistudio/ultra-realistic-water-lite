package me.skaffy.client.water;

import java.util.Optional;
import java.util.function.Function;

import com.mojang.serialization.Codec;

import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;

/** A button in Video Settings that opens the Ultra Realistic Water lite settings screen. */
public final class WaterOptions {
	public static final OptionInstance<Boolean> WATER_SETTINGS = new OptionInstance<>("realistic-water.options.water", value -> tooltip(), (caption, value) -> caption,
			new OptionInstance.ValueSet<>() {
				@Override
				public Function<OptionInstance<Boolean>, AbstractWidget> createButton(OptionInstance.TooltipSupplier<Boolean> tooltip, Options options, int x, int y,
						int width, OptionInstance.ValueUpdateListener<? super Boolean> onValueChanged) {
					return option -> Button.builder(Component.translatable("realistic-water.options.water.button"),
							pressed -> Minecraft.getInstance().gui.setScreen(new WaterSettingsScreen(Minecraft.getInstance().gui.screen(), "")))
						.bounds(x, y, width, 20)
						.tooltip(tooltip())
						.build();
				}

				@Override
				public Optional<Boolean> validateValue(Boolean value) {
					return Optional.of(value);
				}

				@Override
				public Codec<Boolean> codec() {
					return Codec.BOOL;
				}
			}, true, value -> {
			});

	private WaterOptions() {
	}

	private static Tooltip tooltip() {
		return Tooltip.create(Component.translatable("realistic-water.options.water.tooltip"));
	}
}
