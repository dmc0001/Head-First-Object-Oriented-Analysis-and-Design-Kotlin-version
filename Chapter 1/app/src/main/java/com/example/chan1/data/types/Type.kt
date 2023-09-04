package com.example.chan1.data.types

enum class Type {
    ACOUSTIC, ELECTRIC;

    companion object {
        fun fromString(value: String): Type? {
            return values().find { it.name.equals(value, ignoreCase = true) }
        }
    }

    override fun toString(): String {

        return when (this) {

            ACOUSTIC -> "Acoustic"

            ELECTRIC -> "Electric"

        }
    }

}