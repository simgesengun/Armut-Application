package com.simgesengun.armutapplication.adapter

import com.simgesengun.armutapplication.entity.Service

interface ServiceOnClickListener {
    fun toServiceDetails(service : Service)
}