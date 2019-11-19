package com.example.gamebacklog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebacklog.AddActivity.Companion.EXTRA_GAME

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

const val ADD_GAME_REQUEST_CODE = 100

class MainActivity : AppCompatActivity() {

    private val games = arrayListOf<Game>()
    private val gameAdapter = GameAdapter(games)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        main_button.setOnClickListener {
            startAddActivity()
        }

        initViews()
    }

    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        rvGames.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        rvGames.adapter = gameAdapter
    }

    private fun startAddActivity() {
        val intent = Intent(this, AddActivity::class.java)
        startActivityForResult(intent, ADD_GAME_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // Make sure request is successful.
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                ADD_GAME_REQUEST_CODE -> {
                    val game = data!!.getParcelableExtra<Game>(EXTRA_GAME)
                    games.add(game)
                    gameAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
