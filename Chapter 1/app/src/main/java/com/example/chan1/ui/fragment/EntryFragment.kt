package com.example.chan1.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.chan1.R
import com.example.chan1.databinding.FragmentEntryBinding


class EntryFragment : Fragment() {

    private lateinit var binding: FragmentEntryBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEntryBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            clientCardView.setOnClickListener {
                Navigation.findNavController(view)
                    .navigate(R.id.action_entryFragment_to_clientFragment)
            }
            rickyCardView.setOnClickListener {
                Navigation.findNavController(view)
                    .navigate(R.id.action_entryFragment_to_rickysFragment)
            }
        }
    }


}