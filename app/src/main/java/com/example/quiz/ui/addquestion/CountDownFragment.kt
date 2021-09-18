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
        binding.circularProgressBar.onProgressChangeListener = { progress ->
            // Do something
            binding.circularProgressBar.apply {
            //    setProgressWithAnimation(progress, 500)
            }
            Toast.makeText(activity,"Finished "+progress.toString(),Toast.LENGTH_SHORT).show()
        }

        binding.circularProgressBar.onIndeterminateModeChangeListener = { isEnable ->
            // Do something
        }
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
        binding.circularProgressBar.apply {

                // Set Progress
                // progress = 65f
                // or with animation
                //setProgressWithAnimation(65f, 1000) // =1s

                // Set Progress Max
             //   progressMax = 100f

                // Set ProgressBar Color
                progressBarColor = Color.BLACK
                // or with gradient
                progressBarColorStart = Color.GRAY
                progressBarColorEnd = Color.RED
                progressBarColorDirection = CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set background ProgressBar Color
                backgroundProgressBarColor = Color.GRAY
                // or with gradient
                backgroundProgressBarColorStart = Color.WHITE
                backgroundProgressBarColorEnd = Color.RED
                backgroundProgressBarColorDirection =
                    CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set Width
                progressBarWidth = 7f // in DP
                backgroundProgressBarWidth = 3f // in DP

                // Other
                roundBorder = true
                startAngle = 180f
                progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
            }
        }

    /**
     * Called when the fragment is visible to the user and actively running.
     * This is generally
     * tied to [Activity.onResume] of the containing
     * Activity's lifecycle.
     */
    override fun onResume() {
        super.onResume()
        val timer = object: CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long)
            {
                binding.circularProgressBar.apply {
                    progress= (millisUntilFinished/1000).toFloat()
                }

            }

            override fun onFinish()
            {
                Toast.makeText(activity,"Finished ",Toast.LENGTH_SHORT)
            }
        }
        timer.start()
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