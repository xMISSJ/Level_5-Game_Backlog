package com.example.gamebacklog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        add_button.setOnClickListener{
            onAddClick()
        }
    }

    private fun onAddClick(){
        Toast.makeText(this, "Button pressed", Toast.LENGTH_LONG).show()
    }
}