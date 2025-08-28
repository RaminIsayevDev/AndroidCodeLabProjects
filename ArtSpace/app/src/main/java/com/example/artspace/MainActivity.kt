package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                ) {
                    AppSpacelayout()
                }
            }
        }
    }
}

@Composable
fun AppSpacelayout() {
    var currentImage by remember { mutableStateOf(1) }
    val imageResource = when (currentImage) {
        1 -> R.drawable.resource__
        2 -> R.drawable.dream_life
        else -> R.drawable.parisian_nightscape
    }
    val stringTitleResource = when (currentImage) {
        1 -> R.string.BMW_title
        2 -> R.string.Porsche_title
        else -> R.string.paris_title
    }
    val stringArtistResource = when (currentImage) {
        1 -> R.string.BMW_artist
        2 -> R.string.Porsche_artist
        else -> R.string.paris_artist
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(all = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "Image provided",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(5.dp)
                .scale(1F)
                .size(500.dp),
        )

        Spacer(modifier = Modifier.padding(30.dp))

        Text(text = stringResource(stringTitleResource),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 30.sp)
        Text(text = stringResource(stringArtistResource),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                if (currentImage > 1 && currentImage <= 3) {
                    currentImage--
                } else {
                    currentImage = 3
                }
            },
                modifier = Modifier
                    .size(width = 110.dp, height = 50.dp)) {
                Text(text = "Previous")
            }
            Button(onClick = {
                if (currentImage < 3 && currentImage >= 1) {
                    currentImage++
                } else {
                    currentImage = 1
                }
            },
                modifier = Modifier
                    .size(width = 110.dp, height = 50.dp)) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppSpaceLayoutPreview() {
    ArtSpaceTheme {
        AppSpacelayout()
    }
}