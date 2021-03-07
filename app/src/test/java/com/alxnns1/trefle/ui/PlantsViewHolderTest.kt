package com.alxnns1.trefle.ui

import android.view.View
import android.widget.TextView
import com.alxnns1.trefle.model.PlantsData
import io.mockk.*
import kotlinx.android.synthetic.main.item_plant_list.view.*
import org.junit.Test

class PlantsViewHolderTest {

    @Test
    fun `bind sets text`() {
        val plantFamilyView: TextView = mockk {
            every { text = "family" } just Runs
        }
        val plantSpeciesView: TextView = mockk {
            every { text = "name" } just Runs
        }
        val itemView: View = mockk {
            every { plant_family } returns plantFamilyView
            every { plant_species } returns plantSpeciesView
            every { setOnClickListener(any()) } just Runs
        }
        val plantsData: PlantsData = mockk {
            every { family_common_name } returns "family"
            every { scientific_name } returns "name"
        }
        val subject = PlantsRecyclerViewAdapter.PlantsViewHolder(itemView, mockk())

        subject.bind(plantsData)

        verify {
            plantFamilyView.text = "family"
            plantSpeciesView.text = "name"
        }
    }
}