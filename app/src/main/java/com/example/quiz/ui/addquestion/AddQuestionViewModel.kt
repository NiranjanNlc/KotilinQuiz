package com.example.quiz.ui.addquestion

import android.content.Context
import android.view.View
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quiz.model.Quiz
import com.example.quiz.factoryRepo.Repo
import kotlin.system.exitProcess


class AddQuestionViewModel(private val repository: Repo) : ViewModel(),Observable
{
    private  val _qs = MutableLiveData<List<Quiz>>()
    private  val _question = MutableLiveData<Quiz>()
    private var count: Int;
    val qs : LiveData<List<Quiz>>
        get()= _qs

    val question :LiveData<Quiz>
        get() = _question

    init {
         count=0;
    }
    fun getQuizQuestion(context: Context)
    {
        println("this data before repo "+ _qs.value.toString())
        _qs.value =repository.getQuestionArray(context)
        _question.value= _qs.value!![count]
        println("this data after repo "+ _qs.value.toString())
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?)
    {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?)
    {

    }

    //onclick method
    fun nextQuestion()
    {
        println("Make sure this is clicked")
        count++
        if(count >=10)
            return ;
        println("$_question.value = $_qs.value!![count]")
        _question.value= _qs.value!![count]

    }

}
