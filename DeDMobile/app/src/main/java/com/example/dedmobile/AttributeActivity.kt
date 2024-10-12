package com.example.dedmobile

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.dedmobile.models.Topic
import com.example.dedmobile.models.character.Attribute
import com.example.dedmobile.models.character.Character
import com.example.dedmobile.models.character.Mod
import com.example.dedmobile.models.character.attributes.AttributesModel
import com.example.dedmobile.models.character.attributes.DefineAttributes
import com.example.dedmobile.models.character.modifiers.DefineMod
import com.example.dedmobile.models.player.Player

@Suppress("DEPRECATION")
class AttributeActivity : ComponentActivity() {
    private lateinit var player: Player
    private lateinit var character: Character
    private lateinit var attributesModel: AttributesModel
    private lateinit var attributes: List<Attribute>
    private lateinit var mods: List<Mod>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attribute)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        player = (intent.getSerializableExtra("CURRENT_USER") as? Player)!!
        character = (intent.getSerializableExtra("CURRENT_CHARACTER") as? Character)!!
        val defineMod = DefineMod()
        mods = defineMod.defineMods()
        attributes = DefineAttributes().defineAttributes().toList()
        attributesModel = AttributesModel()

        val points: TextView = findViewById(R.id.points)

        val btNext: Button = findViewById(R.id.bt_next)
        btNext.setOnClickListener {
            val pointsCurrent = points.text.toString().toIntOrNull() ?: 0
            if (pointsCurrent == 0) {
                val intent = Intent(this, ChoicesActivity::class.java)
                intent.putExtra("CURRENT_USER", player)
                intent.putExtra("CURRENT_CHARACTER", character)
                intent.putExtra("CURRENT_ATTRIBUTES", attributes.toTypedArray())
                intent.putExtra("CURRENT_MOD", mods.toTypedArray())
                startActivity(intent)
            } else {
                val toast =
                    Toast.makeText(this, "Distribua todos os pontos", Toast.LENGTH_SHORT)
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            }
        }

        val btBack: Button = findViewById(R.id.bt_back)
        btBack.setOnClickListener {
            val intent = Intent(this, CharacterActivity::class.java)
            intent.putExtra("CURRENT_USER", player)
            intent.putExtra("CURRENT_CHARACTER", character)
            startActivity(intent)
        }

        val valueAttri0: TextView = findViewById(R.id.value_attribute_0)
        val valueAttri1: TextView = findViewById(R.id.value_attribute_1)
        val valueAttri2: TextView = findViewById(R.id.value_attribute_2)
        val valueAttri3: TextView = findViewById(R.id.value_attribute_3)
        val valueAttri4: TextView = findViewById(R.id.value_attribute_4)
        val valueAttri5: TextView = findViewById(R.id.value_attribute_5)

        val valueMod0: TextView = findViewById(R.id.value_mod_0)
        val valueMod1: TextView = findViewById(R.id.value_mod_1)
        val valueMod2: TextView = findViewById(R.id.value_mod_2)
        val valueMod3: TextView = findViewById(R.id.value_mod_3)
        val valueMod4: TextView = findViewById(R.id.value_mod_4)
        val valueMod5: TextView = findViewById(R.id.value_mod_5)

        val btRemAttri0: ImageButton = findViewById(R.id.remove_attribute_0)
        val btRemAttri1: ImageButton = findViewById(R.id.remove_attribute_1)
        val btRemAttri2: ImageButton = findViewById(R.id.remove_attribute_2)
        val btRemAttri3: ImageButton = findViewById(R.id.remove_attribute_3)
        val btRemAttri4: ImageButton = findViewById(R.id.remove_attribute_4)
        val btRemAttri5: ImageButton = findViewById(R.id.remove_attribute_5)

        val btAddAttri0: ImageButton = findViewById(R.id.add_attribute_0)
        val btAddAttri1: ImageButton = findViewById(R.id.add_attribute_1)
        val btAddAttri2: ImageButton = findViewById(R.id.add_attribute_2)
        val btAddAttri3: ImageButton = findViewById(R.id.add_attribute_3)
        val btAddAttri4: ImageButton = findViewById(R.id.add_attribute_4)
        val btAddAttri5: ImageButton = findViewById(R.id.add_attribute_5)

        Topic.subscribe("valueAttribute") { valueChanged ->
            var attribute: Attribute
            for (index in 0..5) {
                if (attributes[index].nameAttribute == valueChanged) {
                    attribute = attributes[index]
                    mods = defineMod.updateMod(mods, attribute, index)

                    valueMod0.text = mods[0].valueMod.toString()
                    valueMod1.text = mods[1].valueMod.toString()
                    valueMod2.text = mods[2].valueMod.toString()
                    valueMod3.text = mods[3].valueMod.toString()
                    valueMod4.text = mods[4].valueMod.toString()
                    valueMod5.text = mods[5].valueMod.toString()

                }
            }
        }

        attributes = DefineAttributes().defineAttributes().toList()

        btRemAttri0.setOnClickListener {
            var pointsCurrent = points.text.toString().toIntOrNull() ?: 0

            if (attributes[0].valueAttribute == 8) {
                val toast =
                    Toast.makeText(this, "Não é possível diminuir abaixo de 8 ", Toast.LENGTH_SHORT)
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            } else {
                pointsCurrent += attributesModel.defineAttributesModel(attributes[0].valueAttribute)
                attributes[0].valueAt--
                pointsCurrent -= attributesModel.defineAttributesModel(attributes[0].valueAttribute)
                points.text = pointsCurrent.toString()
                valueAttri0.text = attributes[0].valueAttribute.toString()
            }
        }
        btRemAttri1.setOnClickListener {
            var pointsCurrent = points.text.toString().toIntOrNull() ?: 0

            if (attributes[1].valueAttribute == 8) {
                val toast =
                    Toast.makeText(this, "Não é possível diminuir abaixo de 8", Toast.LENGTH_SHORT)
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            } else {
                pointsCurrent += attributesModel.defineAttributesModel(attributes[1].valueAttribute)
                attributes[1].valueAt--
                pointsCurrent -= attributesModel.defineAttributesModel(attributes[1].valueAttribute)
                points.text = pointsCurrent.toString()
                valueAttri1.text = attributes[1].valueAttribute.toString()
            }
        }
        btRemAttri2.setOnClickListener {
            var pointsCurrent = points.text.toString().toIntOrNull() ?: 0

            if (attributes[2].valueAttribute == 8) {
                val toast =
                    Toast.makeText(this, "Não é possível diminuir abaixo de 8", Toast.LENGTH_SHORT)
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            } else {
                pointsCurrent += attributesModel.defineAttributesModel(attributes[2].valueAttribute)
                attributes[2].valueAt--
                pointsCurrent -= attributesModel.defineAttributesModel(attributes[2].valueAttribute)
                points.text = pointsCurrent.toString()
                valueAttri2.text = attributes[2].valueAttribute.toString()
            }
        }
        btRemAttri3.setOnClickListener {
            var pointsCurrent = points.text.toString().toIntOrNull() ?: 0

            if (attributes[3].valueAttribute == 8) {
                val toast =
                    Toast.makeText(this, "Não é possível diminuir abaixo de 8", Toast.LENGTH_SHORT)
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            } else {
                pointsCurrent += attributesModel.defineAttributesModel(attributes[3].valueAttribute)
                attributes[3].valueAt--
                pointsCurrent -= attributesModel.defineAttributesModel(attributes[3].valueAttribute)
                points.text = pointsCurrent.toString()
                valueAttri3.text = attributes[3].valueAttribute.toString()
            }
        }
        btRemAttri4.setOnClickListener {
            var pointsCurrent = points.text.toString().toIntOrNull() ?: 0

            if (attributes[4].valueAttribute == 8) {
                val toast =
                    Toast.makeText(this, "Não é possível diminuir abaixo de 8", Toast.LENGTH_SHORT)
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            } else {
                pointsCurrent += attributesModel.defineAttributesModel(attributes[4].valueAttribute)
                attributes[4].valueAt--
                pointsCurrent -= attributesModel.defineAttributesModel(attributes[4].valueAttribute)
                points.text = pointsCurrent.toString()
                valueAttri4.text = attributes[4].valueAttribute.toString()
            }
        }
        btRemAttri5.setOnClickListener {
            var pointsCurrent = points.text.toString().toIntOrNull() ?: 0

            if (attributes[5].valueAttribute == 8) {
                val toast =
                    Toast.makeText(this, "Não é possível diminuir abaixo de 8", Toast.LENGTH_SHORT)
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            } else {
                pointsCurrent += attributesModel.defineAttributesModel(attributes[5].valueAttribute)
                attributes[5].valueAt--
                pointsCurrent -= attributesModel.defineAttributesModel(attributes[5].valueAttribute)
                points.text = pointsCurrent.toString()
                valueAttri5.text = attributes[5].valueAttribute.toString()
            }
        }

        btAddAttri0.setOnClickListener {
            var pointsCurrent = points.text.toString().toIntOrNull() ?: 0

            if (attributes[0].valueAttribute == 15) {
                val toast =
                    Toast.makeText(this, "Não é possível aumentar acima de 15", Toast.LENGTH_SHORT)
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            } else {
                pointsCurrent += attributesModel.defineAttributesModel(attributes[0].valueAttribute)
                attributes[0].valueAt++
                pointsCurrent -= attributesModel.defineAttributesModel(attributes[0].valueAttribute)
                if (pointsCurrent >= 0) {
                    points.text = pointsCurrent.toString()
                    valueAttri0.text = attributes[0].valueAttribute.toString()
                } else {
                    val toast =
                        Toast.makeText(this, "Pontos Insuficientes!!", Toast.LENGTH_SHORT)
                    toast.show()

                    Handler(Looper.getMainLooper()).postDelayed({
                        toast.cancel()
                    }, 5000)
                    attributes[0].valueAt--
                }
            }
        }
        btAddAttri1.setOnClickListener {
            var pointsCurrent = points.text.toString().toIntOrNull() ?: 0

            if (attributes[1].valueAttribute == 15) {
                val toast =
                    Toast.makeText(
                        this,
                        "Não é possível aumentar acima de 15",
                        Toast.LENGTH_SHORT
                    )
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            } else {
                pointsCurrent += attributesModel.defineAttributesModel(attributes[1].valueAttribute)
                attributes[1].valueAt++
                pointsCurrent -= attributesModel.defineAttributesModel(attributes[1].valueAttribute)
                if (pointsCurrent >= 0) {
                    points.text = pointsCurrent.toString()
                    valueAttri1.text = attributes[1].valueAttribute.toString()
                } else {
                    val toast =
                        Toast.makeText(this, "Pontos Insuficientes!!", Toast.LENGTH_SHORT)
                    toast.show()

                    Handler(Looper.getMainLooper()).postDelayed({
                        toast.cancel()
                    }, 5000)
                    attributes[1].valueAt--
                }
            }
        }
        btAddAttri2.setOnClickListener {
            var pointsCurrent = points.text.toString().toIntOrNull() ?: 0

            if (attributes[2].valueAttribute == 15) {
                val toast =
                    Toast.makeText(
                        this,
                        "Não é possível aumentar acima de 15",
                        Toast.LENGTH_SHORT
                    )
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            } else {
                pointsCurrent += attributesModel.defineAttributesModel(attributes[2].valueAttribute)
                attributes[2].valueAt++
                pointsCurrent -= attributesModel.defineAttributesModel(attributes[2].valueAttribute)
                if ( pointsCurrent >= 0 ) {
                    points.text = pointsCurrent.toString()
                    valueAttri2.text = attributes[2].valueAttribute.toString()
                } else {
                    val toast =
                        Toast.makeText(this, "Pontos Insuficientes!!", Toast.LENGTH_SHORT)
                    toast.show()

                    Handler(Looper.getMainLooper()).postDelayed({
                        toast.cancel()
                    }, 5000)
                    attributes[2].valueAt--
                }
            }
        }
        btAddAttri3.setOnClickListener {
            var pointsCurrent = points.text.toString().toIntOrNull() ?: 0

            if (attributes[3].valueAttribute == 15) {
                val toast =
                    Toast.makeText(
                        this,
                        "Não é possível aumentar acima de 15",
                        Toast.LENGTH_SHORT
                    )
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            } else {
                pointsCurrent += attributesModel.defineAttributesModel(attributes[3].valueAttribute)
                attributes[3].valueAt++
                pointsCurrent -= attributesModel.defineAttributesModel(attributes[3].valueAttribute)
                if (pointsCurrent >= 0) {
                    points.text = pointsCurrent.toString()
                    valueAttri3.text = attributes[3].valueAttribute.toString()
                } else {
                    val toast =
                        Toast.makeText(this, "Pontos Insuficientes!!", Toast.LENGTH_SHORT)
                    toast.show()

                    Handler(Looper.getMainLooper()).postDelayed({
                        toast.cancel()
                    }, 5000)
                    attributes[3].valueAt--
                }
            }
        }
        btAddAttri4.setOnClickListener {
            var pointsCurrent = points.text.toString().toIntOrNull() ?: 0

            if (attributes[4].valueAttribute == 15) {
                val toast =
                    Toast.makeText(
                        this,
                        "Não é possível aumentar acima de 15",
                        Toast.LENGTH_SHORT
                    )
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            } else {
                pointsCurrent += attributesModel.defineAttributesModel(attributes[4].valueAttribute)
                attributes[4].valueAt++
                pointsCurrent -= attributesModel.defineAttributesModel(attributes[4].valueAttribute)
                if (pointsCurrent >= 0 ) {
                    points.text = pointsCurrent.toString()
                    valueAttri4.text = attributes[4].valueAttribute.toString()
                } else {
                    val toast =
                        Toast.makeText(this, "Pontos Insuficientes!!", Toast.LENGTH_SHORT)
                    toast.show()

                    Handler(Looper.getMainLooper()).postDelayed({
                        toast.cancel()
                    }, 5000)
                    attributes[4].valueAt--
                }
            }
        }
        btAddAttri5.setOnClickListener {
            var pointsCurrent = points.text.toString().toIntOrNull() ?: 0

            if (attributes[5].valueAttribute == 15) {
                val toast =
                    Toast.makeText(
                        this,
                        "Não é possível aumentar acima de 15",
                        Toast.LENGTH_SHORT
                    )
                toast.show()

                Handler(Looper.getMainLooper()).postDelayed({
                    toast.cancel()
                }, 5000)
            } else {
                pointsCurrent += attributesModel.defineAttributesModel(attributes[5].valueAttribute)
                attributes[5].valueAt++
                pointsCurrent -= attributesModel.defineAttributesModel(attributes[5].valueAttribute)
                if (pointsCurrent >= 0) {
                    points.text = pointsCurrent.toString()
                    valueAttri5.text = attributes[5].valueAttribute.toString()
                } else {
                    val toast =
                        Toast.makeText(this, "Pontos Insuficientes!!", Toast.LENGTH_SHORT)
                    toast.show()

                    Handler(Looper.getMainLooper()).postDelayed({
                        toast.cancel()
                    }, 5000)
                    attributes[5].valueAt--
                }
            }
        }
    }
}