package com.example.lab1_plataformasmoviles

/**
 * Lab 1
 * Algorithms Using Kotlin
 *
 * Fabiola Contreras 22787
 * file: Exercises
 */

    //Exercise 2
    val vision = ArrayList<Int>() // Create an empty ArrayList of Integers
    fun watching_sunset( buildings: ArrayList<Int>, direction: String ){
        val buildings = buildings //Array with buildings size
        val direction = direction
        var maxB = 0

        if (direction.equals("EAST", ignoreCase = true)){
            for (i in buildings.size - 1 downTo 0){
                if(i+1 == buildings.size){
                    vision.add(i)
                    maxB = buildings[i]
                }else {
                    if (buildings[i] > buildings[i+1] && buildings[i] > maxB){
                        vision.add(i)
                        maxB = buildings[i]
                    }
                }
            }
        } else{
            for (i in buildings.indices){
                if (i == 0){
                    vision.add(i)
                    maxB = buildings[i]
                } else{
                    if (buildings[i] > buildings[i-1] && buildings[i] > maxB){
                        vision.add(i)
                        maxB = buildings[i]
                    }
                }
            }
        }
        vision.sort()
    }

    //Exercise 3
    fun NonRepeating(letters: String){
        var Non_Repeated_Char = '1'
        var index = 0
        var Repetitions = 0

        for (char in letters){
            var Carray = letters.toCharArray()
            var modString = ArrayList(Carray.toList())
            modString.removeAt(index)
            for (char2 in modString){
                if (char == char2) Repetitions++
                if (Repetitions > 0) break
            }
            if (Repetitions == 0) {
                Non_Repeated_Char = char
                break
            } else Repetitions = 0
            index++
        }

        if (Non_Repeated_Char == '1'){
            println("-1// All the characters are repeated")
        } else
        println("1// The first non-repeating character is $Non_Repeated_Char and is found at index $index.")

    }

fun main(){
        //Running Exercise 2
        val build = arrayListOf<Int>(8, 5, 4, 4, 3, 1, 3, 2)
        val direct = "EAST"

        watching_sunset(build, direct)
        println(vision)

        //Exercise 3
        val string = "abcdcaf"
        NonRepeating(string)
    }


