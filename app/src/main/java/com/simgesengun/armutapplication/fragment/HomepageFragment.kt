package com.simgesengun.armutapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.simgesengun.armutapplication.R
import com.simgesengun.armutapplication.adapter.*
import com.simgesengun.armutapplication.databinding.FragmentHomepageBinding
import com.simgesengun.armutapplication.entity.BlogPost
import com.simgesengun.armutapplication.entity.Service
import com.simgesengun.armutapplication.entity.ServiceDetail
import com.simgesengun.armutapplication.repo.GetDataCallback
import com.simgesengun.armutapplication.viewmodel.HomepageViewModel

class HomepageFragment : Fragment(R.layout.fragment_homepage) {

    private lateinit var viewModel: HomepageViewModel

    private var _binding: FragmentHomepageBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomepageBinding.bind(view)

        binding.nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->
            if(scrollY > 0) binding.motionLayout.transitionToEnd()
        })

        val blogPostOnClickListener = object : BlogPostAdapter.BlogPostOnClickListener {
            override fun toBlogPostDetails(blogPost: BlogPost) {
                val nav = HomepageFragmentDirections.toBlogPost(blogPost.link)
                Navigation.findNavController(view).navigate(nav)
            }

        }
        val getDataCallback = object : GetDataCallback {
            override fun onGetServiceDetail(serviceDetail: ServiceDetail?) {
                when(serviceDetail) {
                    null -> Toast.makeText(view.context, "Couldn't access this service", Toast.LENGTH_SHORT).show()
                    else -> {
                        val nav = HomepageFragmentDirections.toServiceDetails(serviceDetail)
                        Navigation.findNavController(view).navigate(nav)
                    }
                }
            }
            override fun onError() {
                Toast.makeText(view.context, "Couldn't access this service", Toast.LENGTH_SHORT).show()
            }

        }

        val serviceOnClickListener = object : ServiceOnClickListener {
            override fun toServiceDetails(service: Service) {
                viewModel.getService(service.id,getDataCallback)

            }
        }

        viewModel.serviceList.observe(viewLifecycleOwner,{ serviceList ->
            val serviceAdapter = ServiceAdapter(serviceList, serviceOnClickListener)
            binding.recyclerViewService.adapter = serviceAdapter

        })

        viewModel.popularServiceList.observe(viewLifecycleOwner,{ popularServiceList ->
            val servicePopularAdapter = PopularServiceAdapter(popularServiceList, serviceOnClickListener)
            binding.recyclerViewServicePopular.adapter = servicePopularAdapter
        })

        viewModel.postList.observe(viewLifecycleOwner,{ postList ->
            val blogPostAdapter = BlogPostAdapter(postList, blogPostOnClickListener)
            binding.recyclerViewBlogPost.adapter = blogPostAdapter
        })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val temp : HomepageViewModel by viewModels()
        viewModel = temp
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}