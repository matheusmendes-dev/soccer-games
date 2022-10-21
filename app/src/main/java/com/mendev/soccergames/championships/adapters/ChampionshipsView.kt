package com.mendev.soccergames.championships.adapters

import android.view.ViewGroup
import android.widget.TextView
import com.mendev.soccergames.championships.model.Championship
import com.mendev.soccergames.core.view.adapter.BaseViewHolder

class ChampionshipsView(viewGroup: ViewGroup)
    : BaseViewHolder<Championship>(android.R.layout.simple_list_item_1, viewGroup) {

    override fun bind(item: Championship) {
        (itemView as TextView).text = item.name
    }
}