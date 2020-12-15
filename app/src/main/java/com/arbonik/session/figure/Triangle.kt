package com.arbonik.session.figure

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Path.FillType
import android.graphics.PointF


class Triangle : Figure() {
    val path = Path()

    override val minimumPointToCreate: Int
        get() = 3

    override fun draw(canvas: Canvas, paint: Paint) {
        super.draw(canvas, paint)
        myPaint?.style = Paint.Style.FILL_AND_STROKE
        canvas.drawPath(path, myPaint!!)
    }

    override fun instance(points: MutableList<PointF>): Figure = Triangle().apply {
        path.setFillType(FillType.EVEN_ODD)
        path.setLastPoint(points[0].x, points[0].y)
        path.lineTo(points[0].x, points[0].y)
        path.lineTo(points[1].x, points[1].y)
        path.lineTo(points[2].x, points[2].y)
        path.close()
    }
}