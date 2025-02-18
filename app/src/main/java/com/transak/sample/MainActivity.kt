package com.transak.sample

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.webkit.JavascriptInterface
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.transak.sample.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var viewbinding: ActivityMainBinding

    private fun initViewBinding() {
        viewbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()

        viewbinding.transakWidget.run {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            this.addJavascriptInterface(WebAppInterface(this@MainActivity), "Android")
            loadUrl(getTransakWidgetURL())
        }
    }
}

private fun getTransakWidgetURL(): String {
    return "https://global-stg.transak.com?apiKey=YOUR_API_KEY&environment=STAGING"
}

class WebAppInterface(private val context: Context) {
    @JavascriptInterface
    fun postMessage(eventData: String) {
        Log.d("WebViewEvent", "postMessage: $eventData")
        val json = JSONObject(eventData)
        val eventId = json.getString("event_id")
        Toast.makeText(context, eventId, Toast.LENGTH_SHORT).show()
    }
}