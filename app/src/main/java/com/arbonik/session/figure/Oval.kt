package com.arbonik.session.figure

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF

class Oval(
    point: PointF,
     width: Float,
    height: Float) : Rectangle(point, width, height) {

    override fun instance(points: MutableList<PointF>): Figure {
        val start = points.first()
        val h = points.last().y - start.y
        val w = points.last().x - start.x
        return Oval(start, w, h)
    }

    override fun draw(canvas: Canvas, paint: Paint) {
        canvas.drawOval(position.x, position.y, position.x + width, position.y + height, paint)
    }
}