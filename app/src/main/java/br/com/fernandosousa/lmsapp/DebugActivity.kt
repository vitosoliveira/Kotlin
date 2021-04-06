package br.com.fernandosousa.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class DebugActivity : AppCompatActivity() {
    private val TAG = "LMSApp"
    private val classname: String
        get() {
            val c = javaClass.name
            return c.substring(c.lastIndexOf("."))
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$classname.oncreate() chamado")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$classname.onStart() chamada")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "$classname.onRestart() chamada")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$classname.onResume() chamada")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$classname.onPause() chamada")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$classname.onStop() chamada")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$classname.onDestroy() chamada")

    }
}

