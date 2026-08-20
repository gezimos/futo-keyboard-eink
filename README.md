# FUTO Keyboard for E-Ink

An unofficial fork of [FUTO Keyboard](https://github.com/futo-org/android-keyboard), retuned for e-ink displays. **Not affiliated with, endorsed by, or supported by FUTO Holdings, Inc.**

> **This software has been modified from the original.**
> All modifications are visual. They currently live in one commit, [`15a2e8ff`](https://github.com/gezimos/futo-keyboard-eink/commit/15a2e8ff6ae9099978e27a000add992b48c4a987) — 124 files, +494/−471. Full breakdown in [What's different](#whats-different-from-upstream) below.
>
> For the unmodified original, see [futo-org/android-keyboard](https://github.com/futo-org/android-keyboard).

Upstream's goal — a good modern keyboard that stays offline and doesn't spy on you — is unchanged here. FUTO Keyboard is itself a fork of [LatinIME, The Android Open-Source Keyboard](https://android.googlesource.com/platform/packages/inputmethods/LatinIME), with significant changes made to it.

## What's different from upstream

E-ink panels repaint slowly and render colour as flat grey. Upstream's theming leans on tonal palettes, gradients and shadow elevation, which either ghost or wash out on e-ink. This fork strips all of that down to pure black-on-white.

**Theming**
- New `Mono` theme: `#FFFFFF` surfaces, `#000000` glyphs and outlines, shadow alpha forced to `0`.
- `Mono` is now the *only* registered theme and the default. The other 21 presets are unregistered — Dark/Light Mode, Dynamic System/Dark/Light, Classic Material Dark/Light, AMOLED Dark Purple, Sunflower, Snowfall, Steel Gray, Emerald, Cotton Candy, Deep Sea Light/Dark, Gradient1, Voice Input, Hot Dog, Dev, High Contrast Yellow, Catppuccin Mocha.
- Theme picker removed from the settings home screen; the Themes action removed from the favourites row.

**Keyboard surface**
- Enter key renders as a plain icon with no fill; spacebar is drawn as a thin horizontal line; the long-press panel is white with a hairline outline.
- Key hint glyphs (the small corner numbers/symbols) are hidden via a transparent `hintColor`. **Long-press still produces the same characters** — only the glyph is hidden.
- Key-preview popup is off by default (`config_default_key_preview_popup` flipped to `false` across all four form-factor configs).

**App chrome**
- Roughly 100 white vector drawables recoloured to black app-wide.
- Launcher icon background changed from `#1E293B` to `#FFFFFF`.
- Settings, import and payment activities pinned to a new `Theme.MonoSettings` (light, `windowAnimationStyle` set to `@null`) — no day/night switching and no window enter/exit animations.

**Deliberately unchanged**: layouts, prediction, swipe, voice input, offline behaviour, the app name ("FUTO Keyboard") and the package ID (`org.futo.inputmethod.latin`) — so this installs and behaves as FUTO Keyboard on-device rather than as a separate app.

## Issue tracking

Report issues with **this fork** here: [https://github.com/gezimos/futo-keyboard-eink/issues](https://github.com/gezimos/futo-keyboard-eink/issues)

For anything not e-ink-specific — an upstream bug, a layout problem, a language model issue — report it to FUTO instead: [https://github.com/futo-org/android-keyboard/](https://github.com/futo-org/android-keyboard/). Please don't send fork-specific reports to FUTO's tracker.

Upstream contribution notes, for reference: pull requests to FUTO's repository require signing a [CLA](https://cla.futo.org/); contributions to the [layouts repo](https://github.com/futo-org/futo-keyboard-layouts) don't, as they're Apache-2.0. Translations go through FUTO's [Pontoon instance](https://i18n-keyboard.futo.org/).

## Building

Clone recursively — the build needs several submodules:
```
git clone --recursive https://github.com/gezimos/futo-keyboard-eink.git
```

If you forgot to specify recursive clone, use this to fetch submodules:
```
git submodule update --init --recursive
```

You can then open the project in Android Studio and build it that way, or use gradle commands:
```
./gradlew assembleUnstableDebug
./gradlew assembleStableRelease
```

Note that `unstable` is the default product flavor and carries an `.unstable` application ID suffix, so it installs *alongside* a `stable` build rather than replacing it. To build and install onto an existing stable install:
```
./gradlew installStableDebug
```

If gradle reports `SDK location not found`, create a `local.properties` file in the repository root pointing at your SDK, for example `sdk.dir=/Users/you/Library/Android/sdk`. This file is machine-local and not committed.

## APK signing

Builds from this fork are signed with a local debug or self-managed key. **They do not match FUTO's official signing key**, and the fingerprints published by upstream will not verify them. Verify these builds against your own key.

If you want official, FUTO-signed FUTO Keyboard builds and their published fingerprints, get them from [keyboard.futo.tech](https://keyboard.futo.tech/) — not from this repository.

## License

The code is licensed under the [FUTO Source First License 1.1](LICENSE.md), which permits modification and redistribution for non-commercial purposes, free of charge. The original AOSP keyboard code is Apache-2.0; see [NOTICE](NOTICE).

"FUTO" is a trademark of FUTO Holdings, Inc. It is used here only to identify the upstream project this fork is derived from.
