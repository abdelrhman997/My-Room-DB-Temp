package com.example.roomtemp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductsDatabaseDao {

    @Insert
    suspend fun insert(product: Product)

    @Update
    suspend fun update(product: Product)

    @Query("SELECT * FROM products_table WHERE _id=:key")
    suspend fun get(key:Long):Product?

    @Query("DELETE FROM products_table")
    suspend fun clear()

    @Query("SELECT * FROM products_table ORDER BY _id DESC")
    fun getAllProducts():LiveData<List<Product>>

    @Query("SELECT * FROM products_table ORDER BY _id DESC LIMIT 1")
    suspend fun getLastProduct():Product?


}