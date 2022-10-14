package com.mendev.soccergames.championships

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mendev.soccergames.R
import com.mendev.soccergames.championships.adapters.ChampionshipsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChampionshipsFragment : Fragment(R.layout.fragment_championships) {

    private val viewModel: ChampionshipsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        viewModel.championshipsLiveData.observe(viewLifecycleOwner) { championships ->
            with(recyclerView) {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                adapter = ChampionshipsAdapter(championships)
            }
        }

        viewModel.getChampionships()
    }

}