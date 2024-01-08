package com.rjornelas.math_quiz_app

import java.lang.ArithmeticException
import kotlin.random.Random

object Hard {

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
        val number4 = Random.nextInt(1, 100)
        val bracketPosition = Random.nextInt(1,4)
        val operator1 = arrayOf("+", "-", "x", "/").random()
        val operator2 = arrayOf("+", "-", "x", "/").random()
        val operator3 = arrayOf("+", "-", "x", "/").random()

        val problem = when(bracketPosition){
            1-> "(($number1 $operator1 $number2) $operator2 $number3) $operator3 $number4"
            2 -> "(($number1 $operator1 ($number2 $operator2 $number3)) $operator3 $number4"
            else -> "($number1 $operator1 $number2) $operator2 ($number3 $operator3 $number4)"
        }

        val insideFirstBracketsAnswer = when(bracketPosition){
            1-> makeOperation(number1.toInt(), number2.toInt(), operator1)
            2-> makeOperation(number2.toInt(), number3.toInt(), operator2)
            else-> makeOperation(number1.toInt(), number2.toInt(), operator1) //TODO
        }

        val insideSecondBracketsAnswer = when(bracketPosition){
            1-> makeOperation(insideFirstBracketsAnswer, number3.toInt(), operator2)
            2-> makeOperation(number1.toInt(), insideFirstBracketsAnswer, operator1)
            else-> makeOperation(number3.toInt(), number4.toInt(), operator3)
        }

        var answer = when(bracketPosition){
            3-> makeOperation(insideFirstBracketsAnswer, insideSecondBracketsAnswer, operator2)
            else-> makeOperation(insideSecondBracketsAnswer, number4.toInt(), operator3)
        }

        if(insideSecondBracketsAnswer == -9999){
            answer = -9999
        }

        return Pair(problem, answer)
    }
}