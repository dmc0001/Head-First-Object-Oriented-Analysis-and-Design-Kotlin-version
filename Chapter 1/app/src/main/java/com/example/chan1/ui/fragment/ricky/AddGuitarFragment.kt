package com.example.chan1.ui.fragment.ricky

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.chan1.ui.fragment.client.ClientFragment.Companion.inventory
import com.example.chan1.R
import com.example.chan1.data.spec.GuitarSpec
import com.example.chan1.data.types.Builder
import com.example.chan1.data.types.Type
import com.example.chan1.data.types.Wood
import com.example.chan1.databinding.FragmentAddGuitarBinding
import com.google.android.material.snackbar.Snackbar

class AddGuitarFragment : Fragment() {
    private lateinit var binding: FragmentAddGuitarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddGuitarBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
            btnAdd.setOnClickListener {
                val serialNumber = edSerialNumber.text.toString()
                val price = edPrice.text.toString()
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
                    val specGuitar = GuitarSpec(
                        builder!!,
                        model,
                        type!!,
                        backWood!!,
                        topWood!!,
                        6
                    )

                    inventory.addGuitar(
                        serialNumber,
                        price.toDouble(), specGuitar
                    )
                    Snackbar.make(requireView(),"Added guitar succesufully",Snackbar.LENGTH_LONG).show()


                }
            }
        }


    }
}