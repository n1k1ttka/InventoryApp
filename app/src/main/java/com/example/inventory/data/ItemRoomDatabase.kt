package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemRoomDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDao
    companion object {
        @Volatile // Значение изменяемой переменной никогда не будет кэшироваться, и все операции записи и чтения будут выполняться в основную память и из нее
        var INSTANCE: ItemRoomDatabase? = null // Сохраняет ссылку на базу данных после создания, во избежание дубликатов
        fun getDataBase(context: Context): ItemRoomDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder( // "постройщик" баз данных
                    context.applicationContext, // context приложения
                    ItemRoomDatabase::class.java, // класс с базой данных
                    "item_database")
                    .fallbackToDestructiveMigration() // миграция
                    .build() // строитель базы данных
                INSTANCE = instance
                return instance
            }
        }
    }
}