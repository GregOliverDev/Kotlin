package models.character

class SheetDeD(
    var abilities: List<Ability>,
    var attributes: List<Attribute>,
    var breed: Breed,
    var campaign: Campaign,
    var character: Character,
    var classe: Classe,
    var displacement: Float,
    var level: Level,
    var proficiencies: List<Proficiency>,
    var xp: Int
) {
}
