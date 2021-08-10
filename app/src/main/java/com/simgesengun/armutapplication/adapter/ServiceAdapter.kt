package com.simgesengun.armutapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.simgesengun.armutapplication.R
import com.simgesengun.armutapplication.databinding.CardServiceBinding
import com.simgesengun.armutapplication.entity.Service

class ServiceAdapter(var serviceList: List<Service>, var serviceOnClickListener: ServiceOnClickListener) :
    RecyclerView.Adapter<ServiceAdapter.CardServiceHolder>() {

    inner class CardServiceHolder(cardServiceBinding: CardServiceBinding)
        : RecyclerView.ViewHolder(cardServiceBinding.root){
        var binding : CardServiceBinding

        init {
            this.binding = cardServiceBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardServiceHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val design = CardServiceBinding.inflate(layoutInflater, parent, false)

        return CardServiceHolder(design)
    }

    override fun onBindViewHolder(holder: CardServiceHolder, position: Int) {
        val service = serviceList[position]

        holder.binding.cardServiceLayout.setOnClickListener {
            serviceOnClickListener.toServiceDetails(service)
        }
        holder.binding.imageViewService.setServiceImage(service.id)
        holder.binding.textViewServiceTitle.setServiceTitle(service.id)

    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    private fun ImageView.setServiceImage(id : Int){
        val resourceId = when(id){
            208 -> { R.drawable.ic_c_renovation }
            191 -> { R.drawable.ic_c_cleaning }
            142 -> { R.drawable.ic_c_transportation }
            533 -> { R.drawable.ic_c_repairing }
            608 -> { R.drawable.ic_c_private_tuition }
            51547 -> { R.drawable.ic_c_healthcare }
            59 -> { R.drawable.ic_c_wedding }
            -1 -> { R.drawable.ic_c_etc }
            else -> { R.drawable.ic_c_unknown }
        }
        setImageResource(resourceId)
    }
    private fun TextView.setServiceTitle(id : Int){
        val textId = when(id){
            208 -> { R.string.renovation}
            191 -> { R.string.cleaning}
            142 -> { R.string.transportation}
            533 -> { R.string.repairing}
            608 -> { R.string.private_tuition}
            51547 -> { R.string.healthcare}
            59 -> { R.string.wedding}
            -1 -> { R.string.etc}
            else ->{ R.string.unknown}
        }
        setText(textId)
    }

}