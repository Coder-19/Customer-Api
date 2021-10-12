package com.example.order.models

import kotlinx.serialization.Serializable
import kotlin.collections.List


// the code below is used to create a dummy list of orders made by the customer
val orderStorage = listOf(
    Order(
        "2020-04-06-01",
        listOf(
            OrderItem("Ham Sandwich", 2, 5.50),
            OrderItem("Water", 1, 1.50),
            OrderItem("Beer", 3, 2.30),
            OrderItem("Cheesecake", 1, 3.75)
        )
    ),
    Order(
        "2020-04-03-01", listOf(
        OrderItem("Cheeseburger", 1, 8.50),
        OrderItem("Water", 2, 1.50),
        OrderItem("Coke", 2, 1.76),
        OrderItem("Ice Cream", 1, 2.35)
        )
    ),
)



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