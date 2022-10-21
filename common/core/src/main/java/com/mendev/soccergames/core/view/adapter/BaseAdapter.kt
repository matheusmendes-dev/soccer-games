package com.mendev.soccergames.core.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter<T: BaseViewHolder<U>, U>(
    private val viewHolderLaunch: (ViewGroup) -> T
) : RecyclerView.Adapter<T>() {

    var items: MutableList<U> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        return viewHolderLaunch(parent)
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

abstract class BaseViewHolder<U>(
    @LayoutRes layout: Int, viewGroup: ViewGroup
) : RecyclerView.ViewHolder(LayoutInflater.from(viewGroup.context).inflate(layout, viewGroup, false)) {

    abstract fun bind(item: U)

}