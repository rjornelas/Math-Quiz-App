package com.rjornelas.math_quiz_app

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class QuestionAdapter(
    private val dataset: ArrayList<Question>
): RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val tvQuestion: TextView = view.findViewById(R.id.rvTvQuestion)
        val option1: Button = view.findViewById(R.id.rvBtnOption1)
        val option2: Button = view.findViewById(R.id.rvBtnOption2)
        val option3: Button = view.findViewById(R.id.rvBtnOption3)
        val option4: Button = view.findViewById(R.id.rvBtnOption4)
        val selectedAnswer: TextView = view.findViewById(R.id.rvTvUserAnswer)
        val correctAnswer: TextView = view.findViewById(R.id.rvTvCorrectAnswer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_question_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvQuestion.text = dataset[position].problem
        holder.option1.text = dataset[position].option1
        holder.option2.text = dataset[position].option2
        holder.option3.text = dataset[position].option3
        holder.option4.text = dataset[position].option4
        holder.selectedAnswer.text = "Your answer: ${dataset[position].selectedOption}"
        holder.correctAnswer.text = "Correct answer: ${dataset[position].answer}"

        if(position%2 != 0){
            holder.itemView.setBackgroundColor(Color.parseColor("#F34F6B"))
        }else{
            holder.itemView.setBackgroundColor(Color.parseColor("#F67087"))
        }

    }
}