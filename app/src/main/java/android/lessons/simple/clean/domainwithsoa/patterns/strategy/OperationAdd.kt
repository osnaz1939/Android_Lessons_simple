package android.lessons.simple.clean.domainwithsoa.patterns.strategy

class OperationAdd : Strategy {
    override fun doOperation(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}