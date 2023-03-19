package com.example.kotlinmvvm.domain

import com.example.kotlinmvvm.data.model.QuoteModel
import com.example.kotlinmvvm.data.model.QuoteProvider
import com.example.kotlinmvvm.data.model.QuoteRespository
import javax.inject.Inject

class GetRamdomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {

    operator  fun invoke() :QuoteModel ?{
      val quotes = quoteProvider.quotes
        if (quotes.isNullOrEmpty()){

            val randomNumber =  (quotes.indices -1).random()

            return quotes[randomNumber]
        }
        return  null
    }
}