package com.example.order.routes

import com.example.order.models.orderStorage
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

// the code below is used to create a method to create a get request to get the details of the order according
// to the id entered by the user
fun Route.getOrderDetailsById(){
    // the code below  is used to create a get method to get the id of the order and then display the order
    // accordingly else display not found
    get("/order/{id}"){
        // the code below is used to get the access to the id and saving it in a variable called orderId
        val orderId = call.parameters["id"] ?: return@get call.respondText("Bad Request", status =  HttpStatusCode.BadRequest)
        //  the code below is used to first find the id in the order storage and then returning the data to the
        // user else showing not found
        val order = orderStorage.find { it.number == orderId } ?: call.respondText("Not Found", status = HttpStatusCode.NotFound)
        // the code below is used for returning the order details
        call.respond(order)
    }
}