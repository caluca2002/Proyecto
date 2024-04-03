package com.example.proyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyecto.ui.theme.ProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Inicio()
                }
            }
        }
    }
}


@Composable
fun Inicio() {
    Column {
        Row {
            Text(text = "DailyNote")
        }
        Row {
            LazyColumn(
                modifier = Modifier
                    .padding(vertical = 4.dp)
            ) {}
        }
    }
/*
    BottomAppBar(
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Check, contentDescription = "Localized description")
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Localized description",
                )
            }
        }
    )

 */

}

@Composable
fun ScrollInicio(Cual: Boolean, modifier: Modifier = Modifier,
                 names: List<String> = List(6) { "$it" }){
    LazyColumn(modifier = modifier
        .padding(vertical = 4.dp)
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()
    ) {
        var filled = true
        if (Cual == true) {
            items(items = names) { name ->
                Eventos(name = name, filled)
            }
        } else {
            items(items = names) { name ->
                Notas(name = name, filled)
            }
        }
    }
}

@Composable
private fun Eventos(name: String, filled: Boolean) {
    var estado = remember { mutableStateOf(false) }
}

@Composable
private fun Notas(name: String, filled: Boolean) {}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoTheme {
        Greeting("Android")
    }
}