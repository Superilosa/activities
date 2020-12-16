package com.example.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_first.*

class MainActivity : AppCompatActivity() {
    private val ageRequestCode = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        init()
    }
    private fun init(){
        nextButton.setOnClickListener {
            openSecondActivity()
        }
    }
    private fun openSecondActivity(){
        val name = nameInput.text.toString()
        val lastName = lastNameInput.text.toString()
        if (name.isNotEmpty() && lastName.isNotEmpty()) {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("last_name", lastName)
            startActivityForResult(intent, ageRequestCode)
        }else{
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ageRequestCode && resultCode == RESULT_OK){
            val age = data?.extras?.getString("age", "Not found")
            ageView.text = age
            ageView.visibility = View.VISIBLE
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}