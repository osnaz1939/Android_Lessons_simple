package android.lessons.simple.clean.presentation

import android.lessons.simple.R
import android.lessons.simple.clean.presentation.mvicustom.ui.MainContract
import android.lessons.simple.clean.presentation.mvicustom.ui.MainViewModel
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope

class ThirdActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
    }

    /**
     * Initialize Observers
     */
    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect {
                when (it.randomNumberState) {
                    is MainContract.RandomNumberState.Idle -> {
                        Log.e("MVI2 ", "state is idle")
                    }

                    is MainContract.RandomNumberState.Loading -> {
                        Log.e("MVI2 ", "state is loading")
                    }

                    is MainContract.RandomNumberState.Success -> {
                        Log.e("MVI2 ", "state is Success")
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.effect.collect {
                when (it) {
                    is MainContract.Effect.ShowToast -> {
                        Log.e("MVI2 ", "effect is show toast")
                        showToast("Error, number is even")
                    }
                }
            }
        }
    }


    /**
     * Show simple toast message
     */
    private fun showToast(message: String) {
        Toast.makeText(this@ThirdActivity, message, Toast.LENGTH_SHORT).show()
    }
}
