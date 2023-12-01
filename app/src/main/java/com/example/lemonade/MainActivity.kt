package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun LemonadeSteps(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Lemonade",
            modifier = Modifier
                .background(Color(0xFFD5DC43))
                .fillMaxWidth()
                .padding(top = 45.dp, bottom = 15.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp

        )


    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        var contador by remember { mutableStateOf(1) }
        var clicksAleatorios by remember { mutableStateOf(2) }
        val imagen = when (contador) {
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart


        }

        val textoImagen = when (contador) {
            1 -> stringResource(id = R.string.tap_lemon_tree)
            2 -> stringResource(id = R.string.tap_lemon_squeeze)
            3 -> stringResource(id = R.string.tap_lemon_drink)
            else -> stringResource(id = R.string.tap_empty_glass)
        }




        Image(
            painter = painterResource(imagen),
            contentDescription = R.string.lemon_tree.toString(),
            modifier = Modifier.clickable {
                if (contador == 1) {

                    clicksAleatorios = (2..4).random()
                    contador += 1

                } else if (contador == 2) {
                    if (clicksAleatorios != 1) {
                        clicksAleatorios--
                    } else {
                        contador += 1
                    }
                } else if (contador == 4) {
                    contador = 1
                } else {
                    contador += 1
                }
            }.clip(RoundedCornerShape(16.dp)).background(Color(0xFFA6DBC8)).size(200.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = textoImagen)


    }


}


@Preview(showBackground = true)
@Composable
fun PrepareLimonadeApp() {
    LemonadeTheme {
        LemonadeSteps(


        )
    }
}