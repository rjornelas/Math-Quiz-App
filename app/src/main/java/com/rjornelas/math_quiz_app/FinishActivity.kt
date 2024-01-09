package com.rjornelas.math_quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val score = intent.getIntExtra("score", 0)
        val data: ArrayList<Question> = intent.getSerializableExtra("dataSet") as ArrayList<Question>

        val tvScore: TextView = findViewById(R.id.tvScore)
        tvScore.text = "Your score is: $score/10"

        setAdapterRecyclerView(data)

        val btnNewGame: Button = findViewById(R.id.btnPlayAgain)
        btnNewGame.setOnClickListener{
            finish()
        }
    }

    private fun setAdapterRecyclerView(data: ArrayList<Question>){
        val recyclerView: RecyclerView = findViewById(R.id.rvQuestionList)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = QuestionAdapter(data)
        recyclerView.adapter = adapter
    }
}