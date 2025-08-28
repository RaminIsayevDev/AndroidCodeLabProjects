package com.example.learntogetherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogetherapp.ui.theme.LearnTogetherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherAppTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    MainScreen(modifier = Modifier)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val topImage = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = topImage,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(96.dp)
        )

        Text(
            text = stringResource(R.string.jetpack_compose_tutorial),
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Text(
            text = stringResource(R.string.is_a_modern_toolkit),
            fontSize = 23.sp,
            lineHeight = 22.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(10.dp)
                .align(alignment = Alignment.Start)
        )

        Text(
            text = stringResource(R.string.in_this_tutorial),
            fontSize = 23.sp,
            lineHeight = 22.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(10.dp)
                .align(alignment = Alignment.Start)
        )
    }
}

