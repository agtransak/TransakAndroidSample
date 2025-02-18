package com.transak.sample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.transak.sample.databinding.ActivityMainBinding

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
            loadUrl(getTransakWidgetURL())
        }
    }

    private fun getTransakWidgetURL(): String {
        return "https://global-stg.transak.com?apiKey=YOUR_API_KEY&environment=STAGING&redirectURL=app://test/123"
    }

}