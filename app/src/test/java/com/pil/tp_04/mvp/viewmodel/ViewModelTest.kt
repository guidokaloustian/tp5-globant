package com.pil.tp_04.mvp.viewmodel

import com.pil.tp_04.mvvm.model.CounterModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.pil.tp_04.mvvm.viewmodel.CounterViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: CounterViewModel

    @Before
    fun setup() {
        viewModel = CounterViewModel(CounterModel())

    }

    @Test
    fun `on increment button pressed with number test`() {
        viewModel.incValue(FIVE)

        assert(viewModel.data.value != null)
        assert(viewModel.data.value?.value == FIVE)
    }

//    @Test
//    fun `on increment button pressed without number test`() {
//        every { view.getInputValue() } returns EMPTY_STRING
//
//        presenter.onIncrementButtonPressed()
//
//        verify { view.showCounter(ZERO_STRING) }
//    }

    @Test
    fun `on decrement button pressed test`() {
        viewModel.decValue(NEGATIVE_FIVE)

        assert(viewModel.data.value != null)
        assert(viewModel.data.value?.value == NEGATIVE_FIVE)
    }

    @Test
    fun `on reset button pressed test`() {
        viewModel.resetValue()

        assert(viewModel.data.value != null)
        assert(viewModel.data.value?.value == ZERO)
    }

    companion object {
        private const val ZERO = 0
        private const val FIVE = 5
        private const val NEGATIVE_FIVE = -5
    }
}