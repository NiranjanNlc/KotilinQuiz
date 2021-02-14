package com.example.quiz.factoryRepo

import android.app.Application
import android.content.Context
import com.example.quiz.addition.FirebaseConnect
import com.example.quiz.model.Quiz

class Repo
{
  fun getQuestionArray(context: Context): List<Quiz> {
      val firebaseConnect = FirebaseConnect()
      return firebaseConnect.getQuizQuestion(context)
  }
}