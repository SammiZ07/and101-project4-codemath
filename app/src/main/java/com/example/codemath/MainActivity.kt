package com.example.codemath

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.codemath.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Spinner setup
        val tips = resources.getStringArray(R.array.tipPercents)
        binding.spTip.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            tips
        )

        // Listeners that trigger recalculation
        binding.etBill.addTextChangedListener(simpleWatcher)
        binding.etPeople.addTextChangedListener(simpleWatcher)
        binding.spTip.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                recalc()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) { recalc() }
        }
        binding.rgRound.setOnCheckedChangeListener { _, _ -> recalc() }

        // Clear button (interactive view)
        binding.btnClear.setOnClickListener {
            binding.etBill.text?.clear()
            binding.etPeople.text?.clear()
            binding.rbNoRound.isChecked = true
            binding.spTip.setSelection(2) // default to 15%
            recalc()
        }

        // initial state
        binding.spTip.setSelection(2) // 15%
        recalc()
    }

    private val simpleWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) { recalc() }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    private fun recalc() {
        val bill = binding.etBill.text.toString().toDoubleOrNull() ?: 0.0
        val people = (binding.etPeople.text.toString().toIntOrNull() ?: 1).coerceAtLeast(1)

        val pctText = binding.spTip.selectedItem?.toString()?.replace("%", "") ?: "15"
        val tipPct = (pctText.toDoubleOrNull() ?: 15.0) / 100.0

        var tip = bill * tipPct
        var total = bill + tip

        when (binding.rgRound.checkedRadioButtonId) {
            binding.rbRoundTip.id -> {
                tip = ceil(tip)
                total = bill + tip
            }
            binding.rbRoundTotal.id -> {
                total = ceil(total)
                tip = (total - bill).coerceAtLeast(0.0)
            }
            else -> { /* no rounding */ }
        }

        val perPerson = if (people > 0) total / people else total

        binding.tvTip.text = "Tip: $" + twoDec(tip)
        binding.tvTotal.text = "Total: $" + twoDec(total)
        binding.tvPerPerson.text = "Per person: $" + twoDec(perPerson)
    }

    private fun twoDec(v: Double): String = String.format("%.2f", v)
}