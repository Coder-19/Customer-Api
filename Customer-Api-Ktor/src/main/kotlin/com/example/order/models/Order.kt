package com.example.order.models

import kotlinx.serialization.Serializable
import kotlin.collections.List

// the code below is used to create a data class for getting the details of a particular
// order made by the user

// the code below is to use the @Serializable annotation so as to generate the JSON format for
// our api
@Serializable
data class Order(
    // the code below is used to create a property for getting the order number
    val number: String,
    // the code below is used to create a property for getting the list of order made by the user
    val content: List<OrderItem>,
) {
}