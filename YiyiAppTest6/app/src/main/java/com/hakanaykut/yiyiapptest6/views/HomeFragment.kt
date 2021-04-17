package com.hakanaykut.yiyiapptest6.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.auth.FirebaseAuth
import com.hakanaykut.yiyiapptest6.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser?.displayName.toString()
        homePageUsernameTextView.text = user

        siparisOlusturmaSayfa1.visibility = View.VISIBLE
        siparisOlusturmaSayfa2.visibility = View.INVISIBLE
        siparisOlusturmaSayfa3.visibility = View.INVISIBLE

        siparisListeEkleBtn.setOnClickListener {
            siparisOlusturmaSayfa1.visibility = View.INVISIBLE
            siparisOlusturmaSayfa2.visibility = View.VISIBLE
            siparisOlusturmaSayfa3.visibility = View.INVISIBLE
        }

        urun1TV.setOnClickListener {
            siparisOlusturmaSayfa1.visibility = View.INVISIBLE
            siparisOlusturmaSayfa2.visibility = View.INVISIBLE
            siparisOlusturmaSayfa3.visibility = View.VISIBLE
        }

        sepeteEkleBtn.setOnClickListener{
            Toast.makeText(context,"Başarı ile eklenmiştir!", Toast.LENGTH_LONG).show()
        }


        val mapFragment = childFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

    }

    private val callback = OnMapReadyCallback { googleMap ->

        val sydney = LatLng(41.117751,29.00167)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Burası"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }


}