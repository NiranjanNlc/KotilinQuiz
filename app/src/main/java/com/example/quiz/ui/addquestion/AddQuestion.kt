package com.example.quiz.ui.addquestion


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quiz.R
import com.example.quiz.factoryRepo.ModelViewFactory
import com.example.quiz.factoryRepo.Repo
import kotlinx.android.synthetic.main.add_question_fragment.*

class AddQuestion : Fragment() {


    companion object {
        fun newInstance() = AddQuestion()
    }
    private lateinit var  addQuestionFragmentBinding : com.example.quiz.databinding.QuestionPatternBinding;
    private lateinit var viewModel: AddQuestionViewModel
    private var count =0;
    private var score=0;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repo = Repo()
        val factory = ModelViewFactory(repo)
        addQuestionFragmentBinding = DataBindingUtil.setContentView(this.requireActivity(), R.layout.question_pattern)
        viewModel = ViewModelProvider(this, factory).get(AddQuestionViewModel::class.java)
        context?.let { viewModel.getQuizQuestion(it) }
        viewModel.question.observe(viewLifecycleOwner, Observer
        {
            println("this data here" + it)
            addQuestionFragmentBinding.question = it

        })
        return inflater.inflate(R.layout.question_pattern,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        addQuestionFragmentBinding.lifecycleOwner = this
        addQuestionFragmentBinding.viewModel = viewModel
        super.onActivityCreated(savedInstanceState)
        viewModel.getQuizQuestion(this.requireContext())
    }

    override fun onStart() {
        super.onStart()
    }


}
