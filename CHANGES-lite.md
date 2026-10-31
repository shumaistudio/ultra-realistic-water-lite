# Ultra Realistic Water lite - change list (vs. Realistic Water 1.2.3 by Skaffy)
- WaterSettings.java: lite defaults, qualityPreset (0-3), simpleShading, adaptiveBudget, targetFrameMs, minBudget, chunkScansPerTick
- WaterSettingsInfo.java: new "Performance (lite)" category in /water gui
- WaterWorld.java: adaptive substep budget, configurable chunk scans, mesh-detail change triggers rebuild
- WaterRenderer.java + shaders/composite.frag: simple translucent shading path (no reflection/refraction/ripple/glint/foam lace)
- Rename: fabric.mod.json, lang, build.gradle.kts (jar = ultra-realistic-water-lite-*.jar), README
Build: ./gradlew build   (needs JDK 25) -> build/libs/
