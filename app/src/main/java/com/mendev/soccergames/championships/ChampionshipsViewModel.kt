package com.mendev.soccergames.championships

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mendev.soccergames.championships.model.Championship
import com.mendev.soccergames.data.repository.SoccerGamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ChampionshipsViewModel @Inject constructor(private val repository: SoccerGamesRepository) : ViewModel() {

    val championshipsLiveData = MutableLiveData<List<Championship>>()

    fun getChampionships() = viewModelScope.launch {
        val championships =
            withContext(Dispatchers.Default) {
                repository.getChampionships()
            }
        championshipsLiveData.value = championships
    }
}