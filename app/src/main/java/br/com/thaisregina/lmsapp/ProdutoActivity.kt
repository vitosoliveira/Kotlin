package br.com.thaisregina.lmsapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_produtos.*
import kotlinx.android.synthetic.main.toolbar.*

class ProdutoActivity: DebugActivity() {
    var produtos: Produtos? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtos)

        // recuperar onjeto de Disciplina da Intent
        produtos = intent.getSerializableExtra("produto") as Produtos

        // configurar título com nome da Disciplina e botão de voltar da Toobar
        // colocar toolbar
        setSupportActionBar(toolbar)

        // alterar título da ActionBar
        supportActionBar?.title = produtos?.nome

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // atualizar dados da disciplina
        nomeProdutos.text = produtos?.nome
        Picasso.with(this).load(produtos?.foto).fit().into(imagemProdutos,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {}

                override fun onError() { }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_produtos, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId
        if  (id == R.id.action_remover) {
            AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("Deseja excluir a disciplina")
                .setPositiveButton("Sim") {
                        dialog, which ->
                    dialog.dismiss()
                    taskExcluir()
                }.setNegativeButton("Não") {
                        dialog, which -> dialog.dismiss()
                }.create().show()
        }
        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun taskExcluir() {
        if (this.produtos != null && this.produtos is Produtos) {
            // Thread para remover a disciplina
            Thread {
                ProdutosService.delete(this.produtos as Produtos)
                runOnUiThread {
                    // após remover, voltar para activity anterior
                    finish()
                }
            }.start()
        }
    }
}
