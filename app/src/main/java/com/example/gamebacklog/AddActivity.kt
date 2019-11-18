package com.example.gamebacklog

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        add_button.setOnClickListener{
            onAddClick()
        }
    }

    private fun onAddClick(){
        Toast.makeText(this, "Button pressed", Toast.LENGTH_LONG).show()
    }
}