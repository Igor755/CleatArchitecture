package com.devcraft.clean_architecture.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devcraft.clean_architecture.R
import com.devcraft.clean_architecture.common.BaseActivity
import com.devcraft.clean_architecture.extension.navigateTo
import com.devcraft.clean_architecture.ui.main.leagues.LeaguesFragment

class MainActivity : BaseActivity(R.layout.activity_main){
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
        navigateTo(
            R.id.fragment_container,
            LeaguesFragment(),backStackTag = MainActivity::class.java.name
        )
    }
}