package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        unoBtn.setOnClickListener { numeroPresionado("1") }
        dosBtn.setOnClickListener { numeroPresionado("2") }
        tresBtn.setOnClickListener { numeroPresionado("3") }
        cuatroBtn.setOnClickListener { numeroPresionado("4") }
        cincoBtn.setOnClickListener { numeroPresionado("5") }
        seisBtn.setOnClickListener { numeroPresionado("6") }
        sieteBtn.setOnClickListener { numeroPresionado("7") }
        ochoBtn.setOnClickListener { numeroPresionado("8") }
        nueveBtn.setOnClickListener { numeroPresionado("9") }
        ceroBtn.setOnClickListener { numeroPresionado("10") }

        sumaBtn.setOnClickListener { operacionPresionada(SUMA) }
        restaBtn.setOnClickListener { operacionPresionada(RESTA) }
        multiplicacionBtn.setOnClickListener { operacionPresionada(MULTIPLICACION) }
        divisionBtn.setOnClickListener { operacionPresionada(DIVISION) }

        clearBtn.setOnClickListener {
          num1 = 0.0
          num2 = 0.0
          resultTextView.text = "0"
          operacion = SIN_OPERACION
        }

        igualBtn.setOnClickListener {
            var resultado = when(operacion){
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1 / num2
                else -> 0
            }
            resultTextView.text = resultado.toString()
        }
    }

    private fun numeroPresionado(digito: String){
        if (resultTextView.text == "0" && digito != "."){
            resultTextView.text = "$digito"
        }else{
            resultTextView.text = "${resultTextView.text}$digito"
        }

        if (operacion == SIN_OPERACION){
            num1 = resultTextView.text.toString().toDouble()
        }else{
            num2 = resultTextView.text.toString().toDouble()
        }
    }

    private fun operacionPresionada(operacion: Int){
        this.operacion = operacion
        num1 = resultTextView.text.toString().toDouble()

        resultTextView.text = "0"
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val SIN_OPERACION = 0
    }



}