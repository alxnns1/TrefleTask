package com.alxnns1.trefle.plants

import com.alxnns1.trefle.model.PlantsData
import io.mockk.*
import org.junit.Assert.assertEquals
import org.junit.Test

class PlantsRecyclerViewAdapterTest {

    @Test
    fun `getItemCount returns data size`() {
        val subject = PlantsRecyclerViewAdapter()

        subject.data = listOf(mockk(), mockk(), mockk())

        val actual = subject.itemCount

        assertEquals(3, actual)
    }

    @Test
    fun `onBindViewHolder calls view holder`() {
        val plantsData: PlantsData = mockk()
        val holder: PlantsViewHolder = mockk {
            every { bind(plantsData) } just Runs
        }
        val subject = PlantsRecyclerViewAdapter()

        subject.data = listOf(plantsData)

        subject.onBindViewHolder(holder, 0)

        verify { holder.bind(plantsData) }
    }
}