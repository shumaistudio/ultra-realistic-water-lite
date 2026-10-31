package me.skaffy.client.water;

import me.skaffy.ModSettings;
import me.skaffy.RealisticWater;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import net.fabricmc.loader.api.FabricLoader;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.TreeMap;

public final class WaterSettings {
	// ---- Ultra Realistic Water lite: performance / look settings ----
	/** 0 = Potato, 1 = Low (default), 2 = Medium, 3 = Original (the upstream mod's defaults). */
	public static int qualityPreset = 1;
	/** Flat translucent fluid: no reflections, no refraction, no ripples, no sun glint. */
	public static boolean simpleShading = true;
	/** Water colour (0-255 each), opacity and the cheap "metallic" shine, used by simple translucent shading. */
	public static int waterColorR = 0;
	public static int waterColorG = 53;
	public static int waterColorB = 148;
	public static float waterOpacity = 0.27F;
	public static float waterMetallic = 0.2F;
	/** Automatically lowers the number of simulation substeps when the frame time goes over the target. */
	public static boolean adaptiveBudget = true;
	public static float targetFrameMs = 16.7F;
	public static float minBudget = 0.34F;
	/** CPU side: how many chunks per tick are scanned for fluid blocks. */
	public static int chunkScansPerTick = 8;

	public static int resolution = 4;
	public static int boxMargin = 4;

	public static float cfl = 2.0F;
	public static float maxDt = 1.0F / 40.0F;
	public static int maxStepsPerFrame = 3;
	public static int renderMaxStepsPerFrame = 64;
	public static int cgIterations = 3;
	public static int mgCoarseSweeps = 8;
	public static int solverBottomCells = 8192;
	public static int solverSmallCells = 24000;
	public static int extrapolationLayers = 3;
	public static float flipRatio = 0.99F;
	public static float volumeCorrection = 2.0F;
	public static float maxSpeed = 40.0F;
	public static float gravity = 9.81F;

	public static boolean whitewater = false;
	public static float wwTrappedAirRate = 30.0F;
	public static float wwWaveCrestRate = 45.0F;
	public static float wwEnergyMin = 1.0F;
	public static float wwEnergyMax = 6.0F;
	public static float wwTrappedAirMin = 2.0F;
	public static float wwTrappedAirMax = 14.0F;
	public static float wwWaveCrestMin = 0.4F;
	public static float wwWaveCrestMax = 2.5F;
	public static float wwFoamLifeMin = 1.5F;
	public static float wwFoamLifeMax = 4.0F;
	public static float wwBubbleBuoyancy = 2.5F;
	public static float wwBubbleDrag = 0.6F;
	public static float wwSprayDrag = 0.4F;
	public static float wwSprayThreshold = 3.0F;
	public static float wwBubbleThreshold = 6.0F;
	public static int wwMaxPerParticle = 4;
	public static int wwCellLimit = 12;

	public static float filmFriction = 40.0F;
	public static float filmDepth = 0.08F;
	public static boolean sheetFill = false;
	public static boolean wallFill = true;
	public static float wallFillReach = 1.0F;
	public static float sheetSmoothing = 2.0F;
	public static float strandedTime = 1.5F;
	public static int strandedNeighbors = 12;

	public static int surfaceSubdivision = 1;
	public static float surfaceKernel = 2.5F;
	public static float surfaceRadius = 0.9F;
	public static float surfaceIso = 0.5F;
	public static float dropletThreshold = 0.35F;
	public static float nearCull = 0.05F;
	public static boolean surfaceGather = true;
	public static boolean sortParticles = true;
	public static boolean surfaceInteriorSkip = true;
	public static int surfaceInteriorCount = 4;

	public static float fluidRestSpeed = 0.25F;
	public static float fluidRestTime = 1.0F;
	public static int fluidRestWhitewater = 32;

