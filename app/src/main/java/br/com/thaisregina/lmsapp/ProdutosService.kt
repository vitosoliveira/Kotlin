package br.com.thaisregina.lmsapp

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ProdutosService {
    val host = "https://fesousa.pythonanywhere.com"
    val TAG = "WS_LMSAPP"
    fun getDisciplinas (): List<Produtos> {

        val url = "$host/disciplinas"
        val json = HttpHelper.get(url)

        Log.d(TAG,json)
        var disciplinas = parserJson<ArrayList<Produtos>>(json)
        return disciplinas
    }

    fun saveDisciplina(disciplina: Produtos){
        val json = disciplina.toJson()
        HttpHelper.post("$host/disciplinas", json)

    }

    inline fun<reified T> parserJson(json: String): T{
        val type = object : TypeToken<T>(){}.type
        return  Gson().fromJson<T>(json, type)

    }

}