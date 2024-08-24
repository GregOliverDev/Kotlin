package org.example.models.character.attributes

import models.character.SheetDeD

class DefineAttributesModel(private var iAttributes: IAttributes, var sheetDeD: SheetDeD) {
    fun createAttributesModel(): SheetDeD {
        return iAttributes.defineAttributesModel(sheetDeD)
    }
}