package com.ruanmello.convidados.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ruanmello.convidados.R
import com.ruanmello.convidados.service.constants.GuestConstants
import com.ruanmello.convidados.view.adapter.GuestAdapter
import com.ruanmello.convidados.view.listener.GuestListener
import com.ruanmello.convidados.viewModel.AllGuestsViewModel
import kotlinx.android.synthetic.main.fragment_all.*
import java.lang.System.load

class AllGuestsFragment : Fragment() {

    private lateinit var allGuestsViewModel: AllGuestsViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    private lateinit var mListener: GuestListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        allGuestsViewModel =
            ViewModelProvider(this).get(AllGuestsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_all, container, false)

//        RecyclerView
//        1 - Obter a recycler
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)

//        2 - Definir um layout
        recycler.layoutManager = LinearLayoutManager(context)

//        3 - Definir um adapter - junta banco de dados com layout da recyclerview
        recycler.adapter = mAdapter

        mListener = object : GuestListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)

                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUESTID, id)

                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                allGuestsViewModel.delete(id)
                allGuestsViewModel.load(GuestConstants.FILTER.EMPTY)
            }
        }

        mAdapter.attachListener(mListener)

        observer()

        return root
    }

    override fun onResume() {
        super.onResume()
        allGuestsViewModel.load(GuestConstants.FILTER.EMPTY)
    }

    private fun observer() {
        allGuestsViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }
}