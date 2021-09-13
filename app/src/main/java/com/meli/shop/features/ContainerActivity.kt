package com.meli.shop.features

import android.os.Bundle
import com.meli.shop.R
import dagger.android.support.DaggerAppCompatActivity

class ContainerActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
    }
}