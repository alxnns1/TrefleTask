package com.alxnns1.trefle.service

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlantsRepositoryTest {

    @Test
    fun `getPlants calls service`() {
        val trefleService: TrefleService = mockk {
            coEvery { getPlants() } returns mockk()
        }
        val subject = PlantsRepository(trefleService)

        runBlocking { subject.getPlants() }

        coVerify { trefleService.getPlants() }
    }
}