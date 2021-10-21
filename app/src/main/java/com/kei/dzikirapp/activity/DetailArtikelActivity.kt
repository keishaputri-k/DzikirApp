package com.kei.dzikirapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kei.dzikirapp.R
import com.kei.dzikirapp.databinding.ActivityDetailArtikelBinding
import com.kei.dzikirapp.model.Artikel

class DetailArtikelActivity : AppCompatActivity() {
    private lateinit var detailArtikelBinding: ActivityDetailArtikelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailArtikelBinding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(detailArtikelBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Artikel Islami"

        val dataArtikel = intent.getParcelableExtra<Artikel>("data")
        detailArtikelBinding.ivDetail.setImageResource(dataArtikel!!.imageArtikel)
        detailArtikelBinding.tvTitleDetail.text = dataArtikel.titleArtikel
        detailArtikelBinding.tvDescDetail.text = dataArtikel.descArtikel
    }
}