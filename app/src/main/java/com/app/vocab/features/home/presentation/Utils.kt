package com.app.vocab.features.home.presentation

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object Utils {
    fun generateLightRandomColor(): Color {
        val colorOptions = listOf(
            Color(0xFFE6E6FA),  // Lavender
            Color(0xFFFFF0F5),  // Lavender Blush
            Color(0xFFF0F8FF),  // Alice Blue
            Color(0xFFF5F5DC),  // Beige
            Color(0xFFFFFAF0),  // Floral White
            Color(0xFFFFF5EE),  // Seashell
            Color(0xFFF0FFF0),  // Honeydew
            Color(0xFFF5FFFA),  // Mint Cream
            Color(0xFFFAEBD7),  // Antique White
            Color(0xFFFFFDD0)   // Pale Goldenrod
        )

        return colorOptions[Random.nextInt(colorOptions.size)]
    }
}