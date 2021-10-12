package com.example.customer.models

import kotlinx.serialization.Serializable


// the code below is used to create a mutable list of customers
val customerStorage = mutableListOf<Customer>()


// the code below is used to create a file for defining the properties of the customer

// the code below is to use the @Serializable annotation so as to generate the JSON format for
// our api
@Serializable
data class Customer (val id:String,val firstName: String,val lastName: String, val  email:String){
}