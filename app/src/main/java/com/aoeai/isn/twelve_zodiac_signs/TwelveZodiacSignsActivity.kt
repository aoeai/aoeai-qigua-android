package com.aoeai.isn.twelve_zodiac_signs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aoeai.isn.twelve_zodiac_signs.ui.TwelveZodiacSignsView
import com.aoeai.isn.ui.theme.InterstellarNavigatorTheme

class TwelveZodiacSignsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterstellarNavigatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TwelveZodiacSignsView()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun YaoPreview() {
    InterstellarNavigatorTheme {
        TwelveZodiacSignsView()
    }
}