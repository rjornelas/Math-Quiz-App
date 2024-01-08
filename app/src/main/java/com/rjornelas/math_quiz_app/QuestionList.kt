package com.rjornelas.math_quiz_app

import kotlin.random.Random

data class QuestionList(
    private val questionType: String
){
    private var questionList: ArrayList<Pair<String, Int>> = ArrayList(10)
    private var questionDataList = ArrayList<Question>(10)
    private var correctAnswer = ""


    private fun setQuestion(){
        when(questionType){
            "easy"-> {
                for(i in 1 .. 10){
                    questionList.add(Easy.getQuestions())
                }
            }
            "medium"-> {
                for(i in 1 .. 10){
                    questionList.add(Medium.getQuestions())
                }
            }
            else-> {
                for(i in 1 .. 10){
                    questionList.add(Hard.getQuestions())
                }
            }
        }
    }

    private fun getOption(position: Int): ArrayList<String>{
        val optionList = ArrayList<String>(4)
        var answer = questionList[position].second
        if(answer!=-9999){
            correctAnswer = answer.toString()
            optionList.add(answer.toString())
            optionList.add((answer+ Random.nextInt(-9,10)).toString())
            optionList.add((answer+ Random.nextInt(-9,10)).toString())
            optionList.add(answer.toString())
            optionList.add("NA")
        }else{
            correctAnswer = "NA"
            answer = Random.nextInt(1,4000)
            optionList.add((answer+ Random.nextInt(-9,10)).toString())
            optionList.add((answer+ Random.nextInt(-9,10)).toString())
            optionList.add((answer+ Random.nextInt(-9,10)).toString())
            optionList.add("NA")
        }
        optionList.shuffle()
        return optionList
    }

    fun getQuestionList(): ArrayList<Question>{
        setQuestion()
        for(i in 0 .. 9){
            val optionList = getOption(i)
            val question = Question(
                questionList[i].first,
                correctAnswer,
                option1 = optionList[0],
                option2 = optionList[1],
                option3 = optionList[2],
                option4 = optionList[3],
                "none"
                )
            questionDataList.add(question)
        }
        return questionDataList
    }
}
