package com.hakanaykut.yiyiapptest6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        registerBackFBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
            }

    fun bireyselKayitButon(view: View) {

        val email = kayitOlEposta.text.toString()
        val sifre = kayitOlSifre1.text.toString()

        if (email != null && sifre != null) {
            auth.createUserWithEmailAndPassword(email, sifre).addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }.addOnFailureListener {
                Toast.makeText(applicationContext, it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(applicationContext, "Lütfen e-mail ve şifre giriniz", Toast.LENGTH_LONG)
                .show()
        }
    }

    fun burayaTiklaTextBtn(view: View){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}