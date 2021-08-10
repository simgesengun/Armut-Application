package com.simgesengun.armutapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simgesengun.armutapplication.databinding.CardPopularServiceBinding
import com.simgesengun.armutapplication.entity.Service

class PopularServiceAdapter(var popularServiceList: List<Service>, var serviceOnClickListener: ServiceOnClickListener) :
    RecyclerView.Adapter<PopularServiceAdapter.CardPopularServiceHolder>() {

    inner class CardPopularServiceHolder(cardPopularServiceBinding: CardPopularServiceBinding)
        : RecyclerView.ViewHolder(cardPopularServiceBinding.root){
        var binding : CardPopularServiceBinding

        init {
            this.binding = cardPopularServiceBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardPopularServiceHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val design = CardPopularServiceBinding.inflate(layoutInflater, parent, false)

        return CardPopularServiceHolder(design)
    }

    override fun onBindViewHolder(holder: CardPopularServiceHolder, position: Int) {
        val popularService = popularServiceList[position]
        holder.binding.popularService = popularService
        holder.binding.cardServicePopularLayout.setOnClickListener { serviceOnClickListener.toServiceDetails(popularService) }

    }

    override fun getItemCount(): Int {
        return popularServiceList.size
    }

}