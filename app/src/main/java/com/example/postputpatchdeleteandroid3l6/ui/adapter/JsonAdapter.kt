package com.example.postputpatchdeleteandroid3l6.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postputpatchdeleteandroid3l6.data.model.Post
import com.example.postputpatchdeleteandroid3l6.databinding.ItemPostBinding

class JsonAdapter : RecyclerView.Adapter<JsonAdapter.JsonViewHolder>() {

    private var jsonList = mutableListOf<Post>()

    fun setJsonList(gsonList: List<Post>) {
        this.jsonList = gsonList.toMutableList()
        notifyDataSetChanged()
    }

    inner class JsonViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(post: Post) = with(binding) {
        tvId.text = post.toString()
            tvTitle.text =  post.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JsonViewHolder {
        return JsonViewHolder(
            ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = jsonList.size

    override fun onBindViewHolder(holder: JsonViewHolder, position: Int) {
        holder.onBind(jsonList[position])
    }
}