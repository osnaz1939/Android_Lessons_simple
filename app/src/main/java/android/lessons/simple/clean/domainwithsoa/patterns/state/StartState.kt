package android.lessons.simple.clean.domainwithsoa.patterns.state

class StartState : State {

    override fun doAction(context: LocalContext?) {
        println("Player is in start state")
        context!!.setState(this)
    }

    override fun toString(): String {
        return "Start State"
    }
}