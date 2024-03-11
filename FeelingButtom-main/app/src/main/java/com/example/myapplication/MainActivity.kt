package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var generateButton: Button
    private lateinit var moodText: TextView
    private lateinit var animationView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateButton = findViewById(R.id.generateButton)
        moodText = findViewById(R.id.moodText)
        animationView = findViewById(R.id.animationView)

        generateButton.setOnClickListener {
            val mood = Random.nextInt(0, 101)
            moodText.text = "Your mood is $mood%"

            when (mood) {
                in 0..20 -> {
                    moodText.append("\nYou're feeling very sad.")
                    animationView.setAnimation("sad.json")
                }
                in 21..40 -> {
                    moodText.append("\nYou're feeling a bit down.")
                    animationView.setAnimation("okay.json")
                }
                in 41..60 -> {
                    moodText.append("\nYou're feeling neutral.")
                    animationView.setAnimation("neutral.json")
                }
                in 61..80 -> {
                    moodText.append("\nYou're feeling good.")
                    animationView.setAnimation("happy.json")
                }
                in 81..100 -> {
                    moodText.append("\nYou're feeling great!")
                    animationView.setAnimation("excited.json")
                }
            }

            animationView.playAnimation()
        }
    }
}


