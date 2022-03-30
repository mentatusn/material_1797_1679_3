package com.gb.material_1797_1679_3.view.ux

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.gb.material_1797_1679_3.R
import com.gb.material_1797_1679_3.view.MainActivity
import com.gb.material_1797_1679_3.view.main.PictureOfTheDayFragment

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MyBlueTheme)
        setContentView(R.layout.activity_splash)


        findViewById<ImageView>(R.id.iv).animate().rotationBy(720f).setDuration(5000L).start()

        /*Handler(mainLooper).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 5000L)*/

        val cdt= object :CountDownTimer(2000,2000){
            override fun onTick(millisUntilFinished: Long) {
            }
            override fun onFinish() {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        }
        cdt.start()

    }

}