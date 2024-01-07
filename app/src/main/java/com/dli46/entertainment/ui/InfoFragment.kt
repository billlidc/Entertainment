package com.dli46.entertainment.ui

import android.content.pm.PackageInfo
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dli46.entertainment.BuildConfig
import com.dli46.entertainment.R
import com.dli46.entertainment.databinding.InfoFragmentBinding

private const val TAG = "InfoFragment"

class InfoFragment : Fragment() {

    private val version_code = BuildConfig.VERSION_CODE
    private val version_name = BuildConfig.VERSION_NAME

    private var _binding: InfoFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        _binding = InfoFragmentBinding.inflate(inflater, container, false)
        binding.apply {
            // set Version Code and version Name programmatically
            appIconImageView.setImageResource(R.drawable.entertainments)
//            Log.d(TAG, "version_name: $versionName" )

            versionCodeTextView.text = getString(R.string.versionCode) + "$version_code"
            versionNameTextView.text = getString(R.string.versionName) + "$version_name"

            infoDoneButton.setOnClickListener {
                findNavController().navigate(R.id.action_infoFragment_to_mainFragment)
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }

}