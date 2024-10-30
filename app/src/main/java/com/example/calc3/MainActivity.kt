package com.example.calc3

import android.annotation.SuppressLint
import android.graphics.Color
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calc3.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonZero.setOnClickListener {
            addToInput("0")
        }

        binding.buttonOne.setOnClickListener {
            addToInput("1")
        }

        binding.buttonTwo.setOnClickListener {
            addToInput("2")
        }

        binding.buttonThree.setOnClickListener {
            addToInput("3")
        }

        binding.buttonFour.setOnClickListener {
            addToInput("4")
        }

        binding.buttonFive.setOnClickListener {
            addToInput("5")
        }

        binding.buttonSix.setOnClickListener {
            addToInput("6")
        }

        binding.buttonSeven.setOnClickListener {
            addToInput("7")
        }

        binding.buttonEight.setOnClickListener {
            addToInput("8")
        }

        binding.buttonNine.setOnClickListener {
            addToInput("9")
        }

        binding.buttonDivision.setOnClickListener {
            addToInput("/")
        }

        binding.buttonMultiplication.setOnClickListener {
        addToInput("*")
        }

        binding.buttonSubtraction.setOnClickListener {
            addToInput("-")
        }

        binding.buttonAddition.setOnClickListener {
            addToInput("+")
        }

        binding.buttonBracketOpen.setOnClickListener {
            addToInput("(")
        }

        binding.buttonBracketClosed.setOnClickListener{
            addToInput(")")
        }

        binding.buttonPoint.setOnClickListener { addToInput(".") }

        binding.buttonEquality.setOnClickListener {
            equal()
        }

        binding.buttonDelete.setOnClickListener {
            delete()
        }

        binding.buttonAc.setOnClickListener {
            ac()
        }
    }

    private fun ac() {
        binding.textInput.text = ""
        updateAnswer()
    }

    private fun delete() {
        binding.textInput.text = binding.textInput.text.toString().substring(0, binding.textInput.text.toString().length-1)
        updateAnswer()
    }

    private fun equal(): View.OnClickListener? {
        binding.textInput.text = binding.textAnswer.text.toString()
        return null
    }

    @SuppressLint("SetTextI18n")
    private fun addToInput(s: String): View.OnClickListener? {
        binding.textInput.append(s)
        updateAnswer()
        return null
    }

    private fun getInputExpression() : String {
        return binding.textInput.text.toString()
    }

    private fun updateAnswer() {
        try {
            val expression = getInputExpression()
            val result = ExpressionBuilder(expression).build().evaluate()
            binding.textAnswer.text = DecimalFormat("0.#####").format(result).toString()
        } catch (e: Exception) {
            binding.textAnswer.text = "";
        }
        println(binding.textInput.text)
        println(binding.textAnswer.text)
    }
}