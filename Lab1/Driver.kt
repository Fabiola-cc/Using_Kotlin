package com.example.lab1_plataformasmoviles

/**
 * Lab 1
 * Exploring Data Classes in Kotlin
 *
 * Fabiola Contreras 22787
 * file: Driver.kt
 */

data class Driver(var name: String, var team: String, var country: String, var number: Int)
fun main() {
    var driverA = Driver("Lewis Hamilton", "Mercedes", "Reino Unido", 44)
    var driverB = Driver("Max Verstappen", "Red Bull Racing", "Países Bajos", 33)
    var driverC = Driver("Charles Leclerc", "Ferrari", "Mónaco", 16)

    //Printing data
    println("$driverA")
    println("$driverB")
    println("$driverC \n")

    //Equality Check
    if (driverA == driverB){
        println("Using == These variables represent the same driver")
    } else {
        println("Using == These variables represent different drivers")
    }

    if (driverC != driverB){
        println("Using != These variables represent different drivers\n")
    } else {
        println("Using != These variables represent the same driver \n")
    }

    //Copying data
    var driverD = driverA.copy()
    driverD.name = "Valtteri Bottas"
    driverD.number = 77
    println(driverD)
    println("Compare last driver with $driverA \n")

    //Destructing declarations
    val nameC = driverC.name
    val teamC = driverC.team
    val countryC = driverC.country
    val numberC = driverC.number
    println("Copied variables are: $nameC, $teamC, $countryC, $numberC \n")

    //to String() Method
    println(driverA.toString())

}
