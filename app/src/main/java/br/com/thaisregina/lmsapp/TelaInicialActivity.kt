package br.com.thaisregina.lmsapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.login.*


class TelaInicialActivity : NavigationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val campo_usuario = Prefs.getString("nome_usuario")
        Toast.makeText(this, "Prefs: ${campo_usuario}", Toast.LENGTH_LONG).show()

        val args = intent.extras
        val usuario = args?.getString("usuario")

        Toast.makeText(this, usuario, Toast.LENGTH_LONG).show()

//        textoTelaInicial.setText("Olá $usuario")

        configuraMenuLateral()
        recycleProdutos?.layoutManager = LinearLayoutManager(this)
        recycleProdutos?.itemAnimator = DefaultItemAnimator()
        recycleProdutos?.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()
        taskProdutos()
    }

    private var produtos = listOf<Produtos>()

    private fun taskProdutos(){

        Thread{
            this.produtos = ProdutosService.getDisciplinas()
            runOnUiThread {
                // Atualizar lista
                recycleProdutos?.adapter = ProdutosAdapter(produtos) {onClickProdutos(it)}
            }
        }.start()
    }

    fun onClickProdutos(produtos: Produtos){

        Toast.makeText(this, "Clicou no produto:  ${produtos.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, Detalhe_produto::class.java)
        intent.putExtra("produto", produtos)
        startActivity(intent)
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