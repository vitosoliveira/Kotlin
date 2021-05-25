package br.com.thaisregina.lmsapp

import com.google.gson.GsonBuilder
import java.io.Serializable

class Produtos : Serializable {

    var valor = ""
    var id: Long = 0
    var nome = ""
    var foto = ""

    override fun toString(): String {
        return "produto(nome='$nome')"
    }


    fun toJson():String{
        return GsonBuilder().create().toJson(this)
    }


}