	public static float particleRadius = 0.4F;
	public static float thicknessScale = 1.0F;
	public static float refraction = 0.15F;
	public static float absorbR = 0.45F;
	public static float absorbG = 0.12F;
	public static float absorbB = 0.07F;
	public static float scatterR = 0.03F;
	public static float scatterG = 0.08F;
	public static float scatterB = 0.11F;
	public static float scatterDensity = 0.5F;
	public static float underwaterFog = 0.1F;
	public static float surfaceSmoothing = 0.6F;
	public static float detailStrength = 0.4F;
	public static float detailScale = 6.0F;
	public static float detailSpeed = 1.4F;
	public static float roughness = 0.06F;
	public static float specular = 6.0F;
	public static float wetDarkening = 0.3F;
	public static float filmShading = 0.25F;
	public static float wwRadius = 0.012F;
	public static float wwMaxPixels = 2.5F;
	public static float foamCoverage = 1.2F;
	public static float foamSize = 3.0F;
	public static float foamBubbleSize = 0.05F;
	public static float bubbleAlpha = 0.25F;
	public static float sprayAlpha = 0.35F;

	public static float sourceFill = 0.9F;
	public static boolean bucketMakesSource = false;

	public static boolean flowSounds = true;
	public static float flowSoundVolume = 1.0F;

	public static int sandResolution = 8;
	public static float sandFrictionAngle = 15.0F;
	public static float sandCohesion = 0.015F;
	public static float sandStiffness = 62.5F;
	public static float sandWallFriction = 0.5F;
	public static float sandCfl = 0.35F;
	public static int sandMaxStepsPerFrame = 16;
	public static float sandImpactDamping = 0.5F;
	public static float sandImpactRate = 2.0F;
	public static float sandImpactCompression = 0.15F;
	public static float sandRestSpeed = 0.05F;
	public static float sandRestTime = 0.15F;
	public static float sandWakeAccel = 0.5F;
	public static float sandSurfaceIso = 0.5F;
	public static float sandSurfaceSmoothing = 0.6F;
	public static float sandGrainSize = 0.01F;
	public static int sandGrainsPerParticle = 32;
	public static float sandGrainSpread = 0.5F;
	public static float sandGrainMinPixels = 0.7F;
	public static float sandBrightness = 1.1F;
	public static boolean sandSounds = true;

	public static int leafResolution = 6;
	public static int leavesPerBlock = 200;
	public static int leafCellCapacity = 1;
	public static float leafSize = 0.3125F;
	public static float leafFallSpeed = 1.2F;
	public static float leafSinkSpeed = 0.25F;
	public static float leafFlutter = 0.8F;
	public static float leafAirDrag = 1.2F;
	public static float leafTumbleRate = 5.0F;
	public static float leafGroundFriction = 10.0F;
	public static int leafRepose = 2;
	public static float leafShuffleSpeed = 1.5F;
	public static float leafRestSpeed = 0.06F;
	public static float leafRestTime = 0.5F;
	public static float leafWakeSpeed = 0.3F;
	public static float leafKick = 1.4F;
	public static float leafBurnTime = 0.6F;
	public static float leafWindStrength = 2.5F;
	public static float leafWindLift = 0.5F;
	public static float leafMaxSpeed = 12.0F;
	public static int leafMaxStepsPerFrame = 8;
	public static float leafBrightness = 1.0F;
	public static boolean leafSounds = true;

	public static float waveMakerRate = 4.0F;
	public static float waveMakerSpeed = 1.0F;

	public static int lavaResolution = 4;
	public static float lavaFlipRatio = 0.9993F;
	public static float lavaMaxSpeed = 5.0F;
	public static float lavaFilmFriction = 140.0F;
	public static float lavaStrandedTime = 5.0F;
	public static int lavaStrandedNeighbors = 16;
	public static float lavaFilmDepth = 0.05F;
	public static float lavaRefraction = 0.04F;
	public static float lavaAbsorbR = 2.8F;
	public static float lavaAbsorbG = 5.5F;
	public static float lavaAbsorbB = 8.0F;
	public static float lavaScatterR = 1.2F;
	public static float lavaScatterG = 0.35F;
	public static float lavaScatterB = 0.05F;
	public static float lavaScatterDensity = 2.5F;
	public static float lavaUnderwaterFog = 0.35F;
	public static float lavaSurfaceSmoothing = 0.75F;
	public static float lavaDetailStrength = 0.25F;
	public static float lavaRoughness = 0.35F;
	public static float lavaSpecular = 2.5F;
	public static boolean lavaFlowSounds = true;
	public static boolean lavaIgniteFlammables = true;
	public static boolean lavaWaterMixing = true;
	public static float lavaMixLavaMin = 0.06F;
	public static float lavaMixWaterMin = 0.03F;

