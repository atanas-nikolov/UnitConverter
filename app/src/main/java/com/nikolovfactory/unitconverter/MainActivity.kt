package com.nikolovfactory.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikolovfactory.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter () {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Here all the UI elements will be stacked below each other
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        //                                    onValueChange = {//Here goes what should happened, when the Value of our OutlinedTextFiled changes})
        OutlinedTextField(value = "", onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box {
                Button(onClick = { /*TODO*/ }) {
                   Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text("Centimeters")}, onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(text = { Text("Meters")}, onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(text = { Text("Feet")}, onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(text = { Text("Millimeters")}, onClick = { /*TODO*/ }
                    )
                    // added 3 more units by me!
                    DropdownMenuItem(text = { Text("Inches")}, onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(text = { Text("Mile")}, onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(text = { Text("Km")}, onClick = { /*TODO*/ })

                }
            }
            // added by me!
            Spacer(modifier = Modifier.width(48.dp))
            Box {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text("Centimeters")}, onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(text = { Text("Meters")}, onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(text = { Text("Feet")}, onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(text = { Text("Millimeters")}, onClick = { /*TODO*/ }
                    )
                    // added 3 more units by me!
                    DropdownMenuItem(text = { Text("Inches")}, onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(text = { Text("Mile")}, onClick = { /*TODO*/ }
                    )
                    DropdownMenuItem(text = { Text("Km")}, onClick = { /*TODO*/ })

                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result:")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}