package com.example.cakestore.adapter

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cakestore.CakeDetails
import com.example.cakestore.R
import com.example.cakestore.databinding.CakeShowAdapterBinding
import com.example.cakestore.models.JsonAPIItem
import java.net.URL
class CakeAdapter : RecyclerView.Adapter<CakeAdapter.MyCakeAdapter>() {
    inner class MyCakeAdapter(val binding: CakeShowAdapterBinding): RecyclerView.ViewHolder(binding.root){
    }
    private val diffcallback = object : DiffUtil.ItemCallback<JsonAPIItem>(){
        override fun areItemsTheSame(oldItem: JsonAPIItem, newItem: JsonAPIItem): Boolean {
           return oldItem.title == newItem.title
        }
        override fun areContentsTheSame(oldItem: JsonAPIItem, newItem: JsonAPIItem): Boolean {
          return newItem == oldItem
        }
    }
    private val differ = AsyncListDiffer(this,diffcallback)
    var cakeShow: List<JsonAPIItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCakeAdapter {
        return MyCakeAdapter(CakeShowAdapterBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }
    override fun onBindViewHolder(holder: MyCakeAdapter, position: Int) {
        val currentCake = cakeShow[position]

        if(currentCake.image != null) {
        holder.binding.apply {
            titleText.text = currentCake.title
                imageView.load(currentCake.image) {
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }else{
            holder.binding.apply {
                titleText.text = currentCake.title
                imageView.load(R.mipmap.ic_empty_foreground)
            }
        }
        holder.binding.imageView.setOnClickListener{
            val goto = Intent(it.context,CakeDetails::class.java)
            goto.putExtra("title",currentCake.title)
            goto.putExtra("img",currentCake.image)
            goto.putExtra("desc",currentCake.desc)
            it.context.startActivity(goto)
        }

    }

    override fun getItemCount(): Int {
        return cakeShow.size
    }
}