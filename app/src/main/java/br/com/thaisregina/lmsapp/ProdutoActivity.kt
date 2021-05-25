package br.com.thaisregina.lmsapp

import android.os.Bundle
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

}