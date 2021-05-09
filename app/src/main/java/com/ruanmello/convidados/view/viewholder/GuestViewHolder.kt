package com.ruanmello.convidados.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ruanmello.convidados.R
import com.ruanmello.convidados.service.model.GuestModel
import kotlinx.android.synthetic.main.row_guest.view.*

//trata da atribuição dos valores para o layout de AllGuestFragment
class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel){
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guest.name
    }
}