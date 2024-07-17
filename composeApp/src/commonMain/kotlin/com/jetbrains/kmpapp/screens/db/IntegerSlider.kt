package com.jetbrains.kmpapp.screens.db

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Suppress("FunctionName")
@Composable
fun IntegerSlider(
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: IntRange = 0..100
) {
    // Convert the integer range to a float range
    val floatRange = valueRange.first.toFloat()..valueRange.last.toFloat()
    
    // Remember the current value as a float to interact with the Slider component
    val floatValue = remember { mutableStateOf((value.toFloat() - floatRange.start) / (floatRange.endInclusive - floatRange.start)) }
    
    Box(modifier = modifier) {
        Slider(
            value = floatValue.value,
            onValueChange = { newValue ->
                // Convert the new float value back to an integer within the original range
                val intValue = ((newValue * (floatRange.endInclusive - floatRange.start)) + floatRange.start).toInt()
                onValueChange(intValue)
            },
            enabled = enabled,
            valueRange = floatRange
        )
    }
}
