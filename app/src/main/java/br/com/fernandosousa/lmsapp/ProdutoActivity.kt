package br.com.fernandosousa.lmsapp

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
//import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_produto.*
import kotlinx.android.synthetic.main.adapter_produto.*

class ProdutoActivity : DebugActivity() {

    var produto: Produto? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

        // recuperar onjeto de Disciplina da Intent
        produto = intent.getSerializableExtra("produto") as Produto

        // configurar título com nome da Disciplina e botão de voltar da Toobar
        // colocar toolbar
//        setSupportActionBar(toolbar)

        // alterar título da ActionBar
        supportActionBar?.title = produto?.nome

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // atualizar dados da disciplin
        cardNome.text = produto?.nome
//        Picasso.with(this).load(disciplina?.foto).fit().into(imagemDisciplina,
//                object: com.squareup.picasso.Callback{
//                    override fun onSuccess() {}
//
//                    override fun onError() { }
//                })
    }
}
