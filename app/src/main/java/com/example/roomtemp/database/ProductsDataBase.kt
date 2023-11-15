package com.example.roomtemp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductsDataBase:RoomDatabase() {
    abstract val productsDatabaseDao:ProductsDatabaseDao

    companion object{
        @Volatile
        private var Instance:ProductsDataBase? = null
        fun getInstance(context:Context):RoomDatabase{
            synchronized(this){
                var instance= Instance
                if(instance == null){
                    instance= Room.databaseBuilder(context.applicationContext,
                        ProductsDataBase::class.java,"products_database").fallbackToDestructiveMigration()
                        .build()
                    Instance=instance
                }
                return instance
            }
        }
    }

}