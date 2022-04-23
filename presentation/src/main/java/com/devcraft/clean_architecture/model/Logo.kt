package com.devcraft.clean_architecture.model

data class Logo(
    val href: String,
    val width: Int ,
    val height: Int,
    val alt: String,
    val rel: List<String>,
    val lastUpdated: String
)
