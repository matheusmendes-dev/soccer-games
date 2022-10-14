package com.mendev.soccergames.championships.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mendev.soccergames.championships.model.Championship

class ChampionshipsAdapter(
    private val championships: List<Championship>
): RecyclerView.Adapter<ChampionshipsAdapter.ChampionshipViewHolder>() {

    class ChampionshipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(championship: Championship) {
            (itemView as TextView).text = championship.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionshipViewHolder {
        return ChampionshipViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ChampionshipViewHolder, position: Int) {
        holder.bind(championships[position])
    }

    override fun getItemCount() = championships.size

}