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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikolovfactory.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

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

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(1.00) }
    val oConversionFactor = remember { mutableStateOf(1.00) }


    fun convertUnits(){
        // ?: elvis operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0 / oConversionFactor.value).roundToInt() / 100.0
        outputValue = result.toString();

    }




    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Here all the UI elements will be stacked below each other
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        //                                    onValueChange = {//Here goes what should happened, when the Value of our OutlinedTextFiled changes})
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
        }, label = { Text(text = "Enter Value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            //Input Box
            Box {
                //Input Button
                Button(onClick = { iExpanded =true }) {
                   Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(text = { Text("Centimeters")}, onClick = {
                            iExpanded = false
                            inputUnit = "Centimeters"
                            conversionFactor.value = 0.01 // conversionFactor.value = 0.01
                            convertUnits()
                    }
                    )
                    DropdownMenuItem(text = { Text("Meters")}, onClick = {
                        iExpanded = false
                        inputUnit = "Meters"
                        conversionFactor.value = 1.0 // conversionFactor.value = 0.01
                        convertUnits()
                    }
                    )
                    DropdownMenuItem(text = { Text("Feet")}, onClick = {
                        iExpanded = false
                        inputUnit = "Feet"
                        conversionFactor.value = 0.3048 // conversionFactor.value = 0.01
                        convertUnits()
                    }
                    )
                    DropdownMenuItem(text = { Text("Millimeters")}, onClick = {
                        iExpanded = false
                        inputUnit = "Millimeters"
                        conversionFactor.value = 0.001 // conversionFactor.value = 0.01
                        convertUnits()
                    }
                    )
                    // added 3 more units by me!
                    DropdownMenuItem(text = { Text("Inches")}, onClick = {
                        iExpanded = false
                        inputUnit = "Inches"
                        conversionFactor.value = 0.0254 // conversionFactor.value = 0.01
                        convertUnits()
                    }
                    )
                    DropdownMenuItem(text = { Text("Mile")}, onClick = {
                        iExpanded = false
                        inputUnit = "Mile"
                        conversionFactor.value = 1609.34 // conversionFactor.value = 0.01
                        convertUnits()
                    }
                    )
                    DropdownMenuItem(text = { Text("Km")}, onClick = {
                        iExpanded = false
                        inputUnit = "Km"
                        conversionFactor.value = 1000.0 // conversionFactor.value = 0.01
                        convertUnits()
                    }
                    )

                }
            }
            // added by me!
            Spacer(modifier = Modifier.width(16.dp))
            // Output Box
            Box {
                // Output Button
                Button(onClick = { oExpanded = true}) {
                    Text(text = "Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text("Centimeters")}, onClick = {
                        oExpanded = false
                        outputUnit = "Centimeters"
                        conversionFactor.value = 0.01 // conversionFactor.value = 0.01
                        convertUnits()
                    }
                    )
                    DropdownMenuItem(text = { Text("Meters")}, onClick = {
                        oExpanded = false
                        outputUnit = "Meters"
                        conversionFactor.value = 1.0 // conversionFactor.value = 0.01
                        convertUnits()
                    }
                    )
                    DropdownMenuItem(text = { Text("Feet")}, onClick = {
                        oExpanded = false
                        outputUnit = "Feet"
                        conversionFactor.value = 0.3448 // conversionFactor.value = 0.01
                        convertUnits()
                    }
                    )
                    DropdownMenuItem(text = { Text("Millimeters")}, onClick = {
                        oExpanded = false
                        outputUnit = "Millimeters"
                        conversionFactor.value = 0.001 // conversionFactor.value = 0.01
                        convertUnits()
                    }
                    )
                    // added 3 more units by me!
                    DropdownMenuItem(text = { Text("Inches")}, onClick = {
                        oExpanded = false
                        outputUnit = "Inches"
                        conversionFactor.value = 0.0254 // conversionFactor.value = 0.01
                        convertUnits()
                    }
                    )
                    DropdownMenuItem(text = { Text("Mile")}, onClick = {
                        oExpanded = false
                        outputUnit = "Mile"
                        conversionFactor.value = 1609.34 // conversionFactor.value = 0.01
                        convertUnits()
                    }
                    )
                    DropdownMenuItem(text = { Text("Km")}, onClick = {
                        oExpanded = false
                        outputUnit = "Km"
                        conversionFactor.value = 1000.0 // conversionFactor.value = 0.01
                        convertUnits()
                    })

                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result: $outputValue $outputUnit")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}