package com.example.quiz.ui.addquestion

import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountDownViewModal : ViewModel()
{
   val progress = MutableLiveData(0)

    fun  changeProgress()
    {
        progress.value= progress.value?.plus(10)
    }


}