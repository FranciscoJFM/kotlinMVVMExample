package com.example.kotlinmvvm.domain

import com.example.kotlinmvvm.data.model.QuoteModel
import com.example.kotlinmvvm.data.model.QuoteRespository
import javax.inject.Inject

class GetQuotesUseCase  @Inject constructor(private val repository : QuoteRespository){


    suspend  operator fun invoke():List<QuoteModel>?= repository.getAllQuotes()


}