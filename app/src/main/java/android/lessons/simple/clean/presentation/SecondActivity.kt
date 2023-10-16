package android.lessons.simple.clean.presentation

import android.content.Intent
import android.lessons.simple.R
import android.lessons.simple.R.id.buttonCalc
import android.lessons.simple.clean.presentation.mvi.MVIExampleViewModel
import android.lessons.simple.clean.presentation.mvi.ViewState
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer


class SecondActivity : AppCompatActivity() {

    private var stateLocal = ViewState(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //MVI observe
        val model = MVIExampleViewModel()

        val nameObserver = Observer<ViewState> { state ->
            renderer(state)
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)


        val buttonGo = findViewById<Button>(R.id.buttonGoToSecond)
        buttonGo.setOnClickListener {
            val myIntent = Intent(this@SecondActivity, ThirdActivity::class.java)
            this@SecondActivity.startActivity(myIntent)
        }

        val buttonCalc = findViewById<Button>(buttonCalc)
        buttonCalc.setOnClickListener {
            model.buttonClick(ViewState(stateLocal.nFirst, stateLocal.nSecond, 750))
        }
    }

    private fun renderer(state: ViewState) {
        stateLocal.nFirst = state.nFirst
        stateLocal.nSecond = state.nSecond
        stateLocal.userVariable = state.userVariable
        Log.e("mvi ", stateLocal.nFirst.toString() + "_" + stateLocal.nSecond.toString())
    }
}