package br.com.thaisregina.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhe_produto.*

class Detalhe_produto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_produto)

        var produtos = intent.getSerializableExtra("produto") as Produtos


        campo_nome.text = produtos.nome

        Picasso.with(this).load(produtos.foto).fit().into(imagem_produto)
    }

}