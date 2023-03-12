package com.example.programmercalculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var editTextBinary: EditText
    private lateinit var editTextOctal: EditText
    private lateinit var editTextDecimal: EditText
    private lateinit var editTextHexadecimal: EditText
    private lateinit var emptyData: Button
    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

        emptyData = findViewById(R.id.Clear)
        editTextBinary = findViewById(R.id.editTextBinary)
        editTextOctal = findViewById(R.id.editTextOctal)
        editTextDecimal = findViewById(R.id.editTextDecimal)
        editTextHexadecimal = findViewById(R.id.editTextHexadecimal)


        setListeners()

        emptyData.setOnClickListener {
            // your code cleardata when the user clicks on the button
            cleardata()
        }
    }

    private fun cleardata() {
        editTextBinary.text.clear()
        editTextOctal.text.clear()
        editTextDecimal.text.clear()
        editTextHexadecimal.text.clear()
    }
    private fun setListeners() {
        editTextDecimal.addTextChangedListener(decimalTextWatcher)
        editTextBinary.addTextChangedListener(binaryTextWatcher)
        editTextOctal.addTextChangedListener(octalTextWatcher)
        editTextHexadecimal.addTextChangedListener(hexTextWatcher)
    }


    // Text change listener for decimal input field
    private val decimalTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (editTextDecimal.hasFocus()&&editTextDecimal.text.isNotEmpty()) { // Parse decimal input value
                val decimalValue = s.toString().toLongOrNull() ?: return
                // Convert decimal to binary, octal, and hexadecimal
                    editTextBinary.setText(decimalValue.toString(2))
                    editTextOctal.setText(decimalValue.toString(8))
                    editTextHexadecimal.setText(decimalValue.toString(16).uppercase(Locale.getDefault()))
                }  else if (s!=null &&editTextDecimal.hasFocus()&&s.isBlank() )
                {
                    editTextOctal.setText("")
                    editTextHexadecimal.setText("")
                    editTextBinary.setText("")
                }
            }
        override fun afterTextChanged(s: Editable?) {}
            }





    // Text change listener for binary input field
    private val binaryTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (editTextBinary.hasFocus()&&editTextBinary.text.isNotEmpty()){
                // Parse binary input value
                val binaryValue = s.toString().toLongOrNull(2) ?: return
                // Convert binary to decimal, octal, and hexadecimal

                editTextDecimal.setText(binaryValue.toString())
                editTextOctal.setText(binaryValue.toString(8))
                editTextHexadecimal.setText(binaryValue.toString(16).uppercase(Locale.getDefault()))}
                else if (s!=null &&editTextBinary.hasFocus()&&s.isBlank() )
                {
                    editTextDecimal.setText("")
                    editTextOctal.setText("")
                    editTextHexadecimal.setText("")
                }
            }



        override fun afterTextChanged(s: Editable?) {}
    }



    // Text change listener for octal input field
    private val octalTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (editTextOctal.hasFocus()&&editTextOctal.text.isNotEmpty()) {   // Parse octal input value
                val octalValue = s.toString().toLongOrNull(8) ?: return

                    // Convert octal to decimal, binary, and hexadecimal
                    editTextDecimal.setText(octalValue.toString())
                    editTextBinary.setText(octalValue.toString(2))
                    editTextHexadecimal.setText(octalValue.toString(16).uppercase(Locale.getDefault()))
                }  else if (s!=null &&editTextOctal.hasFocus()&&s.isBlank() )
                {
                    editTextDecimal.setText("")
                    editTextHexadecimal.setText("")
                    editTextBinary.setText("")
                }
            }



        override fun afterTextChanged(s: Editable?) {}
    }



    // Text change listener for hexadecimal input field
    private val hexTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (editTextHexadecimal.hasFocus()&&editTextHexadecimal.text.isNotEmpty()) {  // Parse hexadecimal input value
                val hexValue = s.toString().toLongOrNull(16) ?: return
                // Convert hexadecimal to decimal, binary, and octal
                    editTextDecimal.setText(hexValue.toString())
                    editTextBinary.setText(hexValue.toString(2))
                    editTextOctal.setText(hexValue.toString(8))
                }    else if (s!=null &&editTextHexadecimal.hasFocus()&&s.isBlank() )
                {
                    editTextDecimal.setText("")
                    editTextOctal.setText("")
                    editTextBinary.setText("")
                }
            }

        override fun afterTextChanged(s: Editable?) {}
    }
}