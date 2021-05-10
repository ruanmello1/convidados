package com.ruanmello.convidados.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ruanmello.convidados.service.constants.GuestConstants
import com.ruanmello.convidados.service.model.GuestModel
import com.ruanmello.convidados.service.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()

    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun load(filter: Int){

        if (filter == GuestConstants.FILTER.EMPTY) {
            mGuestList.value = mGuestRepository.getAll()
        } else if (filter == GuestConstants.FILTER.ABSENT) {
            mGuestList.value = mGuestRepository.getAbsent()
        } else {
            mGuestList.value = mGuestRepository.getPresent()
        }

    }

    fun delete(id: Int) {
        mGuestRepository.delete(id)
    }
}