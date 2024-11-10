package com.amrhishammahmoud.uncleJacksOwner.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.amrhishammahmoud.uncleJacksOwner.models.Fruits
import com.amrhishammahmoud.uncleJacksOwner.roomDatabase.DaoFruit


@Database(entities = [Fruits::class], version = 1, exportSchema = false)
abstract class RoomDatabaseClassFruits: RoomDatabase() {
    abstract fun dataDao(): DaoFruit

    companion object{
        @Volatile
        private var Instance : RoomDatabaseClassFruits?=null
        fun getInstance(context: Context):RoomDatabaseClassFruits{
            val tempInstance = Instance
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    RoomDatabaseClassFruits::class.java,
                    "fruit_DataBase").build()
                Instance = instance
                return instance
            }
        }
    }
}
