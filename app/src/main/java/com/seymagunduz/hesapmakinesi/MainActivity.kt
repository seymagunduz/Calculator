package com.seymagunduz.hesapmakinesi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.seymagunduz.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // View binding feature is used for input data.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //The codes are written to give functions to each button.

    fun plus (view : View){
        var number1 = binding.editText1.text.toString().toFloatOrNull()
        var number2 = binding.editText2.text.toString().toFloatOrNull()
        if ( number1 == null || number2 == null ){
            //In the xml file, the input data has been changed to "number decimal".Therefore, text cannot be entered
            // However, if the input data is "text", this toast message will be also seen and the operation cannot be performed.
           Toast.makeText(this@MainActivity, "Please enter invalid number", Toast.LENGTH_LONG).show() //
        } else{
            val result = number1!! + number2!!
            binding.textViewResult.text = "Result: ${result}"
        }
    }

    fun minus (view: View){
        var number1 = binding.editText1.text.toString().toFloatOrNull()
        var number2 = binding.editText2.text.toString().toFloatOrNull()
        if ( number1 == null || number2 == null ){
            Toast.makeText(this@MainActivity, "Please enter invalid number", Toast.LENGTH_LONG).show()
        } else{
            val result = number1!! - number2!!
            binding.textViewResult.text = "Result: ${result}"
        }
    }

    fun multiply (view : View){
        var number1 = binding.editText1.text.toString().toFloatOrNull()
        var number2 = binding.editText2.text.toString().toFloatOrNull()
        if ( number1 == null || number2 == null ){
            Toast.makeText(this@MainActivity, "Please enter invalid number", Toast.LENGTH_LONG).show()
        } else{
            val result = number1!! * number2!!
            binding.textViewResult.text = "Result: ${result}"
        }
    }

    fun division (view : View){
        var number1 = binding.editText1.text.toString().toFloatOrNull()
        var number2 = binding.editText2.text.toString().toFloatOrNull()
        if ( number1 == null || number2 == null ){
            Toast.makeText(this@MainActivity, "Please enter invalid number", Toast.LENGTH_LONG).show()
        } else{
            val result = number1!! / number2!!
            binding.textViewResult.text = "Result: ${result}"
        }
    }

    //A 'Delete All' button has been added for easier use while performing calculations involving operations.
    fun delete (view : View){
        binding.editText1.text.clear()
        binding.editText2.text.clear()
    }
}