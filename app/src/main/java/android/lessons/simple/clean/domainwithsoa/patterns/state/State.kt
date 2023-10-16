package android.lessons.simple.clean.domainwithsoa.patterns.state


interface State {
    fun doAction(context: LocalContext?)
}