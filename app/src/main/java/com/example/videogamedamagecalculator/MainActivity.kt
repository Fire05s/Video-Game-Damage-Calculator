package com.example.videogamedamagecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import com.example.videogamedamagecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.baseDmgInput.highlightColor = Color.WHITE
        binding.baseResistInput.highlightColor = Color.WHITE

        binding.calculateButton.setOnClickListener {
            val dmgText = binding.baseDmgInput.text.toString()
            val resText = binding.baseResistInput.text.toString()
            var dmgValue = dmgText.toDouble()
            var resValue = resText.toDouble()
            if (binding.damageBuff.isChecked) {
                dmgValue *= 1.5
            }
            if (binding.resistShred.isChecked) {
                resValue *= 0.5
            }
            val postResistDmg = dmgValue / (1 + (resValue / 100))
            val stringResult = "$postResistDmg DMG"
            binding.dmgResult.text = stringResult
        }
    }
}