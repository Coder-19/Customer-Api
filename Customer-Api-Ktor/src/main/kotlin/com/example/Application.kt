package com.example
    
import com.example.customer.models.Customer
import com.example.customer.models.customerStorage
import com.example.customer.models.routes.registerCustomerRoutes
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {

        // the code below is used to install the routing feature
        install(Routing){

        }


        // the code below is used to install the content negation to allow the server to examine the
        // accept header to see if the server can serve to the specific type of content or not
        install(ContentNegotiation){
            // the code below is used to enable the json feature of the content negotiation to let
            // us use the @Serializable annotation so as to let the kotlin to know how to seralize
            // the content of the data class associated with @Serializable annotation
            json()
        }



        // the code below is used to call the homeRoute function
        homeRoute()


        // the code below is used to call the customer routing method to get the data
//        routing {
//            customerRouting()
//        }



        // calling the registerCustomerRoutes() method for getting access to all the customer routes
        registerCustomerRoutes()

    }.start(wait = true)
}



// the code below is used to create a function to return hello world when user goes to
// home route
fun Application.homeRoute(){
    routing {
        get("/"){
            // the code below is used to print hello world when the user goes to home route
            call.respondText("Hello Ktor")
        }
    }
}



//// the code is used to create a function to define the routing endpoints  for our api
//fun Route.customerRouting(){
//    // the code below is used to create a customer route
//    route("/customer"){
//        // the code below is used to create a get section to get the list of all the customers
//        get{
//            // the code below is used to get the list of all the customers
//            // when the user goes to the /customer route
//            if(customerStorage.isNotEmpty()){
//                // using the call.respond method to return the list of customers
//                call.respond(customerStorage)
//            } else {
//                // if the customer storage is empty then returning the message that no customer is
//                // found along with not found status code
//                call.respondText("No Customer Found", status = HttpStatusCode.NotFound)
//
//                // the below line of code is for debugging purpose
//                print("The response from the api: "+HttpStatusCode.NotFound)
//            }
//        }
//
//        // the code below is used to create a get section to get the list of customers based on their id
//        get("{id}"){
//            // the code below is used to get the value of id entered by the user
//
//            // the code below is used to check that whether the id entered by the user exists or not
//            // if the id does not exists then returning the missing text
//            val id = call.parameters["id"] ?: return@get call.respondText(
//                "Missing or malformed Id",
//                status =  HttpStatusCode.BadRequest,
//            )
//
//            // the code below is used to find the id in the customer storage if the id exists
//            val customer = customerStorage.find { it.id == id }  ?: return@get call.respondText(
//                "No Customer found with $id",
//                status = HttpStatusCode.NotFound,
//            )
//
//            // the code below is used to repond with the details of the customer if the id of the customer is
//            // found
//            call.respond(customer)
//        }
//
//        // the code below is used to create a post section for handling the post request
//        post{
//            // the code below is used to recieve the details of the customer and add those to
//            // the customer storage
//            val customer = call.receive<Customer>()
//            customerStorage.add(customer)
//            call.respondText("Customer Created Successfully", status = HttpStatusCode.Created)
//
//        }
//
//        // the code below is used to create a delete section to delete the customer based on his id
//        delete("{id}") {
//            // the code below is used to get the id of the customer
//            val customerId = call.parameters["id"] ?: return@delete call.respondText("Unable to delete" , status = HttpStatusCode.BadRequest)
//
//            // the code below is used to check that if the customer with id exists then removing the customer else
//            // returning not found
//            if(customerStorage.removeIf{it.id == customerId}){
//                call.respondText("Customer Removed Successfully", status = HttpStatusCode.Accepted)
//            } else {
//                call.respondText("Not Found", status = HttpStatusCode.NotFound)
//            }
//        }
//    }
//}
