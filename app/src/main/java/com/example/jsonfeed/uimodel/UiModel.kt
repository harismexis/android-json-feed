package com.example.jsonfeed.uimodel

data class UiModel(
    var id: String,
    var name: String?,
    var imageUrl: String?,
    var imageUrlHiRes: String?,
    var supertype: String?,
    var subtype: String?,
    var evolvesFrom: String?
)