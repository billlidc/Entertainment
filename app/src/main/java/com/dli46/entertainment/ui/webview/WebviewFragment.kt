package com.dli46.entertainment.ui.webview

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dli46.entertainment.databinding.WebviewFragmentBinding

private const val TAG = "WebviewFragment"

class WebviewFragment : Fragment() {

    private var _binding: WebviewFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WebviewViewModel by lazy {
        ViewModelProvider(this).get(WebviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WebviewFragmentBinding.inflate(inflater, container, false)
        binding.apply {

            webView.webViewClient = WebViewClient()

            viewModel.url.observe(viewLifecycleOwner) {
                gobar.urlEditText.setText(it)
                loadUrl(it)
            }

            gobar.urlEditText.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                    viewModel.setUrl(gobar.urlEditText.text.toString())
                    return@OnKeyListener true
                }
                false
            })
            gobar.goButton.setOnClickListener {
                viewModel.setUrl(gobar.urlEditText.text.toString())
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadUrl(request: String) {
        binding.webView.loadUrl(request)
    }
}
