package com.ruanmello.convidados.service.constants

class GuestConstants private constructor(){
    companion object {
        val GUESTID= "guestID"

    }

    object  FILTER {
        val EMPTY = 0
        val PRESENT = 1
        val ABSENT = 2
    }
}