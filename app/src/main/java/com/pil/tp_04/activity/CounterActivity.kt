package com.pil.tp_04.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pil.tp_04.R
import com.pil.tp_04.databinding.ActivityMainBinding
import com.pil.tp_04.mvvm.contract.CounterContract
import com.pil.tp_04.mvvm.model.CounterModel
import com.pil.tp_04.mvvm.viewmodel.CounterViewModel

class CounterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: CounterContract.Model = CounterModel()
    private val viewModel: CounterViewModel = CounterViewModel(model)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.increment.setOnClickListener { viewModel.incValue(getInputInt(binding.inputCount.text.toString())) }
        binding.decrement.setOnClickListener { viewModel.decValue(getInputInt(binding.inputCount.text.toString())) }
        binding.reset.setOnClickListener { viewModel.resetValue() }

        viewModel.data.observe({ lifecycle }, ::updateUI)
    }

    private fun updateUI(data: CounterViewModel.CounterData) {
        when (data.state) {
            CounterViewModel.CounterState.ZERO -> {
                binding.counter.text = getString(R.string.initial_value)
                showToast(getString(R.string.reset_button))
            }
            CounterViewModel.CounterState.INCREMENT -> {
                binding.counter.text = data.value.toString()
                showToast(getString(R.string.increment_button))
            }
            CounterViewModel.CounterState.DECREMENT -> {
                binding.counter.text = data.value.toString()
                showToast(getString(R.string.decrement_button))
            }
        }
    }

    private fun getInputInt(input: String): Int = input.ifEmpty { ZERO_STRING }.toInt()

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val ZERO_STRING = "0"
    }
}
