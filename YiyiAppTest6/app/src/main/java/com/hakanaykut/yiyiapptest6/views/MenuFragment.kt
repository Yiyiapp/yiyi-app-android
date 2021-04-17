package com.hakanaykut.yiyiapptest6.views

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import com.google.android.gms.dynamic.SupportFragmentWrapper
import com.google.firebase.auth.FirebaseAuth
import com.hakanaykut.yiyiapptest6.HomeActivity
import com.hakanaykut.yiyiapptest6.MainActivity
import com.hakanaykut.yiyiapptest6.R
import com.hakanaykut.yiyiapptest6.views.menus.*
import kotlinx.android.synthetic.main.fragment_menu.*
import java.security.AuthProvider

class MenuFragment : Fragment() {

    val proilimFragment = MenuProfilFragment()
    val bilgilerFragment = MenuBilgilerFragment()
    val oncekiSipFragment = MenuOncekiSipFragment()
    val adreslerFragment = MenuAdreslerFragment()
    val kartlarFragment = MenuKartlarFragment()
    val kuponlarFragment = MenuKuponlarFragment()
    val firsatlarFragment = MenuFirsatlarFragment()
    val sehirDegisFragment = MenuSehirDegisFragment()



    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profilimBtn.setOnClickListener {
            loadFragment(proilimFragment)
        }

        bilgilerimBtn.setOnClickListener {
            loadFragment(bilgilerFragment)
        }

        oncekiSiparislerimBtn.setOnClickListener {
            loadFragment(oncekiSipFragment)
        }

        adreslerimBtn.setOnClickListener {
           loadFragment(adreslerFragment)
        }

        kartlarimBtn.setOnClickListener {
            loadFragment(kuponlarFragment)
        }

        firsatlarBtn.setOnClickListener {
            loadFragment(firsatlarFragment)
        }

        sehirDegistirBtn.setOnClickListener {
            loadFragment(sehirDegisFragment)
        }

        cikisBtn.setOnClickListener {

            Toast.makeText(context, "Çıkış yapılmıştır.", Toast.LENGTH_LONG).show()

            activity?.let {

                val intent = Intent(it,LogOutActivity::class.java)
                it.startActivity(intent)
            }
        }
    }

    private fun loadFragment(fragment: Fragment){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fl_wrapper, fragment)
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }
}