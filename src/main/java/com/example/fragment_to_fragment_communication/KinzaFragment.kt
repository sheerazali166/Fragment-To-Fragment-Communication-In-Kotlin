package com.example.fragment_to_fragment_communication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import java.lang.ClassCastException

class KinzaFragment : Fragment() {

    var onKinzaMessageListener:OnKinzaMessageListener? = null

    public interface OnKinzaMessageListener{

        fun onKinzaMessage(message: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View = inflater.inflate(R.layout.fragment_kinza, container, false)

        var editTextKinza:EditText = view.findViewById(R.id.editTextKinza)

        var buttonKinza:Button = view.findViewById(R.id.buttonKinza)

        buttonKinza.setOnClickListener {

            var kinza:String = editTextKinza.text.toString()

            onKinzaMessageListener!!.onKinzaMessage(kinza)
        }


        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        var activity:Activity = context as Activity

        try {

            onKinzaMessageListener = activity as OnKinzaMessageListener
        }

        catch (c: ClassCastException){

            throw ClassCastException("${activity.toString()} onKinzaMessage must implimented..")
        }
    }

}