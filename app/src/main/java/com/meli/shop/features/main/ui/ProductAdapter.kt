package com.meli.shop.features.main.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.meli.shop.R
import com.meli.shop.databinding.ProductItemBinding
import com.meli.shop.features.main.data.entity.Product

/**
 * Created by Luis Ordoñez on 11/09/2021.
 */

class ProductAdapter(private val mContext: Context): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private var mProduct: MutableList<Product> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(mContext).load(mProduct[position].thumbnail).fitCenter()
            .into(holder.binding.imageViewPoster)
        holder.binding.title.text = mProduct[position].title
        holder.binding.price.text = String.format(mContext.getString(R.string.price),mProduct[position].price.toString())
        holder.binding.condition.text = mProduct[position].condition

        holder.binding.cardView.setOnClickListener {
            Toast.makeText(mContext, mProduct[position].title, Toast.LENGTH_SHORT).show()
        }
    }

    fun addItem(list: List<Product>) {
        this.mProduct.addAll(list)
        notifyDataSetChanged()
    }

    fun setItems(list: List<Product>) {
        this.mProduct.clear()
        this.mProduct.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val binding = ProductItemBinding.bind(itemView!!)
    }

    override fun getItemCount(): Int {
        return mProduct.size
    }
}