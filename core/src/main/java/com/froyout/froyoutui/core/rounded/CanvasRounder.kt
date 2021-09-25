package com.froyout.froyoutui.core.rounded

import android.graphics.Color

class CanvasRounder(
    topRight: Float,
    topLeft: Float,
    bottomRight: Float,
    bottomLeft: Float,
    background: Int,
    borderC: Int,
    borderW: Float
    ): CanvasView {
    override var topRightRadius: Float = topRight
    override var topLeftRadius: Float = topLeft
    override var bottomRightRadius: Float = bottomRight
    override var bottomLeftRadius: Float = bottomLeft
    override var borderWidth: Float = borderW
    override var borderColor: Int = borderC
    override var colorBackground: Int = background

    override fun roundedArray(): FloatArray{
        return floatArrayOf(topRightRadius, topRightRadius, topLeftRadius, topLeftRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius)
    }
}