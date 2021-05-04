package br.com.thaisregina.lmsapp

object ProdutosService {
    fun getProdutos(): List<Produtos>{

        val produtos = mutableListOf<Produtos>()

        for (i in 1..10){
            val d = Produtos()
            d.nome = "Produto $i"
            d.valor = "Valor $i"
            d.foto = "https://www.oetker.com.br/Recipe/Recipes/oetker.com.br/br-pt/baking/image-thumb__40008__RecipeDetailsLightBox/bolo-de-aniversario-de-chocolate.jpg"
            produtos.add(d)
        }
        return  produtos

    }

}