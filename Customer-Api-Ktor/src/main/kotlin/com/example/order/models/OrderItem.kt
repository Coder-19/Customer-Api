package com.example.order.models

import kotlinx.serialization.Serializable


// the code below is used to create a data class for getting the details of the item
// that the user will be adding to the order

// the code below is to use the @Serializable annotation so as to generate the JSON format for
// our api
@Serializable
data class OrderItem(
    // the property below is used to get the name of the item
    val name: String,
    // the code below is used to create a proeprty for getting the amount of the item
    val amount: Int,
    // the property below is used to get the total price of the item
    val price: Double,
) {
}