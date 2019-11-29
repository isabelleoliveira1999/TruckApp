package com.redfox.tech.mytesteapplication.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.redfox.tech.mytesteapplication.Fragment.MainFragment
import com.redfox.tech.mytesteapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .addToBackStack("")
            .commit()

    }
}
