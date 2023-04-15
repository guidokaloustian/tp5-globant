package com.pil.tp_04.mvvm.contract

interface CounterContract {

    interface Model {
        var counter: Int
        fun increment(number: Int)
        fun decrement(number: Int)
        fun reset()
    }

}
