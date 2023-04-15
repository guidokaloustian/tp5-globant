package com.pil.tp_04.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pil.tp_04.mvvm.contract.CounterContract

class CounterViewModel(private val model: CounterContract.Model) : ViewModel() {

    private val mutableLiveData: MutableLiveData<CounterData> = MutableLiveData()

    val data: LiveData<CounterData> = mutableLiveData

    fun resetValue() {
        model.reset()
        mutableLiveData.value = CounterData(CounterState.ZERO)
    }

    fun incValue(input: Int) {
        model.increment(input)
        mutableLiveData.value = CounterData(CounterState.INCREMENT, model.counter)
    }

    fun decValue(input: Int) {
        model.decrement(input)
        mutableLiveData.value = CounterData(CounterState.DECREMENT, model.counter)
    }

    data class CounterData(
        val state: CounterState = CounterState.ZERO,
        val value: Int = 0,
    )

    enum class CounterState {
        ZERO,
        INCREMENT,
        DECREMENT,
    }
}
