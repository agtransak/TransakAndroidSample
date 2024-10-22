package com.transak.sample

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init webview
        val webView: WebView = findViewById(R.id.transakWidget);
        webView.getSettings().setJavaScriptEnabled(true)
        webView.settings.domStorageEnabled = true
        webView.loadUrl("url here")
    }

}