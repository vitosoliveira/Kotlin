package br.com.fernandosousa.lmsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.login.*
import android.widget.Toast as Toast1


class MainActivity :DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        imageview_login.setImageResource(R.drawable.imagem_login)

        botao_login.setOnClickListener(){
            val textoUsuario = campo_usuario.text.toString()
            val textoSenha = campo_senha.text.toString()
            if (textoSenha == "impacta" && textoUsuario == "aluno") {
                Toast1.makeText(this, "clicou no login: $textoUsuario", Toast1.LENGTH_LONG).show()
                var intent = Intent(this, TeleInicialActivity::class.java)
                startActivity(intent)

                var params = Bundle()
                params.putString("Usuario", textoUsuario)

                intent.putExtras(params)
            }else{
                Toast1.makeText(this, "Usuario ou senha invalido", Toast1.LENGTH_LONG).show()

            }



        }


    }
}