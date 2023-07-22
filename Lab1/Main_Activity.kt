package com.example.lab1_plataformasmoviles

import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity

/**
 * Lab 1
 * Exploring Enums in Kotlin
 *
 * Fabiola Contreras 22787
 * file: Main_Activity.kt
 */



    enum class Team(){
        Mercedes,
        RedBullRacing,
        Ferrari,
        McLaren,
        AstonMartin,
        Alpine,
        AlphaTauri,
        AlfaRomeo,
        Haas,
        Williams,

    }

    private fun printTeamDetails(team: Team) {
        //Print Team Details
        println("Team name: $team")

        //Switch Statement
        val details = when (team) {
            Team.Mercedes -> "Mercedes: ¡Campeones mundiales de Fórmula 1!"
            Team.RedBullRacing -> "Red Bull Racing: Equipo competitivo con Max Verstappen al volante."
            Team.Ferrari -> "Ferrari: Una de las escuderías más icónicas."
            Team.McLaren -> "McLaren: Combatiendo en la pista con su historia y juventud."
            Team.AstonMartin -> "Aston Martin: El equipo británico regresa a la Fórmula 1."
            Team.Alpine -> "Alpine: Renovado equipo que trae consigo una gran tradición."
            Team.AlphaTauri -> "AlphaTauri: Equipo hermano de Red Bull Racing, impulsando nuevos talentos."
            Team.AlfaRomeo -> "Alfa Romeo: Con una rica historia en el automovilismo, compiten con pasión."
            Team.Haas -> "Haas: Equipo estadounidense en busca de oportunidades y experiencia."
            Team.Williams -> "Williams: Legendario equipo británico en una nueva etapa de desarrollo."
        }

        println(details)
    }



fun main(){ //OnCreate
    val team = Team.Mercedes
    printTeamDetails(team)
}