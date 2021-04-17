package br.com.thaisregina.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ConfiguracoesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracoes)

        supportActionBar?.title = "Configurações"
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}