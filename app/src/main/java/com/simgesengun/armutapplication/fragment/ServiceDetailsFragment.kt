package com.simgesengun.armutapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.simgesengun.armutapplication.R
import com.simgesengun.armutapplication.databinding.FragmentServiceDetailsBinding

class ServiceDetailsFragment : Fragment() {

    private lateinit var binding : FragmentServiceDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_service_details, container, false)

        // Bundle
        val bundle : ServiceDetailsFragmentArgs by navArgs()
        binding.service = bundle.service

        return binding.root
    }
}