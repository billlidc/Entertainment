package com.dli46.entertainment.ui.colorview

import android.content.SharedPreferences
import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dli46.entertainment.R
import com.dli46.entertainment.model.Phrase

class ColorFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var color_textView: TextView
    private lateinit var back_button: Button

    private lateinit var prefs: SharedPreferences
    private lateinit var viewModel: ColorViewModel

    companion object {
        const val POSITION = "adapter_position"
//        fun newInstance() = ColorViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.color_fragment, container, false)

        prefs = PreferenceManager.getDefaultSharedPreferences(view.context)


        back_button = view.findViewById(R.id.color_done_button)
        back_button.setOnClickListener {
            findNavController().navigate(R.id.action_colorFragment_to_mainFragment)
        }

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.smoothScrollToPosition(prefs.getInt(POSITION, 0))

        Handler(Looper.getMainLooper()).postDelayed({
            recyclerView.findViewHolderForAdapterPosition(
                prefs.getInt(
                    POSITION,
                    0
                )
            )?.itemView?.performClick()
        }, 500L)

        color_textView = view.findViewById(R.id.color_textView)
        color_textView.text = ""

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ColorViewModel::class.java)

        viewModel.vocabulary.observe(viewLifecycleOwner) {
            recyclerView.adapter = ColorAdapter(it)
        }

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        color_textView = view.findViewById(R.id.color_textView)
        color_textView.text = ""
    }


    private inner class ColorViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        private lateinit var phrase: Phrase
        private val phraseTextView: TextView = itemView.findViewById(R.id.phrase_textView)
        private val cardLayout: LinearLayout = itemView.findViewById(R.id.card_Layout)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            var selected_color_info: String = "";
            selected_color_info =
                getString(R.string.message_colorItem) + phrase.colorId + getString(R.string.message_comma) +
                        getString(R.string.message_hexString) + phrase.hexString + getString(R.string.message_comma) + getString(
                    R.string.message_name
                ) + phrase.name + getString(R.string.message_right_parenthesis)
            color_textView.text = selected_color_info
            prefs.edit().putInt(POSITION, adapterPosition).apply()
        }

        fun bind(phrase: Phrase) {
            this.phrase = phrase
            phraseTextView.text = phrase.name // set text to the color name
            cardLayout.setBackgroundColor(Color.parseColor(phrase.hexString)) // set the card background color to be the given color
        }

    }

    private inner class ColorAdapter(private val list: List<Phrase>) :
        RecyclerView.Adapter<ColorViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
            val view = layoutInflater.inflate(R.layout.recycler_item, parent, false)
            return ColorViewHolder(view)
        }

        override fun getItemCount() = list.size

        override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
            holder.bind(list[position])
        }

    }

}