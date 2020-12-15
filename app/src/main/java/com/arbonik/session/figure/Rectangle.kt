package com.arbonik.session.figure

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF

open class Rectangle(
    point: PointF,
    var width: Float,
    var height: Float
) : Figure(point) {
    override val minimumPointToCreate: Int
        get() = 2

    override fun instance(points: MutableList<PointF>): Figure {
        val start = points.first()
        val h = points.last().y - start.y
        val w = points.last().x - start.x
        return Rectangle(start, w, h)
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        super.draw(canvas, paint)
        canvas.drawRect(position.x, position.y, position.x + width, position.y + height, myPaint!!)
    }

}