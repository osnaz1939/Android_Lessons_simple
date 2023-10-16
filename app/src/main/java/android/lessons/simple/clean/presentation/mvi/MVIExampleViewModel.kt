package android.lessons.simple.clean.presentation.mvi

import androidx.lifecycle.MutableLiveData

class MVIExampleViewModel {

    private var theme: ViewState

    val currentName: MutableLiveData<ViewState> by lazy {
        MutableLiveData<ViewState>()
    }

    init {
        theme = ViewState(50, 100, 0)
        currentName.postValue(theme)
    }

    fun buttonClick(state: ViewState) {
        theme = ViewState(1000 + state.userVariable, 5000, 0)
        currentName.postValue(theme)
    }
}