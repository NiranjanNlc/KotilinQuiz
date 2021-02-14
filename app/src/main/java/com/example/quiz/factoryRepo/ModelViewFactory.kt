package com.example.quiz.factoryRepo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quiz.ui.addquestion.AddQuestionViewModel


class ModelViewFactory(private val repository: Repo): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(AddQuestionViewModel::class.java)){
                return AddQuestionViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown View Model class")
        }

    }