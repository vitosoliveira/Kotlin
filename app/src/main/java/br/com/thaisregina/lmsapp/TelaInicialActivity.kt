package br.com.thaisregina.lmsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager


class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
        val usuario = args?.getString("usuario")

        Toast.makeText(this, usuario, Toast.LENGTH_LONG).show()

//        textoTelaInicial.setText("Olá $usuario")

        setSupportActionBar(toolbar)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()
        recycleDisciplinas?.layoutManager = LinearLayoutManager(this)
        recycleDisciplinas?.itemAnimator = DefaultItemAnimator()
        recycleDisciplinas?.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()
        taskDisciplinas()
    }

    private var disciplinas = listOf<Disciplina>()

    private fun taskDisciplinas(){

        this.disciplinas = DisciplinaService.getDisciplinas()
        recycleDisciplinas?.adapter = DisciplinaAdapter(disciplinas) {onClickDisciplina(it)}

    }

    fun onClickDisciplina(disciplina: Disciplina){

        Toast.makeText(this, "Clicou na disc ${disciplina.nome}", Toast.LENGTH_SHORT).show()

    }

    private fun configuraMenuLateral(){

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
            }
            R.id.nav_localizacao -> {
                Toast.makeText(this, "Clicou localizacao", Toast.LENGTH_SHORT).show()
            }
        }
        layoutMenuLateral.closeDrawer(GravityCompat.START)

        return true

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // infla o menu com os botões da ActionBar
        menuInflater.inflate(R.menu.menu_main, menu)
        // vincular evento de buscar
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView?)?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                // ação enquanto está digitando
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // ação  quando terminou de buscar e enviou
                return false
            }

        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id == R.id.action_buscar){
            Toast.makeText(this, "Clicou buscar", Toast.LENGTH_SHORT).show()

        }
        else if (id == R.id.action_atualizar){
            Toast.makeText(this, "Clicou atualizar", Toast.LENGTH_SHORT).show()
        }
        else if (id == R.id.action_config){
            val intent = Intent(this, ConfiguracoesActivity::class.java)
            Toast.makeText(this, "Clicou config", Toast.LENGTH_SHORT).show()

            startActivity(intent)
        }
        else if (id == android.R.id.home) {
//            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}