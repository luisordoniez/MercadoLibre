package com.meli.shop.di

import android.app.Application
import com.meli.shop.App
import com.meli.shop.data.api.NetworkModule
import com.meli.shop.data.db.DatabaseModule
import com.meli.shop.features.ContainerModule
import com.meli.shop.features.main.MainModule
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
        AndroidInjectionModule::class,
        NetworkModule::class,
        ContainerModule::class,
        MainModule::class,
        DatabaseModule::class
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