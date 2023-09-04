package com.example.chan1.utils

import com.example.chan1.ui.fragment.client.ClientFragment.Companion.inventory
import com.example.chan1.data.spec.GuitarSpec
import com.example.chan1.data.types.Builder
import com.example.chan1.data.types.Type
import com.example.chan1.data.types.Wood


fun initializeInventory() {

    inventory.addGuitar(
        "V12345", 1345.55,
        GuitarSpec(
            Builder.FENDER, "Stratocastor",
            Type.ELECTRIC,
            Wood.ALDER,
            Wood.ADIRONDACK,
            6
        )
    )
    inventory.addGuitar(
        "A21457", 900.55,
        GuitarSpec(
            Builder.COLLINGS,
            "OakTown Goove",
            Type.ACOUSTIC,
            Wood.BRAZILIAN_ROSEWOOD,
            Wood.CEDAR,
            6
        )
    )
    inventory.addGuitar(
        "V95693",
        1499.95,
        GuitarSpec(
            Builder.FENDER,
            "Stratocastor",
            Type.ELECTRIC,
            Wood.ALDER,
            Wood.ALDER,
            6
        )
    )
    inventory.addGuitar(
        "X54321", 430.54,
        GuitarSpec(
            Builder.MARTIN,
            "Stratocastor Light",
            Type.ELECTRIC,
            Wood.INDIAN_ROSEWOOD,
            Wood.MAPLE,
            6
        )
    )
    inventory.addGuitar(
        "X99876", 2000.00, GuitarSpec(
            Builder.PRS,
            "Stratocastor FeatherWeight",
            Type.ELECTRIC,
            Wood.SITKA,
            Wood.COCOBOLO,
            6
        )
    )
    inventory.addGuitar(
        "V9512",
        1549.95,
        GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6)
    )

}