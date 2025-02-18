package com.transak.sample

import KeyValue
import KeyValueAdapter
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.transak.sample.databinding.ActivityDeeplinkBinding

class DeeplinkActivity : AppCompatActivity() {

    private lateinit var viewbinding: ActivityDeeplinkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()

        val data: Uri? = intent?.data

        val orderId = data?.getQueryParameter("orderId")
        val fiatCurrency = data?.getQueryParameter("fiatCurrency")
        val cryptoCurrency = data?.getQueryParameter("cryptoCurrency")
        val fiatAmount = data?.getQueryParameter("fiatAmount")
        val cryptoAmount = data?.getQueryParameter("cryptoAmount")
        val isBuyOrSell = data?.getQueryParameter("isBuyOrSell")
        val status = data?.getQueryParameter("status")
        val walletAddress = data?.getQueryParameter("walletAddress")
        val totalFeeInFiat = data?.getQueryParameter("totalFeeInFiat")
        val network = data?.getQueryParameter("network")

        viewbinding.recyclerView.layoutManager = LinearLayoutManager(this)

        val dataList = listOf(
            KeyValue("orderId", orderId.toString()),
            KeyValue("fiatCurrency", fiatCurrency.toString()),
            KeyValue("cryptoCurrency", cryptoCurrency.toString()),
            KeyValue("fiatAmount", fiatAmount.toString()),
            KeyValue("cryptoAmount", cryptoAmount.toString()),
            KeyValue("isBuyOrSell", isBuyOrSell.toString()),
            KeyValue("status", status.toString()),
            KeyValue("walletAddress", walletAddress.toString()),
            KeyValue("totalFeeInFiat", totalFeeInFiat.toString()),
            KeyValue("network", network.toString()),
        )

        viewbinding.recyclerView.adapter = KeyValueAdapter(dataList)

    }

    private fun initViewBinding() {
        viewbinding = ActivityDeeplinkBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
    }
}