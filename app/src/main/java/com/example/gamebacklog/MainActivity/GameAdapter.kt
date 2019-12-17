package com.example.gamebacklog.MainActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebacklog.R
import kotlinx.android.synthetic.main.item_game.view.*

/*
 * An ArrayList of Game objects is added to the class constructor
 * so the RecyclerView knows which Game objects it needs to display.
 */
class GameAdapter (private val games: List<Game>) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    /*
        *  For the context variable the lateinit declaration has been used to let Kotlin
        *  know that this variable will be initialized later (in the onCreateViewHolder method).
        */
    lateinit var context: Context

    /*
     * In onCreateViewHolder a ViewHolder object is created which inflates the layout file we created (item_portal.xml).
     * We will be needing Context later on so a variable context is set.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_game, parent, false)
        )
    }

    // Size of Games.
    override fun getItemCount(): Int {
        return games.size
    }

    // Bind method to bind the data to the ViewHolder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }

    /*
     * The ViewHolders bind method uses kotlin synthetics to get the
     * references from the layout file for the ImageView and TextView.
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) {
            itemView.etTitle.text = game.title
            itemView.etPlatform.text = game.platform
            itemView.releaseDay.text = "Release: " + game.day.toString() + " "
            itemView.releaseMonth.text = game.month + " "
            itemView.releaseYear.text = game.year.toString()
        }
    }
}
