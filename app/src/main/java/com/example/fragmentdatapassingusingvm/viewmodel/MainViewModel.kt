package com.example.fragmentdatapassingusingvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var _text = MutableLiveData("Sample Data")
    val text: LiveData<String> = _text

    fun saveCountry(data: String){
        _text.value = data
    }



}