package com.example.lab2

import android.renderscript.ScriptGroup

/*
Laboratorio #2
Fabiola Contreras 22787

file: Laboratorio2.kt
 */

//TAREA 1 Calculo de promedio
fun calcularPromedio(values: List<Int>): Int{
    //Suma todos los elementos de la lista 'values' guardando el resultado en la variable suma
    val suma = values.reduce { acc, num -> acc + num }
    //Devuelve el valor del promedio, tomando la suma de elementos dividido entre la cantidad de ellos
    return suma / values.size
}

//TAREA 2 Guarda solo los números impares desde una lista de enteros
fun extraer_Impares(values: List<Int>): List<Int>{
    //Impares, aquellos que al dividirse dentro de dos tienen un residuo, son extraídos y guardados en un nueva lista
    val newList = values.filter{ it % 2 != 0 }
    return newList //Retorno de la lista
}

//TAREA 3 Comprueba si cada palabra es igual al derecho y al revés, retorna verdadero o falso
fun isPalindrome(data: String): Boolean = data == data.reversed()

//TAREA 4 Añade un saludo al lado de los nombres, dados en la lista, usando map
fun greetings( names: List<String>): List<String> = names.map { "¡Hi $it!" }

//TAREA 5 Hace uso de una funcion superior para realizar una operación matemática básica
fun performOperation(int1: Int = 1, int2:Int = 1, operationFunction: (Int, Int) -> Int): Int{
    //Con la función lambda dada al llamar a esta función se operan los datos y se retorna el valor
    return operationFunction(int1, int2)
}

//TAREA 6 Elaboración de las clases 'Person' y 'Student'
data class Person(val name: String, val age: Int, val gender: String)
data class Student(val name: String, val age: Int, val gender: String, val studentId: String)

//Convierte los datos de un listado de personas a un listado de estudiantes
fun Person_toStudent(people: List<Person>): List<Student>{
    val Estudiantes = people.map { Student(it.name, it.age, it.gender, "Unavailable") }
    return Estudiantes //Retorna el listado de estudiantes
}

fun main(){
    val nums: List<Int> = listOf(1, 2, 3, 4, 5)
    println("~~~~~~ Laboratorio 2 ~~~~~~")
    println("\n1: Calculo de promedio usando 'reduce'")
    println(calcularPromedio(nums))
    println("\n2: Uso de 'filter' para extraer números impares")
    println(extraer_Impares(nums))
    println("\n3: Verificación de Palíndromo")
    println(isPalindrome("oso"))
    println("\n4: Uso de 'map', saludos a nombres")
    println(greetings(listOf("Ana", "Monika", "Majo", "Sofi", "Lili")))
    println("\n5: Higher order function")
    val sum: (Int, Int) -> Int = { a, b -> a + b } //Declara una función para ser usada en la siguiente tarea
    println(performOperation (10, 8, sum))
    println("\n6: Personas a estudiantes")
    val Personas = listOf(
        Person("Nahomy", 18, "Femenino"),
        Person("Diego", 19, "Masculino"),
        Person("Fabiola", 19, "Femenino"),
        Person("Mario", 15, "Masculino"),
        Person("Carlos", 18, "Masculino"),
    )
    for (Est in Person_toStudent(Personas)){
        println("El estudiante ${Est.name} tiene ${Est.age} años")
    }
}