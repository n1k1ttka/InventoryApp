package com.example.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "item")
data class Item(
    @PrimaryKey (autoGenerate = true) // Room генерит идентификатор для каждого объекта
    val id: Int = 0,
    @ColumnInfo (name = "Name")
    val itemName: String,
    @ColumnInfo (name = "Price")
    val itemPrice: Double,
    @ColumnInfo (name = "Quantity")
    val quantityInStock: Int){
}