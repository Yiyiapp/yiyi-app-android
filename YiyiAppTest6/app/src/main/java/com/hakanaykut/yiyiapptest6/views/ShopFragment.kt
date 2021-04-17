package com.hakanaykut.yiyiapptest6.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hakanaykut.yiyiapptest6.R
import kotlinx.android.synthetic.main.fragment_shop.*

class ShopFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var deger = 1
        siparisAdetTextView.text = deger.toString()

        arttirFBtn.setOnClickListener{
            deger += 1
            siparisAdetTextView.text = deger.toString()
        }
        azaltFBtn.setOnClickListener {
            if (deger > 0){
                deger -= 1
                siparisAdetTextView.text = deger.toString()
            }
            else{
                Toast.makeText(context,"0'dan daha az değer giremezsiniz", Toast.LENGTH_LONG).show()
            }
        }

    }
}