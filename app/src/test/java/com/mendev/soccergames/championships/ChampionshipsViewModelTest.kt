package com.mendev.soccergames.championships

import com.mendev.soccergames.championships.model.Championship
import com.mendev.soccergames.data.repository.SoccerGamesRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

internal class ChampionshipsViewModelTest {

    private val dispatcher = TestCoroutineDispatcher()

    @MockK
    private lateinit var repository: SoccerGamesRepository

    private lateinit var viewModel : ChampionshipsViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this)
        viewModel = ChampionshipsViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
    }

    @Test
    fun getChampionships() = runTest {

        val championships = listOf(
            Championship(
                1, "Campeonato Brasileiro", "Brasileirão", "CBR",
                "andamento"
            )
        )

        coEvery { repository.getChampionships() } returns championships

        viewModel.getChampionships()

        coVerify {
            repository.getChampionships()
        }
    }
}