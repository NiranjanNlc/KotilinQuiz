package com.example.quiz.addition

import android.content.Context
import com.example.quiz.model.Quiz
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

class FirebaseConnect
{
    val database = FirebaseDatabase.getInstance("https://wrapfirebase-default-rtdb.firebaseio.com/");
    val myRef = database.getReference("message");

    fun insertQuizQuestion(quiz: Quiz)
    {
        val ref = myRef.child("quiz")
        ref.setValue(quiz)
    }

    private fun uploadQuiz( context: Context) {
        var questionSet =  parseQuestions(context.assets.open("QuestionBank.json"))
        //dbHelper.saveQuestionSet(questionSet)
    }

    fun getQuizQuestion(context: Context): List<Quiz>
    {
     val question=parseQuestions(context.assets.open("QuestionBank.json"))
        var gson = Gson()
        val weatherList: List<Quiz> = gson.fromJson(question,Array<Quiz>::class.java).toList()

        return weatherList;
    }
    public fun parseQuestions(inputStream: InputStream) : String? {
        var arr = arrayListOf<String>()
        var json:String? = null
        try {
            json = inputStream.bufferedReader().use { it.readText() }
            return json
        } catch (exception: IOException) {
            exception.printStackTrace()
        }
        return json
    }

}