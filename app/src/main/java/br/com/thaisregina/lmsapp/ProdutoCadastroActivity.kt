package br.com.thaisregina.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro_produto.*

class ProdutoCadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_produto)
        setTitle("Novo Produto")

        salvarReceita.setOnClickListener {
            val produtos = Produtos()
            produtos.nome = nomeProduto.text.toString()
            produtos.receita = Receita.text.toString()
            produtos.foto = urlFoto.text.toString()

            taskAtualizar(produtos)
        }
    }

    private fun taskAtualizar(produtos: Produtos){
        //Thread salvar receita
        Thread {
            ProdutosService.save(produtos)
            runOnUiThread {
                // Apos cadastrar, voltar para activity anterior
                finish()
            }
        }.start()
    }
}