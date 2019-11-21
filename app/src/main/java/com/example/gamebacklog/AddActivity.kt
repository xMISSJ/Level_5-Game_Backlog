package com.example.gamebacklog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_add.view.*
import java.lang.Integer.parseInt

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        add_button.setOnClickListener {
            onAddClick()
        }
        initViews()
    }

    private fun initViews() {
        supportActionBar?.title = "Add Activity"
    }

    private fun onAddClick() {
        val MONTHS = arrayListOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")

        var title = etTitle.title.text.toString()
        var platform = etPlatform.platform.text.toString()
        var day = etDay.day.text.toString()
        var month = etMonth.month.text.toString()
        var year = etYear.year.text.toString()

        // Check whether the input isn't empty.
        if (title.isNotBlank() && platform.isNotBlank() && day.isNotBlank() && month.isNotBlank() && year.isNotBlank()) {

            // Fix error with the array length.
            val game = Game(title, platform, day.toInt(), MONTHS[month.toInt()-1], year.toInt())

            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_GAME, game)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The game cannot be empty, please fill in the empty fields!", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        const val EXTRA_GAME = "EXTRA_GAME"
    }
}