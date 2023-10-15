package android.lessons.simple.clean.presentation

import android.IAppProducer
import android.lessons.simple.clean.domain.UseCaseFirst
import android.lessons.simple.clean.domain.UseCaseSecond
import android.lessons.simple.clean.domainwithsoa.firstservice.FirstInteractor
import android.lessons.simple.clean.domainwithsoa.secondservice.SecondInteractor
import android.lessons.simple.clean.domainwithsoa.solid.openclosed.OpenClosedWithAgregationExample
import android.lessons.simple.functionalservices.fservicefirst.FirstFunctionality
import android.lessons.simple.functionalservices.fservicesecond.SecondFunctionality
import android.lessons.simple.ui.theme.Android_Lessons_simpleTheme
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_Lessons_simpleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android Lessons Simple")
                }
            }
        }

        // DI
        val polyNum =
            OpenClosedWithAgregationExample((application as IAppProducer).getNiceProducer()).getNumberPolymorphic()

        Log.e("poly ", polyNum.toString())

        cleanWithSoa()

        legacyClean()

        printSOA()
    }
}

fun cleanWithSoa() {
    val bestNum = FirstInteractor().getNiceNum()

    val bestTheme = SecondInteractor().getTheme()

    Log.e("best is ", "$bestNum $bestTheme")
}

fun legacyClean() {
    val numFirst = UseCaseFirst().getNumberOfLessons()

    val niceNumber = UseCaseFirst().getNiceNum()

    val themeFirst = UseCaseSecond().getThemeString()

    Log.e("Clean ", "$numFirst $niceNumber $themeFirst")
}

fun printSOA() {
    val first = FirstFunctionality().getNumber()

    val second = SecondFunctionality().getString()

    Log.e("test functionality: ", "$first + $second")
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