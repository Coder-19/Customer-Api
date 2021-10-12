package com.example.customer.routes

import com.example.customer.models.Customer
import com.example.customer.models.customerStorage
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

// the code below is used to create a method for getting the information or registering all the routes in
// a single class for writing a maintainable code


// the code below is used to create a method for registering the customer routes
fun Application.registerCustomerRoutes(){
    // using the routing block to call the function to get the routes for the customer
    routing {
        // the code below is used to call the customer routes method
        customerRoutes()
    }
}






// the code is used to create a function to define the routing endpoints  for our api
fun Route.customerRoutes(){
    // the code below is used to create a customer route
    route("/customer"){
        // the code below is used to create a get section to get the list of all the customers
        get{
            // the code below is used to get the list of all the customers
            // when the user goes to the /customer route
            if(customerStorage.isNotEmpty()){
                // using the call.respond method to return the list of customers
                call.respond(customerStorage)
            } else {
                // if the customer storage is empty then returning the message that no customer is
                // found along with not found status code
                call.respondText("No Customer Found", status = HttpStatusCode.NotFound)

                // the below line of code is for debugging purpose
                print("The response from the api: "+ HttpStatusCode.NotFound)
            }
        }

        // the code below is used to create a get section to get the list of customers based on their id
        get("{id}"){
            // the code below is used to get the value of id entered by the user

            // the code below is used to check that whether the id entered by the user exists or not
            // if the id does not exists then returning the missing text
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing or malformed Id",
                status =  HttpStatusCode.BadRequest,
            )

            // the code below is used to find the id in the customer storage if the id exists
            val customer = customerStorage.find { it.id == id }  ?: return@get call.respondText(
                "No Customer found with $id",
                status = HttpStatusCode.NotFound,
            )

            // the code below is used to repond with the details of the customer if the id of the customer is
            // found
            call.respond(customer)
        }

        // the code below is used to create a post section for handling the post request
        post{
            // the code below is used to recieve the details of the customer and add those to
            // the customer storage
            val customer = call.receive<Customer>()
            customerStorage.add(customer)
            call.respondText("Customer Created Successfully", status = HttpStatusCode.Created)

        }

        // the code below is used to create a delete section to delete the customer based on his id
        delete("{id}") {
            // the code below is used to get the id of the customer
            val customerId = call.parameters["id"] ?: return@delete call.respondText("Unable to delete" , status = HttpStatusCode.BadRequest)

            // the code below is used to check that if the customer with id exists then removing the customer else
            // returning not found
            if(customerStorage.removeIf{it.id == customerId}){
                call.respondText("Customer Removed Successfully", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }
    }
}
