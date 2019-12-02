package com.isa.oliveira.truckerapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isa.oliveira.truckerapp.Fragment.MainFragment
import com.isa.oliveira.truckerapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .replace(R.id.container,
                MainFragment()
            )
            .addToBackStack("")
            .commit()

    }
}
