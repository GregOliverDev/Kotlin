package com.example.dedmobile.fragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.dedmobile.R

class CharacterFragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_caracter_1, container, false)

        val characterImage: ImageView = view.findViewById(R.id.character_image)
        characterImage.setImageResource(R.drawable.border_with_character)

        return view
    }
}
