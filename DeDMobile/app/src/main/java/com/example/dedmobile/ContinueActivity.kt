package com.example.dedmobile

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.dedmobile.data.character.SheetDeDController
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.character.levels.DefineLive
import com.example.dedmobile.models.player.Player

class ContinueActivity : ComponentActivity() {
    private lateinit var player: Player
    private lateinit var sheetDeDController: SheetDeDController

    override fun onCreate(savedInstanceState: Bundle?) {
        sheetDeDController = SheetDeDController(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_continue)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        player = (intent.getSerializableExtra("CURRENT_USER") as? Player)!!

        val sheetDeD = sheetDeDController.getSheet(this, player.idSheetDeD)

        fun updateScreen() {
            var text: String = ""
            if (sheetDeD != null) {
                val nameCharacter: TextView = findViewById(R.id.name_character)
                text = sheetDeD.characterSheet.nameCharacter
                nameCharacter.text = text

                val ageCharacter: TextView = findViewById(R.id.age_character)
                text = sheetDeD.characterSheet.age.toString()
                ageCharacter.text = text

                val descriptorCharacter: TextView = findViewById(R.id.description_character)
                text = sheetDeD.characterSheet.physicalDescription
                descriptorCharacter.text = text

                val liveCharacter: TextView = findViewById(R.id.live_text)
                text = sheetDeD.hitPoints.toString()
                liveCharacter.text = text

                val levelCharacter: TextView = findViewById(R.id.level_text)
                text = sheetDeD.level.getLevel().toString()
                levelCharacter.text = text

                val characterImage: ImageView = findViewById(R.id.character_image)
                val characterImages = arrayOf(
                    R.drawable.character_01,
                    R.drawable.character_02,
                    R.drawable.character_03,
                    R.drawable.character_04
                )

                characterImage.setImageResource(characterImages[sheetDeD.characterSheet.indexImage])
            }
        }
        updateScreen()
        val btTraning: Button = findViewById(R.id.bt_traning)
        btTraning.setOnClickListener {

            if (sheetDeD != null) {
                if (sheetDeD.level.getLevel() < 20) {
                    var level = sheetDeD.level.getLevel()
                    level += 1
                    val defineLive = DefineLive()
                    val liveAtual = sheetDeD.let { it1 -> defineLive.updateLive(it1, level) }

                    sheetDeD.level.alterLevel = level
                    sheetDeD.hitPoints += liveAtual
                    sheetDeD.currentHitPoints += liveAtual
                    sheetDeD.amountDiceLive += 1
                    sheetDeDController.updateSheet(sheetDeD)

                    val toast = Toast.makeText(this, "Fixa Atualizada", Toast.LENGTH_SHORT)
                    toast.show()

                    Handler(Looper.getMainLooper()).postDelayed({
                        toast.cancel()
                    }, 5000)

                    updateScreen()
                } else {
                    val toast = Toast.makeText(this, "Level Maximo", Toast.LENGTH_SHORT)
                    toast.show()

                    Handler(Looper.getMainLooper()).postDelayed({
                        toast.cancel()
                    }, 5000)
                }
            }
        }
    }
}