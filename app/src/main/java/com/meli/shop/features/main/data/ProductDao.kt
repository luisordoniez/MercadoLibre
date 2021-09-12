package com.meli.shop.features.main.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meli.shop.features.main.data.entity.Product

/**
 * Created by Luis Ordoñez on 12/09/2021.
 */

@Dao
interface ProductDao {
    @Query("SELECT * FROM product WHERE title LIKE '%' || :value || '%'")
    fun getProducts(value : String): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies : List<Product>)
}