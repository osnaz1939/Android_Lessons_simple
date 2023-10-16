package android.lessons.simple.clean.domainwithsoa.patterns.state

class StopState : State {
    override fun doAction(context: LocalContext?) {
        println("Player is in stop state")
        context!!.setState(this)
    }

    override fun toString(): String {
        return "Stop State"
    }
}