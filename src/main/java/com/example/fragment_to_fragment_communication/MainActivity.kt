package com.example.fragment_to_fragment_communication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity(), KinzaFragment.OnKinzaMessageListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (findViewById<FrameLayout>(R.id.kinzaContainer) != null){

            if(savedInstanceState != null){
                return
            }

            var kinzaFragment:KinzaFragment = KinzaFragment()

            supportFragmentManager.beginTransaction().add(R.id.kinzaContainer, kinzaFragment, null)
                .commit()
        }
    }

    override fun onKinzaMessage(message: String) {

        var rabiaFragment:RabiaFragment = RabiaFragment()

        var bundle:Bundle = Bundle()

        bundle.putString("kinza", message)

        rabiaFragment.arguments = bundle

        supportFragmentManager.beginTransaction().replace(R.id.kinzaContainer, rabiaFragment, null)
            .addToBackStack(null).commit()



    }
}