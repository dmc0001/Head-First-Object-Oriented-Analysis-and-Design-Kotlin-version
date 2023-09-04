package com.example.chan1.repository

import com.example.chan1.data.Guitar
import com.example.chan1.data.spec.GuitarSpec
import java.util.LinkedList

class Inventory(private val guitars: LinkedList<Guitar>) {
    fun addGuitar(
        serialNumber: String,
        price: Double,
        guitarSpec: GuitarSpec
    ) {
        val guitar = Guitar(
            serialNumber, price, guitarSpec
        )
        guitars.add(guitar)
    }

    fun getGuitar(serialNumber: String): LinkedList<Guitar> {
        val matchingGuitars = LinkedList<Guitar>()
        for (guitar in guitars.iterator()) {

            if (guitar.serialNumber == serialNumber) {
                matchingGuitars.add(guitar)
            }
        }
        return matchingGuitars
    }

    fun searchGuitar(searchGuitar: GuitarSpec): LinkedList<Guitar> {
        val matchingGuitars = LinkedList<Guitar>()
        for (guitar in guitars.iterator()) {
            val guitarSpec = guitar.guitarSpec
            if (guitarSpec.matches(searchGuitar))
                matchingGuitars.add(guitar)

            matchingGuitars.add(guitar)
        }
        return matchingGuitars
    }

}