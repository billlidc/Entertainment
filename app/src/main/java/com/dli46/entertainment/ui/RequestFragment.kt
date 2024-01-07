package com.dli46.entertainment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.dli46.entertainment.R
import com.dli46.entertainment.databinding.RequestFragmentBinding
import com.dli46.entertainment.ui.main.MainViewModel


private const val TAG = "RequestFragment"

class RequestFragment : DialogFragment(), AdapterView.OnItemSelectedListener {

    private val mvm: MainViewModel by activityViewModels()

    private var selection = -1
    private var option = ""

    private var _binding: RequestFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RequestFragmentBinding.inflate(inflater, container, false)
        binding.apply {

            arguments?.let { args ->
                if (args.containsKey("selection")) {
                    RequestFragmentArgs.fromBundle(args).let {
                        selection = it.selection
                    }
                }
            }

            // test safe args
//            promptTextView.setText(selection_.toString())

            // set the textView of the spinner accordingly
            when (selection) {
                0 -> promptTextView.setText(R.string.random_activity)
                1 -> promptTextView.setText(R.string.by_key)
                2 -> promptTextView.setText(R.string.by_type)
                3 -> promptTextView.setText(R.string.by_participants)
                else -> {
                    print("-1, not valid")
                }
            }

            // set the array instance of the spinner accordingly
            context?.apply {
                val aa0 = ArrayAdapter.createFromResource(
                    this,
                    R.array.random_array, android.R.layout.simple_spinner_item
                )
                aa0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                val aa1 = ArrayAdapter.createFromResource(
                    this,
                    R.array.key_array, android.R.layout.simple_spinner_item
                )
                aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                val aa2 = ArrayAdapter.createFromResource(
                    this,
                    R.array.type_array, android.R.layout.simple_spinner_item
                )
                aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                val aa3 = ArrayAdapter.createFromResource(
                    this,
                    R.array.participant_array, android.R.layout.simple_spinner_item
                )
                aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                when (selection) {
                    0 -> promptSpinner.adapter = aa0
                    1 -> promptSpinner.adapter = aa1
                    2 -> promptSpinner.adapter = aa2
                    3 -> promptSpinner.adapter = aa3
                }
                promptSpinner.onItemSelectedListener = this@RequestFragment
            }

            cancelBtn.setOnClickListener {
                dismiss()
            }

            goBtn.setOnClickListener {
                // set mvm values (used for ResultFragment)
                mvm.setSelection(selection)
                mvm.setOption(option)

                findNavController().navigate(R.id.action_requestFragment_to_resultFragment)
                dismiss()
            }

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        binding.apply {
            when (p0) {
                promptSpinner -> option = p0.getItemAtPosition(p2).toString()
                // option is the selected item (String) using parent.getItemAtPosition(pos)
            }
        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
