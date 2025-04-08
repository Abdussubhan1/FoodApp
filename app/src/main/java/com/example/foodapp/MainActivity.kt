package com.example.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val imagesOfItems = arrayOf(
                R.drawable.biryani,
                R.drawable.qorma,
                R.drawable.haleem,
                R.drawable.nihaari,
                R.drawable.chowmein,
                R.drawable.icecream,
                R.drawable.colddrink
            )
            val nameOfItems = arrayOf(
                "CHICKEN/BEEF BIRYANI 480gms",
                "CHICKEN QORMA 250gms",
                "BEEF HALEEM 250gms",
                "NALLI NIHAARI 250gms",
                "CHICKEN CHOWMEIN 250gms",
                "ICECREAM / Cup",
                "COLD DRINK"
            )
            val priceOfItems = arrayOf(
                "PKR 350", "PKR 450", "PKR 200", "PKR 300", "PKR 250", "PKR 120", "PKR 70"
            )





            Food(imagesOfItems, nameOfItems, priceOfItems)
        }
    }
}
@Composable
fun Food(
    imagesOfItems: Array<Int>,
    nameOfItems: Array<String>,
    priceOfItems: Array<String>

) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                "Subhan's Cafe Menu",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 100.dp, top = 10.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                textDecoration = TextDecoration.Underline,
                fontSize = 34.sp
            )
            Spacer(modifier = Modifier.height(50.dp))
            Box(
                modifier = Modifier
                    .width(300.dp)
                    .fillMaxHeight()
            ) {
                LazyColumn {
                    items(imagesOfItems.size) { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            shape = RoundedCornerShape(16.dp),
                            border = BorderStroke(5.dp, Color(0XFFc9c6bf)),
                            elevation = CardDefaults.cardElevation(20.dp)
                        ) {
                            Row {
                                Image(
                                    painter = painterResource(id = imagesOfItems[item]),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.size(100.dp)
                                )
                                Column(modifier = Modifier.padding(vertical = 10.dp)) {
                                    Text(text = nameOfItems[item], fontSize = 18.sp,fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)
                                    Spacer(modifier = Modifier.height(40.dp))
                                    Text(text = priceOfItems[item])
                                }
                            }

                        }
                    }
                }
            }


        }
    }

}


