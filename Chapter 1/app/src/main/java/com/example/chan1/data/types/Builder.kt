package com.example.chan1.data.types

enum class Builder {
    FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

    companion object {
        fun fromString(value: String): Builder? {
            return values().find { it.toString().equals(value, ignoreCase = true) }
        }
    }

    override fun toString(): String {

        return when (this) {

            FENDER -> "Fender"

            MARTIN -> "Martin"

            GIBSON -> "Gibson"

            COLLINGS -> "Collings"

            OLSON -> "Olson"

            RYAN -> "Ryan"

            PRS -> "Prs"

            ANY -> "Any"

        }
    }

}