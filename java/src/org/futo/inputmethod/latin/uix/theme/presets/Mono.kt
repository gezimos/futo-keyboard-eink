package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedLightColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption
import org.futo.inputmethod.latin.uix.theme.selector.ThemePreview

// Flat monochrome theme: pure white surfaces, black glyphs, no key shadows.
private val lightScheme = extendedLightColorScheme(
    primary=Color(0xFF000000),
    onPrimary=Color(0xFFFFFFFF),
    primaryContainer=Color(0xFFFFFFFF),
    onPrimaryContainer=Color(0xFF000000),
    secondary=Color(0xFF000000),
    onSecondary=Color(0xFFFFFFFF),
    secondaryContainer=Color(0xFFFFFFFF),
    onSecondaryContainer=Color(0xFF000000),
    tertiary=Color(0xFF000000),
    onTertiary=Color(0xFFFFFFFF),
    tertiaryContainer=Color(0xFFFFFFFF),
    onTertiaryContainer=Color(0xFF000000),
    error=Color(0xFF991818),
    onError=Color(0xFFFFFFFF),
    errorContainer=Color(0xFFFFD6D6),
    onErrorContainer=Color(0xFF732323),
    outline=Color(0xFF000000),
    outlineVariant=Color(0xFFFFFFFF),
    surface=Color(0xFFFFFFFF),
    onSurface=Color(0xFF000000),
    onSurfaceVariant=Color(0xFF000000),
    surfaceContainerHighest=Color(0xFFFFFFFF),
    shadow=Color(0xFF000000).copy(alpha = 0f),
    keyboardSurface=Color(0xFFFFFFFF),
    keyboardSurfaceDim=Color(0xFFFFFFFF),
    keyboardContainer=Color(0xFFFFFFFF),
    keyboardContainerVariant=Color(0xFFFFFFFF),
    onKeyboardContainer=Color(0xFF000000),
    keyboardPress=Color(0xFFFFFFFF),
    keyboardFade0=Color(0xFFFFFFFF),
    keyboardFade1=Color(0xFFFFFFFF),
    primaryTransparent=Color(0xFF000000).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFF000000).copy(alpha = 0.1f),
    keyboardContainerPressed=Color(0xFFFFFFFF),
    onKeyboardContainerPressed=Color(0xFF000000),
    // Transparent hides the corner hint glyphs (numbers/symbols) while long-press still works
    hintColor=Color.Transparent,
)

val Mono = ThemeOption(
    dynamic = false,
    key = "Mono",
    name = R.string.theme_mono,
    available = { true }
) {
    lightScheme
}

@Composable
@Preview
private fun PreviewThemeLight() {
    ThemePreview(Mono)
}
