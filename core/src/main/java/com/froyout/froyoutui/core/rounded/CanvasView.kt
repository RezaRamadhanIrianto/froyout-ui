package com.froyout.froyoutui.core.rounded

import android.graphics.Color

interface CanvasView {
    var topRightRadius: Float
    var topLeftRadius: Float
    var bottomRightRadius: Float
    var bottomLeftRadius: Float
    var borderWidth: Float
    var borderColor: Int
    var colorBackground: Int

    fun roundedArray(): FloatArray
}