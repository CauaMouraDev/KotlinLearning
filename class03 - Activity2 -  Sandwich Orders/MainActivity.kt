package com.example.myapplication

import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity
import com.example.myapplication.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextClientName = findViewById<EditText>(R.id.editTextClientName)
        val radioGroupSnackSize = findViewById<RadioGroup>(R.id.radioGroupSnackSize)
        val checkBoxCheese = findViewById<CheckBox>(R.id.checkBoxCheese)
        val checkBoxBacon = findViewById<CheckBox>(R.id.checkBoxBacon)
        val checkBoxEgg = findViewById<CheckBox>(R.id.checkBoxEgg)
        val spinnerDrink = findViewById<Spinner>(R.id.spinnerDrink)
        val switchDelivery = findViewById<Switch>(R.id.switchDelivery)
        val buttonSubmitOrder = findViewById<Button>(R.id.buttonSubmitOrder)
        val textViewOrderSummary = findViewById<TextView>(R.id.textViewOrderSummary)

        // Setup Spinner for drinks
        val drinks = arrayOf("Água", "Refrigerante", "Suco")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, drinks)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDrink.adapter = adapter

        buttonSubmitOrder.setOnClickListener {
            val clientName = editTextClientName.text.toString()

            val selectedSnackSizeId = radioGroupSnackSize.checkedRadioButtonId
            val snackSize = findViewById<RadioButton>(selectedSnackSizeId)?.text.toString()

            val extras = mutableListOf<String>()
            if (checkBoxCheese.isChecked) extras.add("Queijo")
            if (checkBoxBacon.isChecked) extras.add("Bacon")
            if (checkBoxEgg.isChecked) extras.add("Ovo")

            val drink = spinnerDrink.selectedItem.toString()
            val delivery = switchDelivery.isChecked

            // Calculate price (basic example)
            var price = 0.0
            when (snackSize) {
                "P" -> price += 10.0
                "M" -> price += 15.0
                "G" -> price += 20.0
            }
            if (checkBoxCheese.isChecked) price += 2.0
            if (checkBoxBacon.isChecked) price += 3.0
            if (checkBoxEgg.isChecked) price += 2.5
            when (drink) {
                "Água" -> price += 3.0
                "Refrigerante" -> price += 5.0
                "Suco" -> price += 6.0
            }
            if (delivery) price += 5.0 // Delivery fee

            val summary = "Nome: $clientName\n"
                .plus("Tamanho: $snackSize\n")
                .plus("Extras: ${extras.joinToString()}\n")
                .plus("Bebida: $drink\n")
                .plus(if (delivery) "Delivery: Sim\n" else "Delivery: Não\n")
                .plus("Preço Total: R$${"%.2f".format(price)}")

            textViewOrderSummary.text = summary
        }
    }
}
