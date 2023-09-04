package com.example.chan1.ui.fragment.client

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chan1.R
import com.example.chan1.adapter.GuitarAdapter
import com.example.chan1.data.spec.GuitarSpec
import com.example.chan1.data.types.Builder
import com.example.chan1.data.types.Type
import com.example.chan1.data.types.Wood
import com.example.chan1.databinding.FragmentClientBinding
import com.example.chan1.repository.Inventory
import com.example.chan1.utils.initializeInventory
import com.google.android.material.snackbar.Snackbar
import java.util.LinkedList


class ClientFragment : Fragment() {
    private lateinit var binding: FragmentClientBinding
    private lateinit var guitarAdapter: GuitarAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentClientBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeInventory()
        setupRecyclerViewGuitars()
        binding.apply {

            val builderOptions = resources.getStringArray(R.array.builder_options)
            val builderAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                builderOptions
            )
            edBuilder.setAdapter(builderAdapter)

            val typeOptions = resources.getStringArray(R.array.type_options)
            val typeAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                typeOptions
            )
            edType.setAdapter(typeAdapter)

            val woodOption = resources.getStringArray(R.array.wood_options)
            val woodAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                woodOption
            )
            edBackWood.setAdapter(woodAdapter)
            edTopWood.setAdapter(woodAdapter)

            btnSearch.setOnClickListener {
                val builderStr = edBuilder.text.toString()
                val model = edModel.text.trim().toString()
                val typeStr = edType.text.toString()
                val numberOfStringStr = edNumberOfString.text.trim().toString()
                val backWoodStr = edBackWood.text.toString()
                val topWoodStr = edTopWood.text.toString()
                if (builderStr.isEmpty() && model.isEmpty() && typeStr.isEmpty() && numberOfStringStr.isEmpty() && backWoodStr.isEmpty() && topWoodStr.isEmpty()) {
                    Snackbar.make(requireView(), "Fill all fields", Snackbar.LENGTH_LONG).show()
                } else {
                    // Convert the string values to enum values
                    val builder = Builder.fromString(builderStr)
                    val type = Type.fromString(typeStr)
                    val backWood = Wood.fromString(backWoodStr)
                    val topWood = Wood.fromString(topWoodStr)

                    // Create the GuitarSpec object
                    if (builder != null && type != null && backWood != null && topWood != null) {

                        val whatClientLikes = GuitarSpec(
                            builder,
                            model,
                            type,
                            backWood,
                            topWood,
                            6
                        )
                        Log.d(
                            "test",
                            "${whatClientLikes.builder},${whatClientLikes.model},${whatClientLikes.type},${whatClientLikes.backWood},${whatClientLikes.topWood},${whatClientLikes.numStrings}"
                        )
                        try {
                            val filteredGuitars = inventory.searchGuitar(whatClientLikes)
                            Log.d("list", whatClientLikes.toString())
                            Log.d("result lists", filteredGuitars.toString())
                            guitarAdapter.differ.submitList(filteredGuitars)
                        } catch (e: Exception) {
                            Snackbar.make(requireView(), e.toString(), Snackbar.LENGTH_LONG)
                                .show()
                        }
                    } else {
                        Snackbar.make(requireView(), "Sorry, We don't have this :'(", Snackbar.LENGTH_LONG)
                            .show()
                    }


                }
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

    companion object {
        var inventory = Inventory(LinkedList())
    }

}