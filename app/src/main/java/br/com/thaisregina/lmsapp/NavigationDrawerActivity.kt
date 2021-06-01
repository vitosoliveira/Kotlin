package br.com.thaisregina.lmsapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

open class NavigationDrawerActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    protected fun configuraMenuLateral(){

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Receitas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()


        menu_lateral.setNavigationItemSelectedListener(this)

    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.nav_receitas -> {
                Toast.makeText(this, "Clicou receitas", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_presentes -> {
                Toast.makeText(this, "Clicou presentes", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_forum -> {
                Toast.makeText(this, "Clicou forum", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, ForumActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_localizacao -> {
                Toast.makeText(this, "Clicou localizacao", Toast.LENGTH_SHORT).show()
            }
        }
        layoutMenuLateral.closeDrawer(GravityCompat.START)

        return true

    }
}