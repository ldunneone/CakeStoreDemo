package com.example.cakestore

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cakestore.adapter.CakeAdapter
import com.example.cakestore.databinding.ActivityMainBinding
import com.example.cakestore.viewmodel.CakeViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import android.net.NetworkInfo
import org.json.JSONException


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CakeViewModel by viewModels()
    private lateinit var cakeAdapter: CakeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
            if(isOnline()) {
                    setCake()
            }
    }

    private fun setCake() {

            cakeAdapter = CakeAdapter()
            binding.recyclerView.apply {
                adapter = cakeAdapter
                layoutManager = LinearLayoutManager(
                    this@MainActivity, LinearLayoutManager.VERTICAL, false
                )
                setHasFixedSize(true)
            }

            viewModel.responseCake.observe(this, {
                    cakeAdapter.cakeShow = it

            })
    }
    fun isOnline(): Boolean {
        val conMgr =
            applicationContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = conMgr.activeNetworkInfo
        if (netInfo == null || !netInfo.isConnected || !netInfo.isAvailable) {
            binding.errorText.visibility = View.VISIBLE
            binding.errorText.text = "Network Errors"
            binding.errorText.setPadding(16,14,14,14)
            Toast.makeText(this, "No Internet connection!", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}