package com.example.shoppingcartdemo.model

/*data class Product(var name:String, var price:Double,
                   var quantity:Int, var image:Int,var discount:Double = 0.0)*/

//Here is Builder pattern
class Product private constructor(
    val name: String?,
    val price: Double?,
    val quantity: Int?,
    val image: Int?,
    val discount: Double?) {

    data class Builder(
        var name: String? = null,
        var price: Double? = null,
        var quantity: Int? = null,
        var image: Int? = null,
        var discount: Double? = null, ) {

        fun name(name: String) = apply { this.name = name }
        fun price(price: Double) = apply { this.price = price }
        fun quantity(quantity: Int) = apply { this.quantity =  quantity}
        fun image(image: Int) = apply { this.image = image }
        fun discount(discount: Double) = apply { this.discount = discount }
        fun build() = Product(name,price,quantity,image,discount)
    }
}