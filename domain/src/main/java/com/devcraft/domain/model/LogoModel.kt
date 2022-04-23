package com.devcraft.domain.model

data class LogoModel(
    val href: String,
    val width: Int ,
    val height: Int,
    val alt: String,
    val rel: List<String>,
    val lastUpdated: String
)
