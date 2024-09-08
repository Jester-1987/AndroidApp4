package com.triosng2024.superpodcast.repostitory

import com.triosng2024.superpodcast.service.ItunesService

class ItunesRepo(private val itunesService: ItunesService) {
    suspend fun searchByTerm(term:String) =
        itunesService.searchPodcastByTerm(term)
}