package com.example.dedmobile.models.character.attributes

import com.example.dedmobile.models.character.attributes.IAttributes
import com.example.dedmobile.models.character.SheetDeD

class DefineAttributesModel(private var iAttributes: IAttributes, var sheetDeD: SheetDeD) {
    fun createAttributesModel(): SheetDeD {
        return iAttributes.defineAttributesModel(sheetDeD)
    }
}