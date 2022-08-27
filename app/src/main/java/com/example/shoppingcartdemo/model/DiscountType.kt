package com.example.shoppingcartdemo.model

sealed class DiscountType {
 object Weekend: DiscountType()
 object Birthday: DiscountType()
 object ProductTypeA: DiscountType()
 object ProductTypeB: DiscountType()
}