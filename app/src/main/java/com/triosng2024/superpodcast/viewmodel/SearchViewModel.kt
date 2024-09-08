package com.triosng2024.superpodcast.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.triosng2024.superpodcast.repostitory.ItunesRepo
import com.triosng2024.superpodcast.service.PodcastResponse

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    var itunesRepo: ItunesRepo? = null

    data class PodcastSummaryViewData(
        var name: String? = "",
        var lastUpdated: String? = "",
        var imageUrl: String? = "",
        var feedUrl: String? = "")

    private fun itunesSearchPodcastToPodcastSummaryView(
        itunesPodcast: PodcastResponse.ItunesPodcast):
            PodcastSummaryViewData {
        return PodcastSummaryViewData(
            itunesPodcast.collectionCensoredName,
            itunesPodcast.releaseDate,
            itunesPodcast.artworkURL30,
            itunesPodcast.feedUrl)
    }

    suspend fun searchPodcasts(term: String): List<PodcastSummaryViewData> {
        val results = itunesRepo?.searchByTerm(term)

        if (results !=null && results.isSuccessful) {
            val podcasts = results.body()?.results
            if (!podcasts.isNullOrEmpty()) {
                return podcasts.map { podcast ->
                    itunesSearchPodcastToPodcastSummaryView(podcast)
                }
            }
        }
    return emptyList()
    }

}