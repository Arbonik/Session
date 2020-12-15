package com.arbonik.session

import android.graphics.PointF
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arbonik.session.command.Command
import com.arbonik.session.figure.Figure
import com.arbonik.session.figure.Oval
import com.arbonik.session.figure.Rectangle
import com.arbonik.session.figure.Triangle

class CanvasViewModel : ViewModel() {

    var selectedFigure: Int = 0

    var figures = MutableLiveData<MutableList<Figure>?>()
    var points = mutableListOf<PointF>()
    var commands = mutableListOf<Command>()

    fun addPressPoint(pointF: PointF) {
        points.add(pointF)
    }

    fun createFigure(){
        getFigure()?.let {
            if (it.canCreated(points)) {

                commands.add(object : Command {
                    override fun execute() {
                        figures.postValue(figures.value?.apply { remove(last()) })
                        commands.remove(this)
                    }
                })

                figures.postValue(figures.value?.apply { add(it.instance(points)) }
                    ?: mutableListOf(it.instance(points)))
                points.clear()
            }
        }
    }

    private fun getFigure(): Figure? =  when (selectedFigure){
        0 -> Rectangle(PointF(), 0f, 0f)
        1 -> Oval(PointF(), 0f, 0f)
        2 -> Triangle()
        else -> null
    }
}


