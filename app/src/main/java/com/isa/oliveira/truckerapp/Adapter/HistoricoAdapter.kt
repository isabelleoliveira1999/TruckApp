package com.isa.oliveira.truckerapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.isa.oliveira.truckerapp.Activity.MainActivity
import com.isa.oliveira.truckerapp.Fragment.HistoricoDetalheFragment
import com.isa.oliveira.truckerapp.Model.allDetails
import com.isa.oliveira.truckerapp.R

class HistoricoAdapter : RecyclerView.Adapter<HistoricoAdapter.ViewHolder>() {


    private lateinit var mContext: Context
    private lateinit var container: LinearLayout



    private var allDetails= ArrayList<allDetails>()


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun addData(
        context: Context,
        mySolicitations: ArrayList<allDetails>
    ){
        mContext = context
        this.allDetails = mySolicitations
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_historico, parent, false)

        container = itemView.findViewById(R.id.container)

        container.setOnClickListener {
            var historicoDetalheFragment = HistoricoDetalheFragment()
            (mContext as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.container, historicoDetalheFragment)
                .addToBackStack("historico")
                .commit()
        }


        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setIsRecyclable(false)

    }

    override fun getItemCount(): Int {
        return allDetails.size
    }
}