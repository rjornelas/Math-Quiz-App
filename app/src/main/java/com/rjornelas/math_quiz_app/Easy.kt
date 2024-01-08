package com.rjornelas.math_quiz_app

import java.lang.ArithmeticException
import kotlin.random.Random

object Easy {

    private var answer: Int = 0

    fun getQuestions():Pair<String, Int>{
        val number1 = Random.nextInt(-100,100)
        val number2 = Random.nextInt(-100,100)
        val operator = arrayOf("+", "-", "*", "/").random()

        val problem = "$number1 $operator $number2"

        answer = try{
            when(operator){
                "+"-> (number1 + number2).toInt()
                "-"-> (number1 - number2).toInt()
                "*"-> (number1 * number2).toInt()
                else-> (number1 / number2).toInt()
            }
        }catch (e: ArithmeticException){
            -9999
        }

        return Pair(problem, answer)
    }

}