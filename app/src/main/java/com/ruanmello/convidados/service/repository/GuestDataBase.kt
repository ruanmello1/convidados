package com.ruanmello.convidados.service.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ruanmello.convidados.service.model.GuestModel

@Database(entities = arrayOf(GuestModel::class), version = 1)
abstract class GuestDataBase : RoomDatabase() {

    abstract fun guestDAO(): GuestDAO

    companion object {

        private lateinit var INSTANCE: GuestDataBase
        fun getDatabase(context: Context): GuestDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(GuestDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, GuestDataBase::class.java, "GuestDB")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}