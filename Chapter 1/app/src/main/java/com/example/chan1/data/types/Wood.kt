package com.example.chan1.data.types

enum class Wood {
    INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;


    companion object {
        fun fromString(value: String): Wood? {
            return values().find { it.name.equals(value, ignoreCase = true) }
        }
    }

    override fun toString(): String {

        return when (this) {

            INDIAN_ROSEWOOD -> "Indian Rosewood"

            BRAZILIAN_ROSEWOOD -> "Brazilian Rosewood"

            MAHOGANY -> "Mahogany"

            MAPLE -> "Maple"

            COCOBOLO -> "Cocobolo"

            CEDAR -> "Cedar"

            ADIRONDACK -> "Adirondack"

            ALDER -> "Alder"

            SITKA -> "Sitka"

        }
    }
}