package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    StudentRegistrationXMLForm(modifier = Modifier.padding(it))
                }
            }
        }
    }
}

@Composable
fun StudentRegistrationXMLForm(modifier: Modifier = Modifier) {
    AndroidView(
        factory = {
            val view = android.view.LayoutInflater.from(it).inflate(R.layout.student_registration_form, null, false)
            val editTextStudentName = view.findViewById<EditText>(R.id.editTextStudentName)
            val spinnerSeries = view.findViewById<Spinner>(R.id.spinnerSeries)
            val checkBoxTerms = view.findViewById<CheckBox>(R.id.checkBoxTerms)
            val buttonSubmit = view.findViewById<Button>(R.id.buttonSubmit)

            // Setup Spinner
            val seriesAdapter = ArrayAdapter.createFromResource(
                it,
                R.array.series_array, // You'll need to create this array in strings.xml or a new arrays.xml
                android.R.layout.simple_spinner_item
            )
            seriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerSeries.adapter = seriesAdapter

            // Setup Button Click Listener
            buttonSubmit.setOnClickListener { contextView ->
                val studentName = editTextStudentName.text.toString()
                val termsAccepted = checkBoxTerms.isChecked

                if (studentName.isBlank()) {
                    Toast.makeText(it, "Por favor, insira o nome do aluno.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (!termsAccepted) {
                    Toast.makeText(it, "Por favor, aceite os termos.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Validation successful
                Toast.makeText(it, "Aluno cadastrado com sucesso! Nome: $studentName", Toast.LENGTH_LONG).show()
                // Here you would typically send the data or navigate
            }
            view
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun StudentRegistrationXMLFormPreview() {
    MyApplicationTheme {
        StudentRegistrationXMLForm()
    }
}

// You should also keep the Greeting composable if you plan to use it elsewhere, or remove it.
// @Composable
// fun Greeting(name: String, modifier: Modifier = Modifier) {
// Text(
// text = "Hello $name!",
// modifier = modifier
// )
// }
//
// @Preview(showBackground = true)
// @Composable
// fun GreetingPreview() {
// MyApplicationTheme {
// Greeting("Android")
// }
// }
