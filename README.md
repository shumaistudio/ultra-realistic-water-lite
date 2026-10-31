# Ultra Realistic Water lite

[日本語版はこちら / Japanese](README.ja.md)

> **This is a modified (forked) version of [Realistic Water](https://github.com/sskaffy/Realistic-Water) by Skaffy. It is NOT the original mod.**
> Original project: https://github.com/sskaffy/Realistic-Water - please support the original author.
> Distributed under the original license (see [LICENSE](LICENSE), kept intact). Not for sale, no paywalls.

A lighter variant of Realistic Water for Fabric (Minecraft 26.3), made to run on integrated GPUs (for example Ryzen 5 7000 series with 16 GB RAM).
The fluid simulation (water, lava, slime, sand, leaves) is the original mod's GPU simulation; this fork changes how it is drawn and how heavy it is.

## What is different from the original
- **Simple translucent fluids.** No reflections, refraction, ripples, sun glint or foam lace. Water is one flat colour with an opacity (no depth haze, no blur). Toggle: `simpleShading`.
- **Water colour settings**: Red / Green / Blue (0-255), Opacity, and "Metallic shine" (a cheap brightening, not a reflection). Defaults: R 0, G 53, B 148, opacity 0.27, metallic 0.2.
- **Quality presets** `qualityPreset`: 0 Potato, 1 Low (default), 2 Medium, 3 Original (upstream defaults). Sets particle density (resolution), surface mesh detail, solver iterations, whitewater and sleep behaviour in one go.
- **Adaptive budget**: lowers simulation substeps when the frame time is above `targetFrameMs`, never raises them above your settings.
- `chunkScansPerTick` (CPU side) controls how fast fluid blocks are found in newly loaded chunks.
- Lower default simulation settings, whitewater off by default. Changing the surface mesh detail rebuilds the fluid bodies immediately.
- **Settings are reachable from Options > Video Settings > "Water Settings..."** (also `/water gui`).
- Japanese translation.
- Name changed to *Ultra Realistic Water lite* (mod id stays `realistic-water`, so worlds and items stay compatible with the original).

The simulation runs through Vulkan compute on the GPU, so more CPU cores do not make it faster; on an integrated GPU the best levers are `qualityPreset`, `resolution` and `surfaceSubdivision`. Dual-channel RAM helps iGPUs a lot.

## Install
1. Install [Fabric](https://docs.fabricmc.net/players/installing-fabric/) for Minecraft 26.3 (Fabric API required).
2. Put `ultra-realistic-water-lite-<version>.jar` in your `mods` folder (do not use the `-sources` jar).
3. In Options > Video Settings set **Graphics API to Vulkan** and restart the game.
4. Search "Realistic" in the creative inventory. Use `/water gui` or Video Settings > Water Settings... to tune things.

Mods that hook into rendering (Sodium, Iris, ...) may not be stable together with this mod.
Do not use the original mod and this fork at the same time (same mod id).

## Build
Requires JDK 25.
```
./gradlew build          # Windows: gradlew.bat build
```
The jar appears in `build/libs/`. A GitHub Actions workflow (`.github/workflows/build.yml`) builds it on every push.

## Commands
`/water gui`, `/water set <setting> <value>`, `/water remove`, ... (same as the original mod). Example: `/water set qualityPreset 0`.

## Credits and license
- Original mod, code and assets: **Skaffy** - https://github.com/sskaffy/Realistic-Water
- Original credits: https://github.com/claude and https://github.com/eva-akselrad
- This fork follows the fork conditions of the original license: credit to the author, link to the original, modified-version notice, same license. See [LICENSE](LICENSE).
