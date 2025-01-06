package com.example.exemple

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button3)

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val dice2 = Dice(6)
        var diceRoll = dice.roll()
        var diceRoll2 = dice2.roll()
        val resultTextView1: TextView = findViewById(R.id.de)
        val resultTextView2: TextView = findViewById(R.id.de2)
        resultTextView1.text = diceRoll.toString()
        resultTextView2.text = diceRoll2.toString()

        if (diceRoll == diceRoll2) {
            val winTextView: TextView = findViewById(R.id.win)
            winTextView.text = "ET CEST GAGNÉ!!!!!!!!!!!!!!!!!"
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}