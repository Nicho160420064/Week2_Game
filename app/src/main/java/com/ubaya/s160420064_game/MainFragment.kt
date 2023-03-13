package com.ubaya.s160420064_game

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val answerBTN = view.findViewById<Button>(R.id.btnAnswer)
        val num1 = view.findViewById<TextView>(R.id.txtNum1)
        val num2 = view.findViewById<TextView>(R.id.txtNum2)
        var x = 0
        var random1 = Random.nextInt(1, 99)
        var random2 = Random.nextInt(1,99)
        num1.text = random1.toString()
        num2.text = random2.toString()
        var answer = random1+random2
        answerBTN.setOnClickListener {
            val userAnswer = view.findViewById<EditText>(R.id.txtAnswer)
            if(answer==Integer.parseInt(userAnswer.text.toString())){
                x = x + 1
                random1 = Random.nextInt(1, 99)
                random2 = Random.nextInt(1,99)
                num1.text = random1.toString()
                num2.text = random2.toString()
                answer = random1+random2
            }
            else{
                var score = x.toString()
                val action = MainFragmentDirections.actionGameFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }

    }
}