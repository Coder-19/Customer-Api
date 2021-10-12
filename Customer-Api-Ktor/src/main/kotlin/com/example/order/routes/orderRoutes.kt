package com.example.order.routes

import io.ktor.application.*
import io.ktor.routing.*

// the code below is used to create a method for registering the order routes
fun Application.registerOrderingRoutes(){
    // using the routing block to register the order routes
    routing {
        // the code below is used to call the list of order route method to get the list of all the orders
        listOfOrderRoute()
        // the code below is used to call the get order details by id method to get the details of the order based
        // on the id
        getOrderDetailsById()
        // the code below is used to call the function total amount order route to get the total amount
        totalAmountOrderRoute()
    }
}
