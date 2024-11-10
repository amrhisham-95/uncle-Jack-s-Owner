package com.amrhishammahmoud.uncleJacksOwner.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.amrhishammahmoud.uncleJacksOwner.models.JacksMixes
import com.amrhishammahmoud.uncleJacksOwner.roomDatabase.DaoJacksMixes

@Database(entities = [JacksMixes::class], version = 1, exportSchema = false)
abstract class RoomDatabaseClassJacksMixes: RoomDatabase() {
    abstract fun dataDao(): DaoJacksMixes

    companion object{
        @Volatile
        private var Instance : RoomDatabaseClassJacksMixes?=null
        fun getInstance(context: Context):RoomDatabaseClassJacksMixes{
            val tempInstance = Instance
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    RoomDatabaseClassJacksMixes::class.java,
                    "jacksMixes_DataBase").build()
                Instance = instance
                return instance
            }
        }
    }
}