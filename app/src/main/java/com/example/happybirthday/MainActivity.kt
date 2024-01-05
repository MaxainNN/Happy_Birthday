package com.example.happybirthday

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
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
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    GreetingImage(
                        message = getString(R.string.happy_birthday_text),
                        from = getString(R.string.signature_text)
                    )
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier){
    // Create c column so that texts don't overlap
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 100.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)

        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.androidparty)
    // Step 3 create a box to overlap image and text
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.7f
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    HappyBirthdayTheme {
//        Greeting("Android")
//    }

@Preview(showBackground = false)
@Composable
private fun BirthdayCardPreview(){
    HappyBirthdayTheme {
        GreetingImage(
            message = stringResource(id = R.string.happy_birthday_text),
            from = stringResource(id = R.string.signature_text)
        )
    }
}

