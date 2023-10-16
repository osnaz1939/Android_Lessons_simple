package android.lessons.simple.clean.domainwithsoa.patterns.observer


class Subject {
    private val observers: MutableList<Observer> = ArrayList<Observer>()
    var state = 0
        set(state) {
            field = state
            notifyAllObservers()
        }

    fun attach(observer: Observer) {
        observers.add(observer)
    }

    private fun notifyAllObservers() {
        for (observer in observers) {
            observer.update()
        }
    }
}