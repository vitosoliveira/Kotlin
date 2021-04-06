package br.com.fernandosousa.lmsapp

import android.content.Context

object ProdutoService {

    fun getProdutos (context: Context): List<Produto> {
        val produto = mutableListOf<Produto>()

        // criar 10 disciplinas
        for (i in 1..10) {
            val d = Produto()
            d.nome = "Produto $i"
            d.valor = "Valor $i"
//            d.professor = "Professor Disciplina $i"
            d.foto = "https://image.freepik.com/fotos-gratis/bolo-de-frutas-de-sobremesa_144627-10487.jpg"
            produto.add(d)
        }

        return produto
    }

}