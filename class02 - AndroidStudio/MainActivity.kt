package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainacitivity)

        val etNumero: EditText = findViewById(R.id.etNumero)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val txtResultado: TextView = findViewById(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            val numeroStr = etNumero.text.toString()
            if (numeroStr.isEmpty()) {
                Toast.makeText(this, "Por favor, insira um número", Toast.LENGTH_SHORT).show()
            } else {
                val numero = numeroStr.toInt()
                val dobro = numero * 2
                txtResultado.text = getString(R.string.dobro_format, dobro)
            }
        }
    }
}
