package com.example.dailynote


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "17 - 02 - 2022",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(16.dp)
                )
                Text(
                    text = "Eventos",
                    fontSize = 22.sp,
                    color = Color.White,
                    modifier = Modifier
                        .background(
                            Color.Blue,
                            CircleShape
                        )
                        .padding(20.dp, 5.dp)
                )
                ScrollEvento()
                Text(
                    text = "Notas",
                    fontSize = 22.sp,
                    color = Color.White,
                    modifier = Modifier
                        .background(
                            Color.Blue,
                            CircleShape
                        )
                        .padding(20.dp, 5.dp)
                )
                ScrollNotas()
            }
        }
    )
}

@Composable
private fun ScrollEvento( modifier: Modifier = Modifier,
                          names: List<String> = List(6) { "$it" }) {
    LazyColumn(modifier = modifier
        .padding(vertical = 4.dp)
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()) {
        var filled = true
        items(items = names) { name ->
            ContenidoEvento(name = name, filled)
        }
    }
}

@Composable
private fun ContenidoEvento(name: String, filled: Boolean) {
    var estado = remember { mutableStateOf(false) }

    if (name == "0") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Cableado estructurado\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Hemos diseñado y ordenado los cables de un aula de informática y colocado unas canaletas en unas mesas para ordenar los cables.")
                    }
                }
            }


        }
    } else if (name == "1") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Diseño de página web\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "El Lenguaje de Marcado de Hipertexto (HTML) es el código que se utiliza para estructurar y desplegar una página web y sus contenidos. Por ejemplo, sus contenidos podrían ser párrafos, una lista con viñetas, o imágenes y tablas de datos.")
                    }
                }
            }
        }
    } else {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Formación en centros de trabajo\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Vamos a estar 2 meses y medio trabajando en empresas para obtener experiencia laboral.")
                    }
                }
            }
        }
    }
}


@Composable
private fun ScrollNotas( modifier: Modifier = Modifier,
                         names: List<String> = List(6) { "$it" }) {
    LazyColumn(modifier = modifier
        .padding(vertical = 4.dp)
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()) {
        var filled = true
        items(items = names) { name ->
            ContenidoNotas(name = name)
        }
    }
}

@Composable
private fun ContenidoNotas(name: String) {
    var estado = remember { mutableStateOf(false) }

    if (name == "0") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Cableado estructurado\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Hemos diseñado y ordenado los cables de un aula de informática y colocado unas canaletas en unas mesas para ordenar los cables.")
                    }
                }
            }


        }
    } else if (name == "1") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Diseño de página web\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "El Lenguaje de Marcado de Hipertexto (HTML) es el código que se utiliza para estructurar y desplegar una página web y sus contenidos. Por ejemplo, sus contenidos podrían ser párrafos, una lista con viñetas, o imágenes y tablas de datos.")
                    }
                }
            }
        }
    } else {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .fillMaxSize()
            ) {
                Row {

                    Text(text = "Formación en centros de trabajo\n", modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = { estado.value = !estado.value }
                    ) {
                        Text(if (estado.value) "▲" else "▼")
                    }

                }
                if (estado.value == true) {
                    Row(modifier = Modifier.paddingFromBaseline(
                        top = 30.dp)){
                        Text(text = "Vamos a estar 2 meses y medio trabajando en empresas para obtener experiencia laboral.")
                    }
                }
            }
        }
    }
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
            var searchText by remember { mutableStateOf("") }
            var searchedText by remember { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        modifier = Modifier.weight(1f),
                        label = { Text("Ingrese su búsqueda") }
                    )
                    Button(
                        onClick = {
                            searchedText = searchText
                        },
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text("Enter")
                    }
                }
                Row {
                    Text("Haz buscado: ")
                    Text(searchedText)
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
            var searchText1 by remember { mutableStateOf("") }
            var searchText2 by remember { mutableStateOf("") }
            var searchText3 by remember { mutableStateOf("") }
            var searchText4 by remember { mutableStateOf("") }
            var searchedText by remember { mutableStateOf("") }


            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(3) {
                    TextField(
                        value = when (it) {
                            0 -> searchText1
                            1 -> searchText2
                            else -> searchText3
                        },
                        onValueChange = { newValue ->
                            when (it) {
                                0 -> searchText1 = newValue
                                1 -> searchText2 = newValue
                                else -> searchText3 = newValue
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Ingrese su búsqueda") }
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextField(
                        value = searchText4,
                        onValueChange = { searchText4 = it },
                        modifier = Modifier.weight(1f),
                        label = { Text("Ingrese su búsqueda") }
                    )
                    Button(
                        onClick = {
                            searchedText = searchText4
                        },
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text("Enter")
                    }
                }
                Row {
                    Text("Haz buscado: ")
                    Text(searchedText)
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