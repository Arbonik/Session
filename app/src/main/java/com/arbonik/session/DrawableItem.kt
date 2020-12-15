package com.arbonik.session

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

interface DrawableItem{
    var myPaint : Paint?
    fun draw(canvas: Canvas, paint: Paint)
}