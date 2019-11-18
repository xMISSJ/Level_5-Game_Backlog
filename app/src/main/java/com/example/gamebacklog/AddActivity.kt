package com.example.gamebacklog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_add.view.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        add_button.setOnClickListener{
            onAddClick()
        }
        initViews()
    }

    private fun initViews(){
        supportActionBar?.title = "Add Activity"
    }

    private fun onAddClick() {
        // Check whether the input isn't empty.
        if (!etTitle.title.text.isNullOrBlank() && !etPlatform.platform.text.isNullOrBlank() &&
            !etDay.day.text.isNullOrEmpty() && !etMonth.month.text.isNullOrBlank() && !etYear.year.text.isNullOrBlank()) {
/*            val game = Game(etTitle.title.text.toString(),
                etPlatform.platform.text.toString(),
                etDay.day.text.toString(),
                etMonth.month.text.toString(),
                etYear.year.text.toString())*/
        }
    }
}