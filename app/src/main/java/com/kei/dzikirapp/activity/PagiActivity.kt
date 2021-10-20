package com.kei.dzikirapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kei.dzikirapp.adapter.DzikirDoaAdapter
import com.kei.dzikirapp.databinding.ActivityPagiBinding
import com.kei.dzikirapp.model.DataDzikirDoa
import com.kei.dzikirapp.model.DzikirDoa

class PagiActivity : AppCompatActivity() {
    private lateinit var pagiBinding: ActivityPagiBinding
    private var listDzikirPagi: ArrayList<DzikirDoa> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        pagiBinding = ActivityPagiBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(pagiBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        shoeRecycler()
    }

    private fun shoeRecycler() {
        pagiBinding.rvDzikirPagi.setHasFixedSize(true)
        listDzikirPagi.clear()
        listDzikirPagi.addAll(DataDzikirDoa.listDzikirPagi)
        pagiBinding.rvDzikirPagi.layoutManager = LinearLayoutManager(this)
        pagiBinding.rvDzikirPagi.adapter = DzikirDoaAdapter(listDzikirPagi)
    }

    companion object {
        fun getLaunchService(from: Context) = Intent(from, PagiActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}