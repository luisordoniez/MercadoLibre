package com.meli.shop.di

import android.app.Application
import com.meli.shop.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Luis Ordoñez on 10/09/2021.
 */

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class
        /*modules de la app*/]
)
interface AppComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(application: App)
}