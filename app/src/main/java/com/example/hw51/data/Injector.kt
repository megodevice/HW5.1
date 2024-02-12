package com.example.hw51.data

class Injector {
    companion object {
        fun getPresenter(view: SimpleCounter) = Presenter.createInstance(view)
        fun getModel() = CounterModel()
    }
}