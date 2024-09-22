package com.example.dedmobile.models.character.attributes

import com.example.dedmobile.models.character.SheetDeD

interface IAttributes {
    fun defineAttributesModel(sheetDeD: SheetDeD): SheetDeD
}