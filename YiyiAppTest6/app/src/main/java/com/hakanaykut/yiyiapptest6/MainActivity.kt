package com.hakanaykut.yiyiapptest6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        val guncelKullanici = auth.currentUser
        if(guncelKullanici != null) {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun mainGirisBtn(view: View){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun mainKayitBtn(view: View){

        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }
}