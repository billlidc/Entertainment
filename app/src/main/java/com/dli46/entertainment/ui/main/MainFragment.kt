package com.dli46.entertainment.ui.main

import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.dli46.entertainment.App.Companion.EFFECT_SELECTION
import com.dli46.entertainment.App.Companion.SHOW_NOW_IMAGE
import com.dli46.entertainment.R
import com.dli46.entertainment.databinding.MainFragmentBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import jp.wasabeef.picasso.transformations.CropSquareTransformation
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import jp.wasabeef.picasso.transformations.gpu.InvertFilterTransformation
import jp.wasabeef.picasso.transformations.gpu.PixelationFilterTransformation


class MainFragment : Fragment(), SharedPreferences.OnSharedPreferenceChangeListener {

    private val prefs: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(requireContext())
    }

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        prefs.registerOnSharedPreferenceChangeListener(this)

        _binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.apply {
            registerForContextMenu(avatorImageView)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        prefs.unregisterOnSharedPreferenceChangeListener(this)
        _binding = null
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        when (key) {
            SHOW_NOW_IMAGE, EFFECT_SELECTION -> {
                setImage()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            colorBtn.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_colorFragment)
            }
            webviewBtn.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_webviewFragment)
            }
            activityBtn.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
            }
        }
        setImage()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        activity?.menuInflater?.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.avator1_item -> {
                with(prefs.edit()) {
                    putBoolean(SHOW_NOW_IMAGE, false)
                    apply()
                }
                true
            }
            R.id.avator2_item -> {
                with(prefs.edit()) {
                    putBoolean(SHOW_NOW_IMAGE, true)
                    apply()
                }
                true
            }
            else -> return super.onContextItemSelected(item)
        }
    }


    private fun setImage() {
        val effect = when (prefs.getString(EFFECT_SELECTION, "0")?.toInt()) {
            0 -> CropSquareTransformation()
            1 -> CropCircleTransformation()
            2 -> BlurTransformation(context, 15, 1)
            3 -> PixelationFilterTransformation(context, 48.0f)
            4 -> InvertFilterTransformation(context)
            else -> RoundedCornersTransformation(85, 32)
        }

        val resID =
            if (prefs.getBoolean(SHOW_NOW_IMAGE, false))
                R.drawable.avatar
            else R.drawable.avatar2

        val picasso = Picasso.get()
        picasso.load(resID)
            .transform(effect)
            .into(binding.avatorImageView)
    }

}