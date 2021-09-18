package com.example.quiz.ui.addquestion

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.quiz.R
import com.example.quiz.databinding.FragmentCountDownBinding 

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class CountDownFragment : Fragment() {

   private lateinit var binding: FragmentCountDownBinding;
    private lateinit var mProgress:ProgressBar
    private lateinit var tv:TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCountDownBinding.inflate(layoutInflater)
        mProgress = binding.circularProgressbar
        tv=binding.tv
        val  res = getResources();
        val  drawable = res.getDrawable(R.drawable.circular); 
        mProgress.apply {
            setProgress(0);   // Main Progress
            setSecondaryProgress(100); // Secondary Progress
            setMax(100); // Maximum Progress
            setProgressDrawable(drawable);
        }
//        ObjectAnimator.ofInt(mProgress, "progress", 0, 100)
//            .apply {
//               setDuration(1000)
//               setInterpolator(DecelerateInterpolator());
//               start();
//            }

            return inflater.inflate(R.layout.fragment_count_down, container, false)
        }

    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to [Activity.onStart] of the containing
     * Activity's lifecycle.
     */
    override fun onStart() {
        super.onStart()
        requireActivity().runOnUiThread {
            val countDownTimer = object : CountDownTimer(20000, 1000) {
                //            end of timer
                override fun onFinish()
                {

                }

                override fun onTick(millisUntilFinished: Long)
                {
                    Log.d(" tickeld ",millisUntilFinished.toString())
                    mProgress.max=100
                    mProgress.progress= ((millisUntilFinished/1000).toInt());
                    tv.text = millisUntilFinished.toString() + "%";
                }

            }
            countDownTimer.start()
        }
    }
}