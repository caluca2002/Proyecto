package com.example.dailynote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dailynote.ui.theme.DailyNoteTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyNoteTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "Inicio") {
                    composable("Inicio") {
                        Inicio(
                            onNavigateToInicio = { navController.navigate("Inicio") },
                            onNavigateToCalendario = { navController.navigate("Calendario") },
                            onNavigateToBusqueda = { navController.navigate("Busqueda") },
                            onNavigateToCreateNota = { navController.navigate("CreateNota") }
                        )
                    }
                    composable("Calendario") {
                        Calendario(
                            onNavigateToInicio = { navController.navigate("Inicio") },
                            onNavigateToCalendario = { navController.navigate("Calendario") },
                            onNavigateToBusqueda = { navController.navigate("Busqueda") },
                            onNavigateToCreateNota = { navController.navigate("CreateNota") }
                        )
                    }
                    composable("Busqueda") {
                        Busqueda(
                            onNavigateToInicio = { navController.navigate("Inicio") },
                            onNavigateToCalendario = { navController.navigate("Calendario") },
                            onNavigateToBusqueda = { navController.navigate("Busqueda") },
                            onNavigateToCreateNota = { navController.navigate("CreateNota") }
                        )
                    }
                    composable("CreateNota") {
                        CreateNota(
                            onNavigateToInicio = { navController.navigate("Inicio") },
                            onNavigateToCalendario = { navController.navigate("Calendario") },
                            onNavigateToBusqueda = { navController.navigate("Busqueda") },
                            onNavigateToCreateNota = { navController.navigate("CreateNota") }
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio(
    onNavigateToInicio: () -> Unit,
    onNavigateToCalendario: () -> Unit,
    onNavigateToBusqueda: () -> Unit,
    onNavigateToCreateNota: () -> Unit
) {
    Column {
        Row {
            Text(text = "Pagina Inicio")
        }
        Row {
            Text(text = "Ir a Inicio")
            IconButton(
                onClick = onNavigateToInicio ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
        Row {
            Text(text = "Ir a calendario")
            IconButton(
                onClick = onNavigateToCalendario ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
        Row {
            Text(text = "Ir a Busqueda")
            IconButton(
                onClick = onNavigateToBusqueda ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
        Row {
            Text(text = "Ir a CreateNota")
            IconButton(
                onClick = onNavigateToCreateNota ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calendario(
    onNavigateToInicio: () -> Unit,
    onNavigateToCalendario: () -> Unit,
    onNavigateToBusqueda: () -> Unit,
    onNavigateToCreateNota: () -> Unit
) {
    Column {
        Row {
            Text(text = "Pagina Calendario")
        }
        Row {
            Text(text = "Ir a Inicio")
            IconButton(
                onClick = onNavigateToInicio ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
        Row {
            Text(text = "Ir a calendario")
            IconButton(
                onClick = onNavigateToCalendario ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
        Row {
            Text(text = "Ir a Busqueda")
            IconButton(
                onClick = onNavigateToBusqueda ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
        Row {
            Text(text = "Ir a CreateNota")
            IconButton(
                onClick = onNavigateToCreateNota ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Busqueda(
    onNavigateToInicio: () -> Unit,
    onNavigateToCalendario: () -> Unit,
    onNavigateToBusqueda: () -> Unit,
    onNavigateToCreateNota: () -> Unit
) {
    Column {
        Row {
            Text(text = "Pagina Busqueda")
        }
        Row {
            Text(text = "Ir a Inicio")
            IconButton(
                onClick = onNavigateToInicio ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
        Row {
            Text(text = "Ir a calendario")
            IconButton(
                onClick = onNavigateToCalendario ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
        Row {
            Text(text = "Ir a Busqueda")
            IconButton(
                onClick = onNavigateToBusqueda ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
        Row {
            Text(text = "Ir a CreateNota")
            IconButton(
                onClick = onNavigateToCreateNota ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
    }
}

@Composable
fun CreateNota(
    onNavigateToInicio: () -> Unit,
    onNavigateToCalendario: () -> Unit,
    onNavigateToBusqueda: () -> Unit,
    onNavigateToCreateNota: () -> Unit
) {
    Column {
        Row {
            Text(text = "Pagina CreateNota")
        }
        Row {
            Text(text = "Ir a Inicio")
            IconButton(
                onClick = onNavigateToInicio ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
        Row {
            Text(text = "Ir a calendario")
            IconButton(
                onClick = onNavigateToCalendario ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
        Row {
            Text(text = "Ir a Busqueda")
            IconButton(
                onClick = onNavigateToBusqueda ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
        Row {
            Text(text = "Ir a CreateNota")
            IconButton(
                onClick = onNavigateToCreateNota ,
                modifier = Modifier
                    .background(
                        Color.Blue,
                        CircleShape
                    )
            ) {
                Icons.Default.DateRange
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DailyNoteTheme {
        Text(text = "Hoal")
    }
}