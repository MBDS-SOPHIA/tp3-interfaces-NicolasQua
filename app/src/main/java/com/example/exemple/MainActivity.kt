package com.example.exemple

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
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
        rollButton.isEnabled = false


        rollButton.setOnClickListener {
            rollDice()
        }

        val input: EditText = findViewById(R.id.input)


        input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                rollButton.isEnabled = isInputValid(s)
            }
            override fun afterTextChanged(s: Editable?) {}
        })


    }

    private fun isInputValid(input: CharSequence?): Boolean {
        if (input.isNullOrEmpty()) return false
        val number = input.toString().toIntOrNull()
        return number != null && number in 2..12
    }

    private fun rollDice() {
        val dice = Dice(6)
        val dice2 = Dice(6)
        var diceRoll = dice.roll()
        var diceRoll2 = dice2.roll()
        val sum = diceRoll + diceRoll2
        val resultTextView1: TextView = findViewById(R.id.de)
        val resultTextView2: TextView = findViewById(R.id.de2)
        resultTextView1.text = diceRoll.toString()
        resultTextView2.text = diceRoll2.toString()


        val input: EditText = findViewById(R.id.input)
        val userInput = input.text.toString().toIntOrNull() // Transforme l'input en entier

        val winTextView: TextView = findViewById(R.id.win)
        if (userInput != null && sum == userInput) {
            winTextView.text = "ET C'EST GAGNÉ !!!!!!!"
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}