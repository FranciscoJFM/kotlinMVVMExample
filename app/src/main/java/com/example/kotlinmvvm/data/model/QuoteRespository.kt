package com.example.kotlinmvvm.data.model

import com.example.kotlinmvvm.data.model.network.QuoteService
import javax.inject.Inject

class QuoteRespository @Inject constructor (private val api:  QuoteService,private val quoteProvider: QuoteProvider) {

    suspend fun getAllQuotes(): List<QuoteModel> {
         val response : List<QuoteModel> = api.getQuotes()
        quoteProvider.quotes = response
    return response
    }

}