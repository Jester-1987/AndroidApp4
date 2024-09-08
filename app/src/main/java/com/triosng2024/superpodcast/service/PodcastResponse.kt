package com.triosng2024.superpodcast.service

data class PodcastResponse(
    val resultCount: Int,
    val results: List<ItunesPodcast>){

    data class ItunesPodcast(
        val collectionCensoredName: String,
        val feedUrl: String,
        val artworkURL30: String,
        val releaseDate: String
    )

}
