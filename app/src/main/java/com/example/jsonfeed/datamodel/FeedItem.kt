package com.example.jsonfeed.datamodel

data class FeedItem(
    var id: String?,
    var name: String?,
    var imageUrl: String?,
    var imageUrlHiRes: String?,
    var supertype: String?,
    var subtype: String?,
    var evolvesFrom: String?
)