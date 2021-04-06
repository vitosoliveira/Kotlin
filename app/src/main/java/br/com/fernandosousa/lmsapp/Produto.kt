package br.com.fernandosousa.lmsapp

import java.io.Serializable

class Produto: Serializable {

    var id:Long = 0
    var nome = ""
    var valor = ""
    var foto = ""
    var professor = ""

    override fun toString(): String {
        return "Produto(nome='$nome')"
    }
}