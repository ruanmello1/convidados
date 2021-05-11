package com.ruanmello.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import com.ruanmello.convidados.service.constants.DataBaseConstants
import com.ruanmello.convidados.service.model.GuestModel
import java.lang.Exception

//Classes que a responsabilidade é salvar valores do banco de dados

class GuestRepository (context: Context) {

    private val mDataBase = GuestDataBase.getDatabase(context).guestDAO()

    fun getAll(): List<GuestModel> {
        return mDataBase.getInvited()
    }

    fun getPresent(): List<GuestModel> {
        return mDataBase.getPresent()
    }

    fun getAbsent(): List<GuestModel> {
        return mDataBase.getAbsent()
    }

    fun get(id: Int): GuestModel {
        return mDataBase.get(id)
    }

    fun save(guest: GuestModel): Boolean {
        return mDataBase.save(guest) > 0
    }

    fun update(guest: GuestModel): Boolean {
        return mDataBase.update(guest) > 0
    }

    fun delete(guest: GuestModel) {
        mDataBase.delete(guest)
    }
}