	public static int slimeResolution = 3;
	public static float slimeFlipRatio = 0.9F;
	public static float slimeMaxSpeed = 3.0F;
	public static float slimeVolumeCorrection = 6.0F;
	public static float slimeViscosity = 1.5F;
	public static int slimeViscosityIterations = 4;
	public static float slimeAdhesion = 18.0F;
	public static float slimeEntityStick = 0.85F;
	public static float slimeRestSpeed = 0.6F;
	public static float slimeRestTime = 0.1F;
	public static float slimeWakeSpeed = 1.5F;
	public static float slimeFilmFriction = 220.0F;
	public static float slimeFilmDepth = 0.15F;
	public static float slimeStrandedTime = 8.0F;
	public static int slimeStrandedNeighbors = 4;
	public static float slimeOpacity = 0.85F;
	public static float slimeBrightness = 1.0F;
	public static float slimeSurfaceSmoothing = 0.85F;
	public static float slimeInsideOpacity = 0.92F;
	public static float slimeFogDistance = 0.5F;
	public static boolean slimeSounds = true;

	public static boolean tntReactions = true;
	public static float tntBlastSpeed = 14.0F;
	public static float tntBlastReach = 2.0F;
	public static float tntUpwardBias = 0.35F;
	public static float tntScatter = 0.25F;

	public static float shaderLightScale = 2.5F;
	public static float shaderSpecularCap = 16.0F;
	public static float shaderShadowBias = 0.0004F;
	public static boolean shaderSkyFromScreen = true;
	public static boolean shadowStagger = true;
	public static float sandShaderSun = 3.4F;
	public static float sandShaderSky = 0.9F;

	public static String ffmpeg = "";
	public static boolean renderFreezeWorld = true;
	public static boolean renderSteadyPreview = true;
	public static float renderCameraSmoothing = 0.12F;

	public static final String[] PRESET_NAMES = {"Potato", "Low", "Medium", "Original"};

	// order: resolution, boxMargin, surfaceSubdivision, surfaceKernel, maxSteps, cgIterations, mgCoarseSweeps, extrapolationLayers,
	//        lavaRes, slimeRes, sandRes, leafRes, restTime, restSpeed, whitewater
	private static final float[][] PRESETS = {
		{3, 3, 1, 2.0F, 2, 2, 6, 2, 3, 3, 6, 4, 0.6F, 0.30F, 0},
		{4, 4, 1, 2.5F, 3, 3, 8, 3, 4, 3, 8, 6, 1.0F, 0.25F, 0},
		{6, 6, 2, 3.0F, 4, 5, 12, 4, 5, 4, 10, 8, 1.5F, 0.15F, 0},
		{6, 6, 2, 3.0F, 4, 5, 12, 4, 6, 4, 12, 8, 1.5F, 0.15F, 1},
	};

	public static void applyPreset(int preset) {
		float[] p = PRESETS[Math.clamp(preset, 0, PRESETS.length - 1)];
		resolution = (int) p[0];
		boxMargin = (int) p[1];
		surfaceSubdivision = (int) p[2];
		surfaceKernel = p[3];
		maxStepsPerFrame = (int) p[4];
		cgIterations = (int) p[5];
		mgCoarseSweeps = (int) p[6];
		extrapolationLayers = (int) p[7];
		lavaResolution = (int) p[8];
		slimeResolution = (int) p[9];
		sandResolution = (int) p[10];
		leafResolution = (int) p[11];
		fluidRestTime = p[12];
		fluidRestSpeed = p[13];
		whitewater = p[14] > 0.5F;
	}

	private static final Map<String, String> DEFAULTS = snapshot();

	private WaterSettings() {
	}

