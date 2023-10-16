package android.lessons.simple.clean.domainwithsoa.patterns.facade

class ShapeMaker {
    private val rectangle: Shape
    private val square: Shape

    init {
        rectangle = Rectangle()
        square = Square()
    }

    fun drawRectangle() {
        rectangle.draw()
    }

    fun drawSquare() {
        square.draw()
    }
}