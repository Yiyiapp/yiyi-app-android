package com.hakanaykut.yiyiapptest6.views.menus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.hakanaykut.yiyiapptest6.MainActivity
import com.hakanaykut.yiyiapptest6.R

class LogOutActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //setContentView(R.layout.activity_log_out)

        Thread.sleep(1000)

        auth = FirebaseAuth.getInstance()
        auth.signOut()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}