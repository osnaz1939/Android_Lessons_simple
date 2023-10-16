package android.lessons.simple.clean.presentation

import android.IAppProducer
import android.content.Intent
import android.lessons.simple.clean.domain.UseCaseFirst
import android.lessons.simple.clean.domain.UseCaseSecond
import android.lessons.simple.clean.domainwithsoa.firstservice.FirstInteractor
import android.lessons.simple.clean.domainwithsoa.patterns.adapter.AudioPlayer
import android.lessons.simple.clean.domainwithsoa.patterns.builder.LessonsBuilder
import android.lessons.simple.clean.domainwithsoa.patterns.facade.ShapeMaker
import android.lessons.simple.clean.domainwithsoa.patterns.iterator.Iterator
import android.lessons.simple.clean.domainwithsoa.patterns.iterator.NameRepository
import android.lessons.simple.clean.domainwithsoa.patterns.observer.BinaryObserver
import android.lessons.simple.clean.domainwithsoa.patterns.observer.OctalObserver
import android.lessons.simple.clean.domainwithsoa.patterns.observer.Subject
import android.lessons.simple.clean.domainwithsoa.patterns.state.LocalContext
import android.lessons.simple.clean.domainwithsoa.patterns.state.StartState
import android.lessons.simple.clean.domainwithsoa.patterns.state.StopState
import android.lessons.simple.clean.domainwithsoa.patterns.strategy.OperationAdd
import android.lessons.simple.clean.domainwithsoa.patterns.strategy.OperationSubstract
import android.lessons.simple.clean.domainwithsoa.patterns.strategy.StrategyContext
import android.lessons.simple.clean.domainwithsoa.secondservice.SecondInteractor
import android.lessons.simple.clean.domainwithsoa.solid.openclosed.OpenClosedWithAgregationExample
import android.lessons.simple.clean.presentation.mvvm.ViewModelExample
import android.lessons.simple.functionalservices.fservicefirst.FirstFunctionality
import android.lessons.simple.functionalservices.fservicesecond.SecondFunctionality
import android.lessons.simple.ui.theme.Android_Lessons_simpleTheme
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer


class MainActivity : ComponentActivity() {

    private val model = ViewModelExample()

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
                    Button(onClick = {
                        startActivity(Intent(this@MainActivity, SecondActivity::class.java))
                    }) {
                        Text(text = "Simple Button")
                    }

                    Button(onClick = {
                        model.buttonClick(" test ")
                    }) {
                        Text(text = "Calc Button")
                    }

                }
            }
        }

        //MVVM observe
        val nameObserver = Observer<String> { theme ->
            Log.e("mvvm ", theme)
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)


        // DI
        val polyNum =
            OpenClosedWithAgregationExample((application as IAppProducer).getNiceProducer()).getNumberPolymorphic()

        Log.e("poly ", "$polyNum")



        demoStrategy()

        demoState()

        demoObserver()

        demoFacade()

        demoAdapter()

        demoIterator()

        demoBuilder()

        cleanWithSoa()

        legacyClean()

        printSOA()
    }
}


fun demoStrategy() {
    var context = StrategyContext(OperationAdd())
    println("10 + 5 = " + context.executeStrategy(10, 5))

    context = StrategyContext(OperationSubstract())
    println("10 - 5 = " + context.executeStrategy(10, 5))
}

fun demoState() {
    val context = LocalContext()

    val startState = StartState()
    startState.doAction(context)

    println(context.getState().toString())

    val stopState = StopState()
    stopState.doAction(context)

    println(context.getState().toString())
}

fun demoObserver() {
    val subject = Subject()

    OctalObserver(subject)
    BinaryObserver(subject)

    println("First state change: 15")
    subject.state = 15
    println("Second state change: 10")
    subject.state = 10
}

fun demoFacade() {
    val shapeMaker = ShapeMaker()

    shapeMaker.drawRectangle()
    shapeMaker.drawSquare()
}

fun demoAdapter() {
    val audioPlayer = AudioPlayer()

    audioPlayer.play("mp3", "test1.mp3")
    audioPlayer.play("mp4", "test2.mp4")
    audioPlayer.play("vlc", "test3.vlc")
    audioPlayer.play("avi", "test4.avi")
}

fun demoIterator() {
    val namesRepository = NameRepository()

    val iter: Iterator = namesRepository.iterator
    while (iter.hasNext()) {
        val name = iter.next() as String
        println("Name : $name")
    }

}

fun demoBuilder() {
    val builder = LessonsBuilder()

    builder.setNum(150)

    builder.printLessons()
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