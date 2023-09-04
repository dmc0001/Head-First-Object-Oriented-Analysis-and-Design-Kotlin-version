package com.example.chan1.data.spec

import com.example.chan1.data.types.Builder
import com.example.chan1.data.types.Type
import com.example.chan1.data.types.Wood

class GuitarSpec(
    var builder: Builder,
    var model: String,
    var type: Type,
    var backWood: Wood,
    var topWood: Wood,
    var numStrings : Int
) {
    fun matches(otherSpec: GuitarSpec): Boolean {
        if (builder != otherSpec.builder) {
            return false
        }

        val model = otherSpec.model.lowercase()
        if ((model != "") && (model != otherSpec.model.lowercase())) {
            return false
        }

        if (type != otherSpec.type) {
            return false
        }

        if (backWood != otherSpec.backWood) {
            return false
        }

        if (topWood != otherSpec.topWood) {
            return false
        }

        if (numStrings != otherSpec.numStrings) {
            return false
        }

        return true
    }


}
