package br.com.thaisregina.lmsapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "produtos")
class Produtos : Serializable {

    @PrimaryKey
    var valor = ""
    var id: Long? = null
    var nome = ""
    var foto = ""
    var receita = ""

    override fun toString(): String {
        return "Produtos(nome='$nome')"
    }


    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}