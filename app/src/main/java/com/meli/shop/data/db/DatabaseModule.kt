package com.meli.shop.data.db

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Luis Ordoñez on 12/09/2021.
 */

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDb(app: Application) = AppDatabase.getInstance(app)

    @Singleton
    @Provides
    fun provideProductDao(db: AppDatabase) = db.productsDao()
}