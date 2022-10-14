package com.mendev.soccergames.championships

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mendev.soccergames.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChampionshipsFragment : Fragment(R.layout.fragment_championships) {

    private val viewModel: ChampionshipsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.championshipsLiveData.observe(viewLifecycleOwner) { championships ->

        }

        viewModel.getChampionships()
    }

}