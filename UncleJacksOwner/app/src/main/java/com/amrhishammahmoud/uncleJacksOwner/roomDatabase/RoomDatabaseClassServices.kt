package com.amrhishammahmoud.uncleJacksOwner.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.amrhishammahmoud.uncleJacksOwner.models.Services
import com.amrhishammahmoud.uncleJacksOwner.roomDatabase.DaoServices

@Database(entities = [Services::class], version = 1, exportSchema = false)
abstract class RoomDatabaseClassServices: RoomDatabase() {
    abstract fun dataDao(): DaoServices

    companion object{
        @Volatile
        private var Instance : RoomDatabaseClassServices?=null
        fun getInstance(context: Context):RoomDatabaseClassServices{
            val tempInstance = Instance
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    RoomDatabaseClassServices::class.java,
                    "services_DataBase").build()
                Instance = instance
                return instance
            }
        }
    }
}