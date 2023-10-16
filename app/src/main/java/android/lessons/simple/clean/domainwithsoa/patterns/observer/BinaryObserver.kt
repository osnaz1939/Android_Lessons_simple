package android.lessons.simple.clean.domainwithsoa.patterns.observer

class BinaryObserver(subject: Subject?) :
    Observer() {
    init {
        this.subject = subject
        this.subject!!.attach(this)
    }

    override fun update() {
        println("Binary String: " + Integer.toBinaryString(subject!!.state))
    }
}
