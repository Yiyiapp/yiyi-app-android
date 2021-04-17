package com.hakanaykut.yiyiapptest6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import java.lang.Exception

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        loginPageBackFBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun girisYap(view: View) {

        try {
            auth.signInWithEmailAndPassword(
                girisEmailText.text.toString(),
                girisSifreText.text.toString()
            ).addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    val guncelKullanici = auth.currentUser?.email.toString()
                    Toast.makeText(this, "Hoşgeldin: ${guncelKullanici}", Toast.LENGTH_LONG).show()

                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(this, exception.localizedMessage, Toast.LENGTH_LONG).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show()
        }
    }

    fun burayaTiklayinTextBtn (view: View){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }
}