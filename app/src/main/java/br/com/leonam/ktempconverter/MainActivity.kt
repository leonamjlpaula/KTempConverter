package br.com.leonam.ktempconverter

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var etTemp: EditText
    private lateinit var rbCelsius: RadioButton
    private lateinit var rbFahreinheit: RadioButton
    private lateinit var btConvert: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTemp = findViewById(R.id.et_temperature)
        rbCelsius = findViewById(R.id.rb_celsius)
        rbFahreinheit = findViewById(R.id.rb_fahreinheit)
        btConvert = findViewById(R.id.bt_convert)
        btConvert.setOnClickListener { convert() }
    }

    private fun convert() {

        try {
            var temp: Double = etTemp.text.toString().toDouble()

            temp = if (rbCelsius.isChecked) {
                (temp - 32) * 5 / 9
            } else {
                temp * 9 / 5 + 32
            }

            etTemp.setText(String.format(Locale.US, "%.2f", temp))
        } catch (e: Exception) {
            Log.e("Error", e.localizedMessage)
            Toast.makeText(
                applicationContext,
                getString(R.string.invalid_number_toast),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}