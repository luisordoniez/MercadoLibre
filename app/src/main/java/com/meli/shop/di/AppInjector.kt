package com.meli.shop.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.meli.shop.App
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

/**
 * Created by Luis Ordoñez on 11/09/2021.
 * Objeto que sirve como puente para inicializar la inyeccion de modulos.
 */

object AppInjector {

    /**
     * Metodo inicializador
     * @param application instancia de la app que nos sirve para hacer inyeccion de modulos.
     */

    fun init(application: App){
        DaggerAppComponent.builder().application(application).build().inject(application)

        application.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks{
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {
                //No implementation needed
            }

            override fun onActivityResumed(activity: Activity) {
                //No implementation needed
            }

            override fun onActivityPaused(activity: Activity) {
                //No implementation needed
            }

            override fun onActivityStopped(activity: Activity) {
                //No implementation needed
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                //No implementation needed
            }

            override fun onActivityDestroyed(activity: Activity) {
                //No implementation needed
            }
        })
    }

    /**
     * Metodo que se llama cada vez que se lanza una actividad o fragment
     * con el fin de determinar que tipo de inyeccion se hace.
     */

    private fun handleActivity(activity: Activity) {
        if (activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                    if (f is Injectable) {
                        AndroidSupportInjection.inject(f)
                    }
                }
            }, true
            )
        }
    }
}