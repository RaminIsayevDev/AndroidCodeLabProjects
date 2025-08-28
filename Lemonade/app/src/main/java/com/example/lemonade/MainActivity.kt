package com.example.lemonade

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeImageButton(modifier = Modifier)
}

@Composable
fun LemonadeImageButton(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    // Initialize requiredSqueezes. It will be properly set when moving to step 2.
    var requiredSqueezes by remember { mutableStateOf((2..4).random()) }

    val imageResource = when (currentStep) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val stringResource = when (currentStep) {
        1 -> R.string.lemon_tree
        2 -> R.string.squeeze_it // You might want to update this string or add a new one
        // to indicate remaining squeezes, e.g., "Squeeze (${requiredSqueezes - squeezeCount} left)"
        3 -> R.string.drink_it
        else -> R.string.restart
    }
    // Content description can also be dynamic
    val contentDescription = when (currentStep) {
        1 -> stringResource(R.string.lemon_tree) // Assuming you have these in strings.xml
        2 -> stringResource(R.string.squeeze_it)
        3 -> stringResource(R.string.drink_it)
        else -> stringResource(R.string.restart)
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start, // Changed from CenterHorizontally to Start for the top bar
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Yellow),
        ) {
            Text(
                text = "Lemonade",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(23.dp)
                    .align(Alignment.Center),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize() // This Column will take the rest of the space
                .wrapContentSize(), // Center its content within its bounds
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                when (currentStep) {
                    1 -> {
                        // Transition from tree to squeeze
                        currentStep = 2
                        // Set how many times the lemon needs to be squeezed
                        requiredSqueezes = (2..4).random() // Random number between 2 and 4
                        squeezeCount = 0 // Reset squeeze count for the new lemon
                    }
                    2 -> {
                        // Squeeze the lemon
                        squeezeCount++
                        if (squeezeCount >= requiredSqueezes) {
                            // Enough squeezes, transition to drink
                            currentStep = 3
                        }
                    }
                    3 -> {
                        // Transition from drink to restart
                        currentStep = 4
                    }
                    else -> { // currentStep is 4 (or any other unexpected state)
                        // Transition from restart back to tree
                        currentStep = 1
                    }
                }
            }) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = contentDescription, // Use dynamic content description
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Optionally, display remaining squeezes
            val textToDisplay = if (currentStep == 2) {
                // You can also create a new string resource for this
                "Squeeze the lemon! ${requiredSqueezes - squeezeCount} more squeezes needed."
            } else {
                stringResource(stringResource)
            }

            Text(
                text = textToDisplay,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )
        }
    }
}
