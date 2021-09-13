package com.meli.shop.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.meli.shop.di.ViewModelFactory
import com.meli.shop.di.ViewModelKey
import com.meli.shop.features.main.ui.MainFragment
import com.meli.shop.features.main.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by Luis Ordoñez on 11/09/2021.
 */

@Module
abstract class MainModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}