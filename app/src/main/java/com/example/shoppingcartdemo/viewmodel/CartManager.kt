package com.example.shoppingcartdemo.viewmodel

import com.example.shoppingcartdemo.R
import com.example.shoppingcartdemo.model.DiscountType
import com.example.shoppingcartdemo.model.Product
import com.example.shoppingcartdemo.model.User

object CartManager{
    var productList:MutableList<Product> = mutableListOf()
    var selectedCartItems:MutableList<Product> = mutableListOf()
    var user = User()

    fun initializeProduct(): MutableList<Product> {
        productList.clear()
        selectedCartItems.clear()
        val productModel = Product.Builder()
            .name("Bag").price(10.0).quantity(1)
            .image(R.drawable.bag).discount(0.1).build()
        productList.add(productModel)

        val productModel1 = Product.Builder()
            .name("Shoe").price(20.0).quantity(1)
            .image(R.drawable.shoe).discount(0.1).build()
       productList.add(productModel1)

        val productModel2 = Product.Builder()
            .name("Springroll").price(30.0).quantity(1)
            .image(R.drawable.springrolls).discount(0.1).build()
       productList.add(productModel2)

        val productModel3 = Product.Builder()
            .name("burger").price(40.0).quantity(1)
            .image(R.drawable.burger).discount(0.1).build()
       productList.add(productModel3)

        val productModel12 = Product.Builder()
            .name("chicken").price(50.0).quantity(1)
            .image(R.drawable.chicken).discount(0.1).build()
       productList.add(productModel12)

        val productModel23 = Product.Builder()
            .name("colddrink").price(60.0).quantity(1)
            .image(R.drawable.colddrink).discount(0.1).build()
       productList.add(productModel23)

        val productModel4 = Product.Builder()
            .name("momos").price(70.0).quantity(1)
            .image(R.drawable.momos).discount(0.1).build()
       productList.add(productModel4)

        val productModel14 = Product.Builder()
            .name("noodles").price(80.0).quantity(1)
            .image(R.drawable.noodles).discount(0.1).build()
       productList.add(productModel14)

        val productModel25 = Product.Builder()
            .name("pizza").price(90.0).quantity(1)
            .image(R.drawable.pizza).discount(0.1).build()
       productList.add(productModel25)

        val productModel5 = Product.Builder()
            .name("roll").price(100.0).quantity(1)
            .image(R.drawable.roll).discount(0.1).build()
       productList.add(productModel5)

        val productModel16 = Product.Builder()
            .name("sandwich").price(200.0).quantity(1)
            .image(R.drawable.sandwich).discount(0.1).build()
       productList.add(productModel16)
        return productList
    }

    fun addProduct(productModel: Product){
        selectedCartItems.add(productModel)
    }

    fun addAllProducts(vararg productModel: Product){
        selectedCartItems.addAll(productModel)
    }

    fun removeProduct(productModel: Product){
        selectedCartItems.remove(productModel)
    }
    fun removeAllProducts(vararg productModel: Product){
        selectedCartItems.removeAll(productModel)
    }

    fun calcTotal():Double{
        var sum = 0.0
        for(item in selectedCartItems){
            val discount = calcProductDiscount(item)
            sum += (item.price!! - (item.price* discount)) * (item.quantity!!)
        }
        return sum
    }

    private fun calcProductDiscount(item: Product): Double {
        var sum = 0.0;
        if(user.birthday.isNotEmpty()){
            sum += 0.3
        }
        if(user.weekend.isNotEmpty()){
            sum += 0.1
        }
        if(item.discount!! > 0){
            sum += item.discount
        }
        return sum
    }
}