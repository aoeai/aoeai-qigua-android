package com.aoeai.qg.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.aoeai.qg.R
import com.aoeai.qg.bagua.BaguaActivity
import com.aoeai.qg.home.data.FunctionKeyDto
import com.aoeai.qg.number.NumberActivity
import com.aoeai.qg.twelve_chinese_zodiac_animals.TwelveChineseZodiacAnimalsActivity
import com.aoeai.qg.twelve_zodiac_signs.TwelveZodiacSignsActivity
import com.aoeai.qg.ui.theme.InterstellarNavigatorTheme

@Composable
fun Home() {

    val keys = listOf(
        FunctionKeyDto(R.drawable.bagua, BaguaActivity::class.java),
        FunctionKeyDto(R.drawable.number, NumberActivity::class.java),
        FunctionKeyDto(R.drawable.twelve_zodiac_signs, TwelveZodiacSignsActivity::class.java),
        FunctionKeyDto(R.drawable.twelve_chinese_zodiac_animals, TwelveChineseZodiacAnimalsActivity::class.java))


    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Set the number of columns to 2
        content = {
            items(keys) { data ->
                FunctionKey(data)
            }
        }
    )
}

@Composable
fun FunctionKey(data: FunctionKeyDto) {
    val packageContext = LocalContext.current
    val image = painterResource(data.resId)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .clickable(onClick = {
                val intent = Intent(packageContext, data.targetActivityCls)
                startActivity(packageContext, intent, null)
            })
    )
}

@Preview
@Composable
fun HomePreview() {
    InterstellarNavigatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Home()
        }
    }
}