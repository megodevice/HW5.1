package com.example.hw51.data

import android.graphics.Color
import android.view.View


class Presenter private constructor() {
    private val model = Injector.getModel()
    private lateinit var view: SimpleCounter

    companion object {
        fun createInstance(view: SimpleCounter): Presenter {
            val presenter = Presenter()
            presenter.initView(view)
            return presenter
        }
    }

    private fun initView(view: SimpleCounter) {
        this.view = view
    }

    fun inc() {
        model.inc()
        whenCountChanged()
    }

    fun dec() {
        model.dec()
        whenCountChanged()
    }

    private fun whenCountChanged() {
        view.showCount(model.count)
        changeTextSize()
        changeTextColor()
        changeButtonVisibility()
        showToast()
    }

    private fun showToast() {
        if (model.count == 10)
            view.showToast()
    }

    private fun changeTextSize() {
        if (model.count > 5)
            view.changeTextSize(40f)
        else
            view.changeTextSize(14f)
    }

    private fun changeTextColor() {
        if (model.count > 14)
            view.changeTextColor(Color.GREEN)
    }

    private fun changeButtonVisibility() {
        if (model.count % 2 == 0)
            view.setVisibilityButton(View.VISIBLE)
        else
            view.setVisibilityButton(View.GONE)
    }
}