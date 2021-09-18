package com.example.quiz.ui.addquestion

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.quiz.R
import com.example.quiz.databinding.FragmentCountDownBinding
import com.mikhaellopez.circularprogressbar.CircularProgressBar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class CountDownFragment : Fragment() {

   private lateinit var binding: FragmentCountDownBinding;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCountDownBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_count_down, container, false)
    }

    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to [Activity.onStart] of the containing
     * Activity's lifecycle.
     */
    override fun onStart()
    {
        super.onStart()

    }

    /**
     * Called when the fragment is visible to the user and actively running.
     * This is generally
     * tied to [Activity.onResume] of the containing
     * Activity's lifecycle.
     */
    override fun onResume() {
        super.onResume()
        startTimer()
    }

    private fun startTimer() {
       val countDownTimer = object : CountDownTimer(0, 1000) {
            //            end of timer
            override fun onFinish()
            {

                }

            override fun onTick(millisUntilFinished: Long) {

            }

        }.start()

        }

}