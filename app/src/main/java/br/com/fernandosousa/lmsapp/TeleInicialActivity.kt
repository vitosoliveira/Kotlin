package br.com.fernandosousa.lmsapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class TeleInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this
    private var produtos = listOf<Produto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // acessar parametros da intnet
        // intent é um atributo herdado de Activity
        val args:Bundle? = intent.extras
        // recuperar o parâmetro do tipo String

        val nome = args?.getString("nome")

        // recuperar parâmetro simplificado
        val numero = intent.getIntExtra("nome",0)

        Toast.makeText(context, "Parâmetro: $nome", Toast.LENGTH_LONG).show()
        Toast.makeText(context, "Numero: $numero", Toast.LENGTH_LONG).show()

        // colocar toolbar

        // alterar título da ActionBar
        supportActionBar?.title = "Disciplinas"

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // configurar cardview
        recyclerProdutos?.layoutManager = LinearLayoutManager(context)
        recyclerProdutos?.itemAnimator = DefaultItemAnimator()
        recyclerProdutos?.setHasFixedSize(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
// infla o menu com os botões da ActionBar
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onResume() {
        super.onResume()
        // task para recuperar as disciplinas
        taskProdutos()
    }

    fun taskProdutos() {
        this.produtos = ProdutoService.getProdutos(context)
        // atualizar lista
        recyclerProdutos?.adapter = ProdutoAdapter(produtos) {onClickProduto(it)}
    }

    fun onClickProduto(produto: Produto) {
        Toast.makeText(context, "Clicou disciplina ${produto.nome}", Toast.LENGTH_SHORT).show()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item?.itemId

        if (id == R.id.action_adicionar) {
            Toast.makeText(this, "Botão de adicionar",
                    Toast.LENGTH_LONG).show()

        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Botão de atualizar",

                    Toast.LENGTH_LONG).show()


        }else if (id == R.id.action_sair) {
                finish()

        }
        return super.onOptionsItemSelected(item)
    }

}