package com.example.fragment_to_fragment_communication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class RabiaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View = inflater.inflate(R.layout.fragment_rabia, container, false)

        var textViewKinza = view.findViewById<TextView>(R.id.textViewKinza)

        var bundleKinza: Bundle? = arguments

        var kinza:String = bundleKinza!!.getString("kinza", "")

        textViewKinza.text = kinza

        // 💕💕💕💕💕💕💕💕💕💕 Kinza Amjad is so so cute 💕💕💕💕💕💕💕💕💕

        return view
    }



}