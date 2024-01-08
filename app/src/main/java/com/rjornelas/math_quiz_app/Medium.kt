package com.rjornelas.math_quiz_app

import java.lang.ArithmeticException
import kotlin.random.Random

object Medium {

    private fun makeOperation(number1: Int, number2: Int, operation: String): Int{
        val answer: Int = try{
           when(operation){
               "+"-> (number1 + number2)
               "-"-> (number1 - number2)
               "*"-> (number1 * number2)
               else-> (number1 / number2)
           }
        }catch (e: ArithmeticException){
            -9999
        }
        return answer
    }

    fun getQuestions():Pair<String, Int>{
        val number1 = Random.nextInt(1, 100)
        val number2 = Random.nextInt(1, 100)
        val number3 = Random.nextInt(1, 100)
        val bracketPosition = Random.nextInt(1,3)
        val operator1 = arrayOf("+", "-", "x", "/").random()
        val operator2 = arrayOf("+", "-", "x", "/").random()

        val problem = when(bracketPosition){
            1-> "($number1 $operator1 $number2) $operator2 $number3"
            else -> "$number1 $operator1 ($number2 $operator2 $number3)"
        }

        val insideBracketsAnswer = when(bracketPosition){
            1-> makeOperation(number1.toInt(), number2.toInt(), operator1)
            else-> makeOperation(number2.toInt(), number3.toInt(), operator2)
        }

        val answer = when(bracketPosition){
            1-> makeOperation(insideBracketsAnswer, number2.toInt(), operator1)
            else-> makeOperation(number2.toInt(), insideBracketsAnswer, operator2)
        }

        return Pair(problem, answer)
    }
}