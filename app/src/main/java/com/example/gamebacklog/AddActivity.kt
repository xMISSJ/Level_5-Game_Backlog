package com.example.gamebacklog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        // Check whether the input isn't empty.
        if (!etTitle.title.text.isNullOrBlank() && !etPlatform.platform.text.isNullOrBlank() &&
            !etDay.day.text.isNullOrEmpty() && !etMonth.month.text.isNullOrBlank() && !etYear.year.text.isNullOrBlank()
        ) {
            val game = Game(
                etTitle.title.text.toString(),
                etPlatform.platform.text.toString(),
                etDay.day.text.toString().toInt(),
                etMonth.month.text.toString().toInt(),
                etYear.year.text.toString().toInt()
            )

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