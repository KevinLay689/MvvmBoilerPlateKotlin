package com.example.kevinlay.mvvm_boiler_plate_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kevinlay.mvvm_boiler_plate_kotlin.ui.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.container, MainFragment()).commit()
    }
}
