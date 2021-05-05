package com.ruanmello.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import com.ruanmello.convidados.service.constants.DataBaseConstants
import com.ruanmello.convidados.service.model.GuestModel
import java.lang.Exception

//Classes que a responsabilidade é salvar valores do banco de dados

class GuestRepository private constructor(context: Context) {

    //    Singleton
    private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun getAll(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getPresent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getAbsent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun save(guest: GuestModel): Boolean {

        return try {

            val db = mGuestDataBaseHelper.writableDatabase

            val contentValue = ContentValues()
            contentValue.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValue.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentValue)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun update(guest: GuestModel) {

    }

    fun delete(guest: GuestModel) {

    }
}