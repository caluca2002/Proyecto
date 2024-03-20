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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////  Inicio  ////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio(
    onNavigateToInicio: () -> Unit,
    onNavigateToCalendario: () -> Unit,
    onNavigateToBusqueda: () -> Unit,
    onNavigateToCreateNota: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor  = MaterialTheme.colorScheme.secondary
            ) {
                IconButton(
                    onClick = onNavigateToBusqueda,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                        .weight(1f)
                ) {
                    Icon(Icons.Default.Search, contentDescription = null)
                }
                IconButton(
                    onClick = onNavigateToCreateNota,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                        .weight(1f)
                ) {
                    Icon(Icons.Default.Add, contentDescription = null)
                }
                IconButton(
                    onClick = onNavigateToCalendario,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                        .weight(1f)
                ) {
                    Icon(Icons.Default.DateRange, contentDescription = null)
                }
            }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row {
                    Text(text = "Inicio")
                }
            }
        }
    )

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////  Calendario  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun Calendario(
    onNavigateToInicio: () -> Unit,
    onNavigateToCalendario: () -> Unit,
    onNavigateToBusqueda: () -> Unit,
    onNavigateToCreateNota: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor  = MaterialTheme.colorScheme.secondary
            ) {
                IconButton(
                    onClick = onNavigateToBusqueda,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                        .weight(1f)
                ) {
                    Icon(Icons.Default.Search, contentDescription = null)
                }
                IconButton(
                    onClick = onNavigateToInicio,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                        .weight(1f)
                ) {
                    Icon(Icons.Default.Home, contentDescription = null)
                }
            }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row {
                    Text(text = "Calendario")
                }
            }
        }
    )
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////  Busqueda  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun Busqueda(
    onNavigateToInicio: () -> Unit,
    onNavigateToCalendario: () -> Unit,
    onNavigateToBusqueda: () -> Unit,
    onNavigateToCreateNota: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor  = MaterialTheme.colorScheme.secondary
            ) {
                IconButton(
                    onClick = onNavigateToCreateNota,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                        .weight(1f)
                ) {
                    Icon(Icons.Default.Add, contentDescription = null)
                }
                IconButton(
                    onClick = onNavigateToInicio,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                        .weight(1f)
                ) {
                    Icon(Icons.Default.Home, contentDescription = null)
                }
                IconButton(
                    onClick = onNavigateToCalendario,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                        .weight(1f)
                ) {
                    Icon(Icons.Default.DateRange, contentDescription = null)
                }
            }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row {
                    Text(text = "Busqueda")
                }
            }
        }
    )
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////  CreateNota  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun CreateNota(
    onNavigateToInicio: () -> Unit,
    onNavigateToCalendario: () -> Unit,
    onNavigateToBusqueda: () -> Unit,
    onNavigateToCreateNota: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor  = MaterialTheme.colorScheme.secondary
            ) {
                IconButton(
                    onClick = onNavigateToBusqueda,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                        .weight(1f)
                ) {
                    Icon(Icons.Default.Search, contentDescription = null)
                }
                IconButton(
                    onClick = onNavigateToInicio,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                        .weight(1f)
                ) {
                    Icon(Icons.Default.Home, contentDescription = null)
                }
                IconButton(
                    onClick = onNavigateToCalendario,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                        .weight(1f)
                ) {
                    Icon(Icons.Default.DateRange, contentDescription = null)
                }
            }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row {
                    Text(text = "CreateNota")
                }
            }
        }
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DailyNoteTheme {
        Text(text = "Hoal")
    }
}