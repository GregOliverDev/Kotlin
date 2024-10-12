package com.example.dedmobile

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.example.dedmobile.models.character.SheetDeD
import com.example.dedmobile.models.player.Player

class SaveCharacterActivity: ComponentActivity() {
    private lateinit var player: Player
    private lateinit var sheetDeD: SheetDeD

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_character)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        player = (intent.getSerializableExtra("CURRENT_USER") as? Player)!!
        sheetDeD = (intent.getSerializableExtra("CURRENT_SHEETDED") as? SheetDeD)!!


    }
}