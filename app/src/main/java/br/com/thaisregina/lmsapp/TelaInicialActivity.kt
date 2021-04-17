package br.com.thaisregina.lmsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
        val usuario = args?.getString("usuario")
        val numero = args?.getInt("numero")
        val logico_2 = args?.getBoolean("logico_2")

        Toast.makeText(this, usuario, Toast.LENGTH_LONG).show()

        textoTelaInicial.setText("Olá $usuario")

        supportActionBar?.title = "Produtos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
            finish()
        }

        return super.onOptionsItemSelected(item)
    }



}