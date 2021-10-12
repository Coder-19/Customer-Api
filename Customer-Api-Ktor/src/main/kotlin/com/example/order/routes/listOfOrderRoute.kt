package com.example.order.routes

import com.example.order.models.orderStorage
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

// the code below is used to create a method to define a route for getting the list of all the orders when the
// user goes to the /order route
fun Route.listOfOrderRoute(){
    get("/order"){
        // if the orderStorage list is not empty then returning the orderList else showing the error
        // of no data found
        if(orderStorage.isNotEmpty()){
            // the code below is used to return the order list
            call.respond(orderStorage)
        } else {
            // if the orderStorage is empty then returning the error text
            call.respondText("No Orders Found", status = HttpStatusCode.NotFound)
        }
    }
}