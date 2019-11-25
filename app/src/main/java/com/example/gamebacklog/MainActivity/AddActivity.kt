package com.example.gamebacklog.MainActivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gamebacklog.R
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_add.view.*

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
        val dayRange = 1..31
        val monthRange = 1..12
        val yearRange = 1900..2025

        var title = etTitle.title.text.toString()
        var platform = etPlatform.platform.text.toString()
        var day = etDay.day.text.toString()
        var month = etMonth.month.text.toString()
        var year = etYear.year.text.toString()

        // Check whether the input isn't empty.
        if (title.isNotBlank() && platform.isNotBlank() && day.isNotBlank() && month.isNotBlank() && year.isNotBlank()) {

            // Check whether the dates are in certain range and are valid.
            if (day.toInt() in dayRange && month.toInt() in monthRange && year.toInt() in yearRange) {
                // Fix error with the array length.
                val game =
                    Game(
                        title,
                        platform,
                        day.toInt(),
                        MONTHS[month.toInt() - 1],
                        year.toInt()
                    )

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_GAME, game)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } else {
                Toast.makeText(this,"Please fill in a valid date.", Toast.LENGTH_LONG).show()
            }

        } else if (!title.isNotBlank()){
            Toast.makeText(this,"Please fill in a title.", Toast.LENGTH_LONG).show()
        } else if (!platform.isNotBlank()){
            Toast.makeText(this,"Please fill in a platform.", Toast.LENGTH_LONG).show()
        } else if (!day.isNotBlank() || !month.isNotBlank() || !year.isNotBlank()){
            Toast.makeText(this,"Please fill in a date.", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this,"Multiple fields are empty. Please fill them in.", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        const val EXTRA_GAME = "EXTRA_GAME"
    }
}