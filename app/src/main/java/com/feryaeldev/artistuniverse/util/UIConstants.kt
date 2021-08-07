package com.feryaeldev.artistuniverse.util

object UIConstants {

    const val VIEW_OPACITY = 0.5f
    const val SHADOW_OPACITY = 0.2f
    const val LOGO_HEIGHT = 18

}

enum class FontSize(val size: Int) {
    TITLE(24),
    SUBTITLE(22),
    HEAD(18),
    SUBHEAD(16),
    BODY(15),
    BUTTON(14),
    CAPTION(12)
}

enum class Size(val size: Int) {
    NONE(0),
    VERY_SMALL(4),
    SMALL(8),
    MEDIUM(16),
    MEDIUM_BIG(24),
    BIG(32),
    VERY_BIG(40),
    GIGANT(80)
}