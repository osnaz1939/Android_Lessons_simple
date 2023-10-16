package android.lessons.simple.clean.presentation.mvvm

import androidx.lifecycle.MutableLiveData

class ViewModelExample {

    private var theme: String

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        theme = "test observe first"
        currentName.postValue(theme)
    }

    fun buttonClick(text: String) {
        theme = "test observe second$text"
        currentName.postValue(theme)
    }
}