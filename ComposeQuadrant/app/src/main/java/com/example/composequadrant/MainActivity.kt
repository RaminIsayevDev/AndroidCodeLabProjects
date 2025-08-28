package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column // Make sure Column is imported
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text // Make sure Text is imported
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight // Make sure FontWeight is imported
import androidx.compose.ui.text.style.TextAlign // Make sure TextAlign is imported
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                MainScreen() // Call your MainScreen composable here
            }
        }
    }
}

@Composable
fun QuadrantCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier // Pass modifier for weight and fillMaxHeight
) {
    Box(
        modifier = modifier // This modifier will come from the parent (Row)
            .background(backgroundColor)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column( // Use a Column to stack title and description
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
                // textAlign = TextAlign.Center // Center is default for Column contentAlignment
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) { // Column to hold the two Rows
        Row(
            modifier = Modifier
                .weight(1f) // This Row takes 1/2 of the available height
                .fillMaxWidth()
        ) {
            QuadrantCard(
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier
                    .weight(1f) // This Box takes 1/2 of the available width in this Row
                    .fillMaxHeight() // Fill the height of the Row
            )
            QuadrantCard(
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier
                    .weight(1f) // This Box takes 1/2 of the available width in this Row
                    .fillMaxHeight() // Fill the height of the Row
            )
        }
        Row(
            modifier = Modifier
                .weight(1f) // This Row takes the other 1/2 of the available height
                .fillMaxWidth()
        ) {
            QuadrantCard(
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier
                    .weight(1f) // This Box takes 1/2 of the available width in this Row
                    .fillMaxHeight() // Fill the height of the Row
            )
            QuadrantCard(
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier
                    .weight(1f) // This Box takes 1/2 of the available width in this Row
                    .fillMaxHeight() // Fill the height of the Row
            )
        }
    }
}
