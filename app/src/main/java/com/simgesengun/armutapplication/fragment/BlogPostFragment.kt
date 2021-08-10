package com.simgesengun.armutapplication.fragment

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.navArgs
import com.simgesengun.armutapplication.R
import com.simgesengun.armutapplication.databinding.FragmentBlogPostBinding
import com.simgesengun.armutapplication.databinding.FragmentHomepageBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class BlogPostFragment : Fragment(R.layout.fragment_blog_post) {

    private var fragmentBlogPostBinding: FragmentBlogPostBinding? = null

    private lateinit var serviceUrl : String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bundle
        val bundle : BlogPostFragmentArgs by navArgs()
        serviceUrl = bundle.serviceUrl

        val binding = FragmentBlogPostBinding.bind(view)
        fragmentBlogPostBinding = binding

        binding.errorLayout.findViewById<Button>(R.id.buttonRetry).setOnClickListener {
            binding.webView.loadUrl(serviceUrl)
        }

        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                val url = request?.url.toString()
                view?.loadUrl(url)
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                binding.progressBar.visibility = View.VISIBLE
                binding.errorLayout.visibility = View.GONE
                binding.webView.visibility = View.VISIBLE
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                binding.progressBar.visibility = View.GONE
                super.onPageFinished(view, url)
            }

            override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
                view.stopLoading()
                binding.progressBar.visibility = View.GONE
                binding.errorLayout.visibility = View.VISIBLE
                binding.webView.visibility = View.GONE
            }
        }
        binding.webView.loadUrl(serviceUrl)

    }

    override fun onDestroyView() {
        fragmentBlogPostBinding = null
        super.onDestroyView()
    }
}