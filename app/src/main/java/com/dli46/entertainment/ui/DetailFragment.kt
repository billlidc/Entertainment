package com.dli46.entertainment.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.dli46.entertainment.R
import com.dli46.entertainment.databinding.DetailFragmentBinding
import com.dli46.entertainment.ui.main.MainViewModel

class DetailFragment : Fragment() {

    private var selection = -1

    private val mvm: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        setHasOptionsMenu(true)
        _binding = DetailFragmentBinding.inflate(inflater, container, false)
        binding.apply {

            detailLayout.setBackgroundResource(R.drawable.background2)

            radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, id ->
                val radio: RadioButton = group.findViewById(id)
                selection = group.indexOfChild(radio)
            })

            optionRadioBtn1.setText(R.string.random_activity)
            optionRadioBtn2.setText(R.string.by_key)
            optionRadioBtn3.setText(R.string.by_type)
            optionRadioBtn4.setText(R.string.by_participants)

            optionRadioBtn1.setOnClickListener {
                if (selection >= 0) {
//                    findNavController().navigate(R.id.action_detailFragment_to_requestFragment)
                    val action =
                        DetailFragmentDirections.actionDetailFragmentToRequestFragment(selection)
                    Navigation.findNavController(it).navigate(action)
                }
            }
            optionRadioBtn2.setOnClickListener {
                if (selection >= 0) {
//                    findNavController().navigate(R.id.action_detailFragment_to_requestFragment)
                    val action =
                        DetailFragmentDirections.actionDetailFragmentToRequestFragment(selection)
                    Navigation.findNavController(it).navigate(action)
                }
            }
            optionRadioBtn3.setOnClickListener {
                if (selection >= 0) {
//                    findNavController().navigate(R.id.action_detailFragment_to_requestFragment)
                    val action =
                        DetailFragmentDirections.actionDetailFragmentToRequestFragment(selection)
                    Navigation.findNavController(it).navigate(action)
                }
            }
            optionRadioBtn4.setOnClickListener {
                if (selection >= 0) {
//                    findNavController().navigate(R.id.action_detailFragment_to_requestFragment)
                    val action =
                        DetailFragmentDirections.actionDetailFragmentToRequestFragment(selection)
                    Navigation.findNavController(it).navigate(action)
                }
            }
//
//            refreshFab.setOnClickListener {
//                mvm.updateActivityRandom()
//            }


            detailDoneButton.setOnClickListener {
                findNavController().navigate(R.id.action_detailFragment_to_mainFragment)
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