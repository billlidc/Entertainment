package com.dli46.entertainment.ui

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dli46.entertainment.R
import com.dli46.entertainment.databinding.ResultFragmentBinding
import com.dli46.entertainment.ui.main.MainViewModel

private const val TAG = "ResultFragment"

class ResultFragment : Fragment() {
//
//    private val mvm: MainViewModel by lazy {
//        ViewModelProvider(this)[MainViewModel::class.java]
//    }

    private val mvm: MainViewModel by activityViewModels()

    private var _binding: ResultFragmentBinding? = null
    private val binding get() = _binding!!


//    private var selection = 2
//    private var option = "5"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ResultFragmentBinding.inflate(inflater, container, false)
        binding.apply {

            // get values from mvm
            var selection = mvm.selection.value!!
            var option = mvm.option.value!!

            // set textView according to mvm values
//            mvm.selection.observe(viewLifecycleOwner){
//                selectionTextView.text = it.toString()
//                selectionTextView.isVisible = false
//            }
//
//            mvm.option.observe(viewLifecycleOwner){
//                optionTextView.text = it.toString()
//                selectionTextView.isVisible = false
//            }


            when (selection) {
                0 -> mvm.fetchActivityRandom()
                1 -> mvm.fetchActivityWithKey(option)
                2 -> mvm.fetchActivityWithType(option)
                3 -> mvm.fetchActivityWithParticipants(option)
            }

            mvm.activity.observe(viewLifecycleOwner) {
                activityTextView.text = "<$it!>"
            }
            mvm.type.observe(viewLifecycleOwner) {
                typeTextView.text = "Type-> $it"

                // set background according to 'type' generated
                when (mvm.type.value) {
                    "education" -> resultLayout.setBackgroundResource(R.drawable.education)
                    "recreational" -> resultLayout.setBackgroundResource(R.drawable.recreational)
                    "social" -> resultLayout.setBackgroundResource(R.drawable.social)
                    "diy" -> resultLayout.setBackgroundResource(R.drawable.diy)
                    "charity" -> resultLayout.setBackgroundResource(R.drawable.charity)
                    "cooking" -> resultLayout.setBackgroundResource(R.drawable.cooking)
                    "relaxation" -> resultLayout.setBackgroundResource(R.drawable.relaxation)
                    "music" -> resultLayout.setBackgroundResource(R.drawable.music)
                    "busywork" -> resultLayout.setBackgroundResource(R.drawable.busywork)
                }
            }
            mvm.participants.observe(viewLifecycleOwner) {
                participantsTextView.text = "Participants-> $it"
            }
            mvm.price.observe(viewLifecycleOwner) {
                priceTextView.text = "Price-> $it"
            }
            mvm.accessibility.observe(viewLifecycleOwner) {
                accessibilityTextView.text = "Accessibility-> $it"
            }
            mvm.key.observe(viewLifecycleOwner) {
                keyTextView.text = "Key-> $it"
            }
            mvm.link.observe(viewLifecycleOwner) {
                if (it == "") {
                    linkTextView.text = "Link-> none"
                } else
                    linkTextView.text = "Link-> $it"
            }


            resultDoneButton.setOnClickListener {
                itemDeletionAlert()
            }

        }

        return binding.root
    }


    private fun itemDeletionAlert() {
        val msg = resources.getString(R.string.alert_msg)
        val builder = AlertDialog.Builder(context)
        with(builder) {
            setTitle(R.string.alert)
            setMessage(msg)
            setIcon(R.drawable.ic_baseline_notifications_active_24)
            setPositiveButton(R.string.yes) { _, _ ->
                findNavController().navigate(R.id.action_resultFragment_to_detailFragment)
            }
            setNegativeButton(R.string.no) { _, _ ->
            }
            show()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}