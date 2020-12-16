package com.example.activities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
    }
    private fun init(){
        val name = intent.extras?.getString("name", "Not found")
        val lastName = intent.extras?.getString("last_name", "Not found")

        nameView.text = name
        lastNameView.text = lastName

        returnButton.setOnClickListener {
            returnFirstActivity()
        }
    }
    private fun returnFirstActivity() {
        val age = ageInput.text.toString()
        if (age.isNotEmpty()) {
            val intent = intent
            intent.putExtra("age", age)
            setResult(RESULT_OK, intent)
            finish()
        }else{
            Toast.makeText(this,"Please fill age field", Toast.LENGTH_SHORT).show()
        }
    }
}