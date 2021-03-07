package com.alxnns1.trefle.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import com.alxnns1.trefle.model.Plants
import com.alxnns1.trefle.service.PlantsRepository
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PlantsViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val lifecycleOwner: LifecycleOwner = mockk()
    private val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)

    @Before
    fun setup() {
        every { lifecycleOwner.lifecycle } returns lifecycleRegistry
    }

    @Test
    fun `getPlantsData calls repository`() {
        val expected: Plants = mockk()
        val plantsRepository: PlantsRepository = mockk {
            coEvery { getPlants() } returns expected
        }
        val subject = PlantsViewModel(plantsRepository)

        subject.plantsData.observe(lifecycleOwner, Observer {
            assertEquals(expected, it)
        })
    }
}