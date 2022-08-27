package com.example.shoppingcartdemo.view
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.shoppingcartdemo.R
import com.example.shoppingcartdemo.model.Product
import com.example.shoppingcartdemo.viewmodel.CartManager


class CartAdapter(productList: List<Product>, context: Context?) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    var productList: List<Product>
    var context: Context?
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivProduct.setImageResource(productList[position].image!!)
        holder.ivProduct.setOnClickListener {
            toggleItem(it, position)
        }
    }

    private fun toggleItem(it: View, position: Int) {
        if(!CartManager.selectedCartItems.contains(productList.get(position))) {
            CartManager.addProduct(productList.get(position))
            it.setBackgroundColor(ContextCompat.getColor(it.context, R.color.purple_200))
        }else{
            CartManager.removeProduct(productList.get(position))
            it.setBackgroundColor(ContextCompat.getColor(it.context, R.color.white))
        }
    }

    override fun getItemCount(): Int {
        Log.d("sizecart", productList.size.toString())
        return productList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivProduct: ImageView
        init {
            ivProduct = itemView.findViewById(R.id.ivProduct)
        }
    }

    init {
        this.context = context
        this.productList = productList
    }
}