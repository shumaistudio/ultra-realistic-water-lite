# Ultra Realistic Water lite

[English](README.md)

> **これは Skaffy 氏の [Realistic Water](https://github.com/sskaffy/Realistic-Water) を改造したフォーク版で、オリジナルのMODではありません。**
> 元のプロジェクト: https://github.com/sskaffy/Realistic-Water (ぜひ本家も応援してください)
> 元のライセンスに従って配布しています([LICENSE](LICENSE) はそのまま)。販売・有料化は禁止です。

Realistic Water を、内蔵GPU(例: Ryzen 5 7000 シリーズ + メモリ16GB)でも動かしやすくした軽量版です(Fabric / Minecraft 26.3)。
水・溶岩・スライム・砂・葉のシミュレーション本体は元MODのGPUシミュレーションで、このフォークは「描画の仕方」と「処理の重さ」を変えています。

## 元MODとの違い
- **シンプルな半透明の流体**: 反射・屈折・さざ波・太陽の反射光・泡のレース模様をなくしました。水は単色+不透明度で描画され、深さによるかすみやぼかしもありません(`simpleShading` で切り替え)。
- **水の色の設定**: 赤・緑・青(0〜255)、不透明度、メタリック光沢(反射ではなく、明るくするだけの簡易表現)。初期値は R 0 / G 53 / B 148、不透明度 0.27、メタリック 0.2。
- **品質プリセット** `qualityPreset`: 0 Potato / 1 Low(初期値) / 2 Medium / 3 Original(元の初期設定)。粒子密度(解像度)、水面メッシュの細かさ、ソルバー反復数、白波、静止の挙動をまとめて切り替えます。
- **自動負荷調整**: フレーム時間が `targetFrameMs` を超えたらサブステップ数を減らします(設定値以上には増やしません)。
- `chunkScansPerTick`(CPU側): 新しく読み込んだチャンクで流体ブロックを見つける速さを変えます。
- 初期設定を軽くし、白波は初期オフ。水面メッシュの細かさを変えると即座に作り直されます。
- **オプション → ビデオ設定 → 「水の設定...」** から設定を開けます(`/water gui` でも可)。
- 日本語対応。
- 名前を *Ultra Realistic Water lite* に変更(MOD ID は `realistic-water` のままなので、元MODとワールド・アイテムの互換性があります)。

シミュレーションは Vulkan のコンピュートシェーダーでGPU上で動くため、CPUコアを増やしても速くなりません。内蔵GPUでは `qualityPreset`・`resolution`・`surfaceSubdivision` が効きます。メモリはデュアルチャネルにすると内蔵GPUがかなり速くなります。

## 導入
1. Minecraft 26.3 用の [Fabric](https://docs.fabricmc.net/players/installing-fabric/) を入れます(Fabric API が必要)。
2. `ultra-realistic-water-lite-<バージョン>.jar` を `mods` フォルダに入れます(`-sources` が付いたjarは不要)。
3. オプション → ビデオ設定で **グラフィックスAPIを Vulkan** にして再起動します。
4. クリエイティブのインベントリで「Realistic(リアル)」を検索。調整は `/water gui` かビデオ設定の「水の設定...」から。

Sodium や Iris など描画に介入するMODとは、安定して動かない場合があります。
元のMODとこのフォークは(同じMOD IDなので)同時に入れないでください。

## ビルド
JDK 25 が必要です。
```
./gradlew build          # Windows: gradlew.bat build
```
`build/libs/` にjarができます。GitHub Actions(`.github/workflows/build.yml`)でもpushごとにビルドされます。

## コマンド
`/water gui`、`/water set <設定名> <値>`、`/water remove` など(元MODと同じ)。例: `/water set qualityPreset 0`

## クレジットとライセンス
- 元のMOD・コード・アセット: **Skaffy** - https://github.com/sskaffy/Realistic-Water
- 元のクレジット: https://github.com/claude , https://github.com/eva-akselrad
- このフォークは元ライセンスのフォーク条件(作者のクレジット、元プロジェクトへのリンク、改変版の明記、同一ライセンス)に従っています。詳細は [LICENSE](LICENSE) を参照してください。
