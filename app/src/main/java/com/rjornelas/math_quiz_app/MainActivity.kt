package com.rjornelas.math_quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.rjornelas.math_quiz_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnEasy?.setOnClickListener{startGame("easy")}
        binding?.btnMedium?.setOnClickListener{startGame("medium")}
        binding?.btnHard?.setOnClickListener{startGame("hard")}

    }

    private fun startGame(questionType: String){
        val intent = Intent(this, PlayActivity::class.java)
        intent.putExtra("questionType", questionType)
        startActivity(intent)
    }
}