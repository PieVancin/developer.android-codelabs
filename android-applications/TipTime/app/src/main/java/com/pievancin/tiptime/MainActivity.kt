package com.pievancin.tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pievancin.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    // initialize the viewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    // calculates the tip with the value in the textField
    private fun calculateTip() {
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        // displays 0 if the cost is zero or the textView is empty
        if (cost == null || cost == 0.0) {
            displayTip(0.0)
            return
        }

        // sets the value of multiplication for each option of tip
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        // calculates the tip value
        var tip = tipPercentage * cost

        // checks if the round up switch is checked, if true returns the rounded value
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }
        displayTip(tip)
    }

    // displays the tip calculated in a view
    private fun displayTip(tip: Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}