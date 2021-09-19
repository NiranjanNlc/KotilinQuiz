package com.example.quiz.ui.addquestion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quiz.databinding.CongratsBinding

class Congrats: Fragment()
{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = CongratsBinding.inflate(layoutInflater)
        return binding.root
    }
}