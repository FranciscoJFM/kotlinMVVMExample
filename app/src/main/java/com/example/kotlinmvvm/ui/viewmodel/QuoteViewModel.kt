package com.example.kotlinmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinmvvm.data.model.QuoteModel
import com.example.kotlinmvvm.data.model.QuoteProvider
import com.example.kotlinmvvm.domain.GetQuotesUseCase
import com.example.kotlinmvvm.domain.GetRamdomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private  val getQuotesUseCase:GetQuotesUseCase,
    private val getRamdomQuoteUseCase:GetRamdomQuoteUseCase
)  : ViewModel(){

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
    viewModelScope.launch {
        isLoading.postValue(true)
        val result:List<QuoteModel>? = getQuotesUseCase()
        if (!result.isNullOrEmpty()){
            quoteModel.postValue(result[0])
            isLoading.postValue(false)

        }
    }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote: QuoteModel ? = getRamdomQuoteUseCase()
        if (quote!= null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)


    }


}