package com.froyout.froyoutui.core.rounded

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.graphics.RectF
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.ViewOutlineProvider
import androidx.constraintlayout.widget.ConstraintLayout
import com.froyout.froyoutui.core.R
import java.lang.Exception

open class RoundedConstraint: ConstraintLayout {

    var topRightRadius = 0f
    var topLeftRadius = 0f
    var bottomRightRadius = 0f
    var bottomLeftRadius = 0f
    var cornerRadius = 0f
        set(value){
            field = value
            topRightRadius = value
            topLeftRadius = value
            bottomRightRadius = value
            bottomLeftRadius = value
        }
    var colorBackground = 0
    var borderWidth = 0f
    var borderColor = 0

    var path:Path? = null
    lateinit var canvasRounder: CanvasView

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(attrs)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(attrs)
    }

    constructor(context: Context) : super(context) {
        initView(null)
    }

    private fun initView(attrs: AttributeSet?){
        attrs?.let{
            with(context.obtainStyledAttributes(it, R.styleable.RoundedConstraint)){
                topRightRadius = getDimensionPixelSize(R.styleable.RoundedConstraint_topRightRadius, 0).toFloat()
                topLeftRadius = getDimensionPixelSize(R.styleable.RoundedConstraint_topLeftRadius, 0).toFloat()
                bottomRightRadius = getDimensionPixelSize(R.styleable.RoundedConstraint_bottomRightRadius, 0).toFloat()
                bottomLeftRadius = getDimensionPixelSize(R.styleable.RoundedConstraint_bottomLeftRadius, 0).toFloat()
                cornerRadius = getDimensionPixelSize(R.styleable.RoundedConstraint_cornerRadius, 0).toFloat()
                colorBackground = getColor(R.styleable.RoundedConstraint_colorBackground, resources.getColor(android.R.color.transparent, null))
                borderColor = getColor(R.styleable.RoundedConstraint_borderColor, resources.getColor(android.R.color.transparent, null))
                borderWidth = getDimensionPixelSize(R.styleable.RoundedConstraint_borderWidth, 0).toFloat()
            }
        }

        canvasRounder = CanvasRounder(topRightRadius, topLeftRadius, bottomRightRadius, bottomLeftRadius, colorBackground, borderColor, borderWidth)
    }

    override fun dispatchDraw(canvas: Canvas) {

        path = null

        if(path != null){
            path = Path()
        }

        canvasRounder.roundedArray().let {
            clipCanvas(canvas, it)
        }

        with(GradientDrawable()) {
            cornerRadii = canvasRounder.roundedArray()

            if (canvasRounder.borderWidth != 0F) {
                setStroke(canvasRounder.borderWidth.toInt(), canvasRounder.borderColor)
            }

            setColor(colorBackground)

            background = this
        }

        try {
            val opv = outlineProvider
            outlineProvider = opv
        } catch (e: Exception) {
            e.printStackTrace()
        }

        clipChildren = false

        super.dispatchDraw(canvas)
    }

    private fun clipCanvas(canvas: Canvas, floatArray: FloatArray) {
        path?.let {
            it.addRoundRect(
                RectF(0F, 0F, canvas.width.toFloat(), canvas.height.toFloat()),
                floatArray,
                Path.Direction.CW
            )
            canvas.clipPath(it)
        }
    }

    override fun setOutlineProvider(provider: ViewOutlineProvider?) {
        super.setOutlineProvider(provider)
    }
}