	private static Map<String, String> snapshot() {
		Map<String, String> out = new TreeMap<>();
		for (Map.Entry<String, Field> e : fields().entrySet()) {
			try {
				out.put(e.getKey(), String.valueOf(e.getValue().get(null)));
			} catch (IllegalAccessException ignored) {
			}
		}
		return out;
	}

	public static String defaultValue(String name) {
		return DEFAULTS.getOrDefault(name, "");
	}

	public static String get(String name) throws ReflectiveOperationException {
		Field f = fields().get(name);
		if (f == null) {
			throw new NoSuchFieldException(name);
		}
		return String.valueOf(f.get(null));
	}

	private static Path file() {
		return FabricLoader.getInstance().getConfigDir().resolve("realistic-water.properties");
	}

	public static void load() {
		Path file = file();
		if (!Files.exists(file)) {
			return;
		}
		Properties props = new Properties();
		try (Reader in = Files.newBufferedReader(file)) {
			props.load(in);
		} catch (IOException e) {
			RealisticWater.LOGGER.warn("Couldn't read {}", file, e);
			return;
		}
		if (props.containsKey("qualityPreset")) {
			try {
				set("qualityPreset", props.getProperty("qualityPreset"));
			} catch (ReflectiveOperationException | NumberFormatException e) {
				RealisticWater.LOGGER.warn("Skipping setting qualityPreset from {}", file);
			}
		}
		for (String name : props.stringPropertyNames()) {
			if (name.equals("qualityPreset")) {
				continue;
			}
			try {
				String value = props.getProperty(name);
				set(name, value.isEmpty() ? "-" : value);
			} catch (ReflectiveOperationException | NumberFormatException e) {
				RealisticWater.LOGGER.warn("Skipping setting {} from {}", name, file);
			}
		}
	}

	public static void save() {
		Properties props = new Properties();
		for (String name : fields().keySet()) {
			try {
				String value = get(name);
				if (!value.equals(defaultValue(name))) {
					props.setProperty(name, value);
				}
			} catch (ReflectiveOperationException ignored) {
			}
		}
		Path file = file();
		try {
			Files.createDirectories(file.getParent());
			try (Writer out = Files.newBufferedWriter(file)) {
				props.store(out, "Ultra Realistic Water lite settings that differ from the defaults (edit in game with /water)");
			}
		} catch (IOException e) {
			RealisticWater.LOGGER.warn("Couldn't save {}", file, e);
		}
	}

	public static void reset(String name) throws ReflectiveOperationException {
		if (DEFAULTS.containsKey(name)) {
			set(name, DEFAULTS.get(name).isEmpty() ? "-" : DEFAULTS.get(name));
		}
	}

	public static Map<String, Field> fields() {
		Map<String, Field> out = new TreeMap<>();
		for (Field f : WaterSettings.class.getFields()) {
			if (Modifier.isStatic(f.getModifiers())) {
				out.put(f.getName(), f);
			}
		}
		return out;
	}

	public static String set(String name, String value) throws ReflectiveOperationException {
		Field f = fields().get(name);
		if (f == null) {
			throw new NoSuchFieldException(name);
		}
		Class<?> t = f.getType();
		if (t == int.class) {
			f.setInt(null, Integer.parseInt(value));
		} else if (t == float.class) {
			f.setFloat(null, Float.parseFloat(value));
		} else if (t == boolean.class) {
			f.setBoolean(null, Boolean.parseBoolean(value));
		} else if (t == String.class) {
			f.set(null, value.equals("-") ? "" : value);
		}
		if ("qualityPreset".equals(name)) {
			qualityPreset = Math.clamp(qualityPreset, 0, PRESETS.length - 1);
			applyPreset(qualityPreset);
		}
		if ("lavaIgniteFlammables".equals(name) && t == boolean.class) {
			ModSettings.lavaIgniteFlammables = (boolean) f.get(null);
		}
		if ("lavaWaterMixing".equals(name) && t == boolean.class) {
			ModSettings.lavaWaterMixing = (boolean) f.get(null);
		}
		return String.valueOf(f.get(null));
	}
}
