package android.lessons.simple

import android.lessons.simple.ui.functionalservices.fservicefirst.FirstFunctionality
import android.lessons.simple.ui.functionalservices.fservicesecond.SecondFunctionality
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import android.lessons.simple.ui.theme.Android_Lessons_simpleTheme
import android.util.Log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_Lessons_simpleTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android Lessons Simple")
                }
            }
        }

        val first = FirstFunctionality().getNumber()

        val second = SecondFunctionality().getString()

        Log.e("test functionality: ", "$first + $second")
        
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_Lessons_simpleTheme {
        Greeting("Android Lessons Simple")
    }
}