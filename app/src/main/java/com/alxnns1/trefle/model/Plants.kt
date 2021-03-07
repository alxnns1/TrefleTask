package com.alxnns1.trefle.model

data class Plants(
    val data: List<PlantsData>,
    val links: PlantsLinks,
    val meta: PlantsMeta
)

data class PlantsData(
    val author: String,
    val bibliography: String,
    val common_name: String?,
    val family: String,
    val family_common_name: String?,
    val genus: String,
    val genus_id: Int,
    val id: Int,
    val links: DataLinks,
    val plant_id: Int,
    val rank: String,
    val scientific_name: String,
    val slug: String,
    val status: String,
    val synonyms: List<String>,
    val year: Int,
)

data class DataLinks(
    val genus: String,
    val plant: String,
    val self: String
)

data class PlantsLinks(
    val first: String,
    val last: String,
    val next: String,
    val self: String
)

data class PlantsMeta(
    val total: Int
)