package com.example.chan1.ui.fragment.ricky

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chan1.adapter.GuitarAdapter
import com.example.chan1.databinding.FragmentGetGuitarBinding
import com.example.chan1.ui.fragment.client.ClientFragment.Companion.inventory
import com.example.chan1.utils.initializeInventory


class GetGuitarFragment : Fragment() {

    private lateinit var binding: FragmentGetGuitarBinding
    private lateinit var guitarAdapter: GuitarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGetGuitarBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerViewGuitars()
        initializeInventory()
        binding.apply {
            btnGet.setOnClickListener {
                val serialNumber = edSearch.text.toString()
                val guitars = inventory.getGuitar(serialNumber)
                guitarAdapter.differ.submitList(guitars)
                Log.d("test",guitars.toString()+serialNumber)
            }
        }
    }

    private fun setupRecyclerViewGuitars() {
        guitarAdapter = GuitarAdapter()

        binding.rvGuitars.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = guitarAdapter
        }
    }


}