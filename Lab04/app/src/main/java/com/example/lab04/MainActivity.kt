/*
* Universidad del Valle de Guatemala
* Programación de Plataformas móviles
* Laboratorio #4
*
* Fabiola Contreras 22787
* 20/08/2023
 */

package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.lab04.ui.theme.Lab04Theme
import coil.compose.AsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab04Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage()
                }
            }
        }
    }
}

data class Recipes(val image: String, val title: String)

@Composable //Recipes list format
fun CustomItem(image: String, title: String) {
    Card(
        modifier = Modifier
            .width(600.dp)
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp)),
    ) {
        Row(
            modifier = Modifier.padding(20.dp).fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AsyncImage(
                model = image,
                contentDescription = null,
                modifier = Modifier
                    .width(75.dp)
                    .height(75.dp)
            )
            Text(
                text = title,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(modifier: Modifier = Modifier) {
    val recipeList = remember { mutableStateListOf<Recipes>() }
    var inputText by remember { mutableStateOf("") }
    var inputURL by remember { mutableStateOf("") }

    Column(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .padding(50.dp, 10.dp)
            .clip(RoundedCornerShape(3.dp))
    ) {

        Text(
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center,
            text = "Healthy Living App (●'◡'●)\n"
        )

        OutlinedTextField(
            value = inputText,
            label = { Text(text = "Nombre de la receta") },
            onValueChange = {
                inputText = it
            }
        )

        OutlinedTextField(
            value = inputURL,
            label = { Text(text = "URL de imagen relacionada") },
            onValueChange = {
                inputURL = it
            }
        )

        Button(onClick = {
            if (inputText != "" && inputURL != "") {
                recipeList.add(Recipes(inputURL, inputText))
                inputText = ""
                inputURL = ""}

        } ) {
            Text(text = "Agregar")
        }

        LazyColumn {
            items(recipeList){ Recipe ->
                CustomItem(image = Recipe.image, title = Recipe.title)
        }
    }


} }
