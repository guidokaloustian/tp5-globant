package com.pil.tp_04.mvvm.model

import com.pil.tp_04.mvvm.contract.CounterContract

class CounterModel : CounterContract.Model {
    override var counter: Int = CounterModel.ZERO

    override fun increment(inputValue: Int) {
        counter += inputValue
    }

    override fun decrement(inputValue: Int) {
        counter -= inputValue
    }

    override fun reset() {
        counter = CounterModel.ZERO
    }

    companion object {
        private const val ZERO = 0
    }
}
