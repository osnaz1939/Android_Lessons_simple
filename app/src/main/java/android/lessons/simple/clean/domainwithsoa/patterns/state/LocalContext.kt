package android.lessons.simple.clean.domainwithsoa.patterns.state

class LocalContext {
    private var state: State? = null

    fun setState(state: State?) {
        this.state = state
    }

    fun getState(): State? {
        return state
    }
}