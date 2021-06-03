package br.com.thaisregina.lmsapp

import android.util.Log
import androidx.room.Database
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ProdutosService {
    val host = "https://vso1997.pythonanywhere.com"
    val TAG = "WS_LMSAPP"

    fun getById(id: Int): Produtos {
        val url = "$host/produtos/$id"
        val json = HttpHelper.get(url)
        return parserJson(json)

    }

    fun getProdutos(): List<Produtos> {

        val url = "$host/produtos"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)
        var produtos = parserJson<ArrayList<Produtos>>(json)


        /*     val dao = DatabaseManager.getProdutosDAO()
        val produtos = dao.findAll()*/

        return produtos
    }

    fun save(produtos: Produtos) {
        /*    val json = disciplina.toJson()
        HttpHelper.post("$host/disciplinas", json)
*/
        val dao = DatabaseManager.getProdutosDAO()
        dao.insert(produtos)

    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson<T>(json, type)

    }
}