package br.com.thaisregina.lmsapp

object DisciplinaService {
    fun getDisciplinas(): List<Disciplina>{

        val disciplinas = mutableListOf<Disciplina>()

        for (i in 1..10){
            val d = Disciplina()
            d.nome = "Disciplina $i"
            d.ementa = "Ementa $i"
            d.professor = "Professor $i"
            d.foto = "https://www.oetker.com.br/Recipe/Recipes/oetker.com.br/br-pt/baking/image-thumb__40008__RecipeDetailsLightBox/bolo-de-aniversario-de-chocolate.jpg"
            disciplinas.add(d)
        }
        return  disciplinas

    }

}