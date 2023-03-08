package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.calculator.models.Calculator

class MainActivity : AppCompatActivity() {

    lateinit var edtNumber1: EditText
    lateinit var edtNumber2:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumber1 = findViewById(R.id.et_num1)
        edtNumber2 = findViewById(R.id.et_num2)

    }

    fun buttonClick(v: View){
        var ans = 0.0
        val calculator = Calculator(
            edtNumber1.text.toString().toDouble(),
            edtNumber2.text.toString().toDouble()
        )
        when(v.id){
            R.id.btn_plus -> ans = calculator.add()
            R.id.btn_minus -> ans = calculator.subtract()
            R.id.btn_multiply -> ans = calculator.multiply()
            R.id.btn_divide -> ans = calculator.divide()
        }
        println(ans)//this will print the output on the terminal

        val intent = Intent(this, activity_display::class.java)
        intent.putExtra("answer", ans)
        startActivity(intent)
        finish()

    }


}