package com.dli46.entertainment.ui

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceFragmentCompat
import com.dli46.entertainment.BuildConfig
import com.dli46.entertainment.R
import com.dli46.entertainment.databinding.SettingsFragmentBinding

private const val TAG = "SettingsFragment"


class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_fragment, rootKey)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }

//    private var _binding: SettingsFragmentBinding? = null
//    private val binding get() = _binding!!

//    override fun onCreateView(
//
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//
//        setHasOptionsMenu(true)
//        _binding = SettingsFragmentBinding.inflate(inflater, container, false)
//        binding.apply {
//            settingsDoneButton.setOnClickListener {
//                findNavController().navigate(R.id.action_settingsFragment_to_mainFragment)
//            }
//        }
//        return binding.root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

}