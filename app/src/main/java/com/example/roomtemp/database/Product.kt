package com.example.roomtemp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_table")
data class Product(
    @ColumnInfo("_id")
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo("name")
    val name:String,
    @ColumnInfo("description")
    val desc:String
)
