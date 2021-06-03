package br.com.thaisregina.lmsapp;

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    val TAG = "LMS_FB"
    override fun onNewToken(token: String?){
        super.onNewToken(token)
        Log.d(TAG,"TOKEN_FB $token")

        Prefs.setString("TOKEN_FB", token!!)
    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage){
        super.onMessageReceived(mensagemRemota)

        if (mensagemRemota?.notification != null){
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body
            Log.d(TAG,"Titulo: $titulo")
            Log.d(TAG, "Corpo: $corpo")

            if(mensagemRemota?.data.isNotEmpty()){
                val produtoID = mensagemRemota.data.get("produtoId")
                Log.d(TAG, "Id da produto $produtoID")
                val d = ProdutosService.getById(produtoID!!.toInt())

                val intent = Intent(this, ProdutoActivity::class.java)
                intent.putExtra("produto", d)
                NotificationUtil.create(1, intent, titulo!!, corpo!!)
            }
        }
    }
}
