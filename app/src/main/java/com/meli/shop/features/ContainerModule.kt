package com.meli.shop.features

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Luis Ordoñez on 11/09/2021.
 */

@Module
abstract class ContainerModule {
    @ContributesAndroidInjector
    abstract fun contributeContainerActivity(): ContainerActivity
}