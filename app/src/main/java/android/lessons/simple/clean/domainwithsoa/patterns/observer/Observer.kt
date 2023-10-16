package android.lessons.simple.clean.domainwithsoa.patterns.observer

abstract class Observer {
    protected var subject: Subject? = null
    abstract fun update()
}