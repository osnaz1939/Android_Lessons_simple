package android.lessons.simple.clean.domainwithsoa.patterns.iterator

interface Iterator {
    operator fun hasNext(): Boolean
    operator fun next(): Any?
}