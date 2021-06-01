package br.com.thaisregina.lmsapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {
    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login)

        campo_usuario.setText(Prefs.getString("nome_usuario"))
        campo_senha.setText(Prefs.getString("senha"))
        campo_check.isChecked = Prefs.getBoolean("campo_check")

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
                val valorUsuario = campo_usuario.text.toString()
                val valorString = campo_senha.text.toString()
                val valorCheck = campo_check.isChecked

                Prefs.setBoolean("campo_check", valorCheck)
                if(valorCheck){
                    Prefs.setString("nome_usuario", textoUsuario)
                    Prefs.setString("senha", textoSenha)
                }else {
                    Prefs.setString("nome_usuario", "")
                    Prefs.setString("senha", "")
                }
        }
    }
}