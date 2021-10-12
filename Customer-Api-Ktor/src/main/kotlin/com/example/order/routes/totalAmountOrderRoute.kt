package com.example.order.routes

import com.example.order.models.orderStorage
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

// the code below is used to create a method for getting the total amount to be payed for a particular order
fun Route.totalAmountOrderRoute(){
    get("order/{id}/total"){
        // the code below is used to get the id entered by the user in the api and if teh id does not exists then
        // showing bad request status
        val orderId = call.parameters["id"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        // the code below is used to find the order by the id in the orderStorage and if there is no data with
        // the particular id then returning not found error
        val order = orderStorage.find { it.number == orderId } ?: return@get call.respondText("Not Found", status = HttpStatusCode.NotFound)
        // the code below is used to map the contents of the order whose id is entered by the user and then totaling
        // the amount and then returning it
        val total = order.content.map { it.price * it.amount }.sum()
        // the code below is used to show the total amount to the user
        call.respond(total)
    }
}