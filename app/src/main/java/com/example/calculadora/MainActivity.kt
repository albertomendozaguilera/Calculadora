package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var resu: String = ""


    fun sumar (v: View){
        resu = pantalla.text.toString()
        pantalla3.text = "+"
        pantalla2.text = ""
    }

    fun restar (v: View){
        resu = pantalla.text.toString()
        pantalla3.text = "-"
        pantalla2.text = ""
    }

    fun multiplicar (v: View){
        resu = pantalla.text.toString()
        pantalla3.text = "X"
        pantalla2.text = ""
    }

    fun dividir (v: View){
        resu = pantalla.text.toString()
        pantalla3.text = "/"
        pantalla2.text = ""
    }

    fun resultado (v: View) {
        resu = pantalla.text.toString()
        pantalla2.text = "0"
        pantalla3.text = ""
    }

    fun borrar (v: View) {
        pantalla2.text = pantalla2.text.toString().substring(0, pantalla2.text.length-1)
        operacion(pantalla3.text.toString())
    }

    fun limpiar (v: View) {
        pantalla.text = ""
        pantalla2.text = "0"
        pantalla3.text = ""
    }



    fun operacion (operacion: String) {
        try {
            if (!pantalla3.text.isEmpty()) {
                when (operacion) {
                    "+" -> pantalla.text =
                        (resu.toDouble() + pantalla2.text.toString().toDouble()).toString()
                    "-" -> pantalla.text =
                        (resu.toDouble() - pantalla2.text.toString().toDouble()).toString()
                    "X" -> pantalla.text =
                        (resu.toDouble() * pantalla2.text.toString().toDouble()).toString()
                    "/" -> pantalla.text =
                        (resu.toDouble() / pantalla2.text.toString().toDouble()).toString()
                }
            }
        }catch (e: ArithmeticException) {
            Toast.makeText(this,"Error aritmetico",Toast.LENGTH_LONG).show()
        }catch (e: Exception) {
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }
    }

    fun numero (v: View) {
        var b = findViewById<Button>(v.id)
        if (!pantalla2.text.toString().equals("0")) {
            pantalla2.text = pantalla2.text.toString() + b.text.toString()
            if  (!pantalla3.text.isEmpty()) {
                operacion(pantalla3.text.toString())
            }else{
                pantalla.text = pantalla2.text.toString()
            }
        }else{
            pantalla2.text = b.text.toString()
            pantalla.text = pantalla2.text.toString()
        }
    }
}
