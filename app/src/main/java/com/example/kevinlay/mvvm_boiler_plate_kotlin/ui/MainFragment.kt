package com.example.kevinlay.mvvm_boiler_plate_kotlin.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.example.kevinlay.mvvm_boiler_plate_kotlin.MainApplication
import com.example.kevinlay.mvvm_boiler_plate_kotlin.ui.viewmodel.MainFragmentViewModel
import com.example.kevinlay.mvvm_boiler_plate_kotlin.ui.viewmodel.MainFragmentViewModelFactory
import java.util.*
import javax.inject.Inject

class MainFragment: Fragment() {

    private lateinit var viewModel: MainFragmentViewModel

    @Inject lateinit var factory: MainFragmentViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (context?.applicationContext as MainApplication).appComponent.inject(this)

        viewModel = ViewModelProviders.of(this, factory).get(MainFragmentViewModel::class.java)

        viewModel.saveClicked(UUID.randomUUID().toString())
        viewModel.loadClicked()

        viewModel.entities.subscribe { entities -> Log.i("MainFragment", entities.toString())}
    }
}