package com.example.dedmobile

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.dedmobile.fragment.CharacterFragment1
import com.google.android.material.snackbar.Snackbar

class CharacterActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        val loginName = intent.getStringExtra("LOGIN_NAME")
        val myButton: Button = findViewById(R.id.bt_next)
        myButton.text = loginName

        // Inicializa o FragmentManager
        fragmentManager = supportFragmentManager

        // Adiciona o fragmento à atividade
        if (savedInstanceState == null) {
            val fragment = CharacterFragment1()
            fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // Configuração do Floating Action Button
        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Infla o menu; isso adiciona itens à barra de ação se ela estiver presente.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Manipula cliques em itens da barra de ação
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }
}
