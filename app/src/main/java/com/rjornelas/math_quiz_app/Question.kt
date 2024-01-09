package com.rjornelas.math_quiz_app

data class Question(
    val problem: String,
    val answer: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    var selectedOption: String
)
