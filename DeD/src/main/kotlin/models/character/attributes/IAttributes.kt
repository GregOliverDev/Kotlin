package org.example.models.character.attributes

import models.character.SheetDeD
import java.awt.Choice

interface IAttributes {
    fun defineAttributesModel(sheetDeD: SheetDeD): SheetDeD
}