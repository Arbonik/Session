package com.arbonik.session

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CanvasView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    var paint = Paint()
    var drawableITems : MutableList<DrawableItem> = mutableListOf()

    override fun onDraw(canvas: Canvas) {
        canvas?.drawColor(Color.WHITE)
        drawGrid(canvas)
        drawItems(drawableITems, canvas)
        super.onDraw(canvas)
    }

    private fun drawItems(drawableITems: MutableList<DrawableItem>, canvas: Canvas) {
        drawableITems.forEach {
            it.draw(canvas, paint)
        }
    }


    fun drawGrid(canvas: Canvas){
        val gridPaint = Paint().apply {
            color = Color.BLACK
            strokeWidth = 4f
        }
        val dx = canvas.width / 20
        val dy = canvas.width / 20

        for (y in 0..canvas.height step dy)
            canvas.drawLine(0f, y.toFloat(), canvas.width.toFloat(), y.toFloat(), gridPaint)

        for (x in 0..canvas.width step dx)
            canvas.drawLine(x.toFloat(), 0f, x.toFloat(), canvas.height.toFloat(), gridPaint)
    }
}

