package android.lessons.simple.clean.domainwithsoa.patterns.iterator

class NameRepository : Container {
    var names = arrayOf("Robert", "John", "Julie", "Lora")
    override val iterator: Iterator
        get() = NameIterator()

    private inner class NameIterator : Iterator {
        var index = 0
        override fun hasNext(): Boolean {
            return index < names.size
        }

        override fun next(): Any? {
            return if (hasNext()) {
                names[index++]
            } else null
        }
    }
}