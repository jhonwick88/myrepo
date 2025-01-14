package com.pintarmedia.kamusfarmasi

import android.content.Intent
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.pintarmedia.kamusfarmasi.model.Farmasi
import kotlinx.android.synthetic.main.detail_istilah.*

class DetailIstilah : BaseActivity() {
    lateinit var mAdView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_istilah)
        mAdView = findViewById(R.id.ad_view)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val farmasi = intent.extras?.get("farmasi") as Farmasi
        istilahTV.text = farmasi.istilah
        artiTV.text = farmasi.arti
        val shareIt = farmasi.istilah+"\n"+farmasi.arti+"\n\nShare from: "+Pintar().URL_APP
        copyIstilah.setOnClickListener { copyClipboard(this,shareIt)}
        moreAction.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareIt);
            startActivity(Intent.createChooser(shareIntent,getString(R.string.send_to)))
        }

    }
}
