package br.com.thaisregina.lmsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login)
        imageView_login.setImageResource(R.drawable.logo)
        botao_login.setOnClickListener {
            val textoUsuario = campo_usuario.text.toString()
            val textoSenha = campo_senha.text.toString()
            if (textoSenha == "impacta" && textoUsuario =="aluno"){
                var intent = Intent(this, TelaInicialActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Usuario ou senha invalido", Toast.LENGTH_LONG).show()

            }


        }
    }
}