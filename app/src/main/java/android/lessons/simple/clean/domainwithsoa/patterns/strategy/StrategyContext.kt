package android.lessons.simple.clean.domainwithsoa.patterns.strategy

class StrategyContext {
    private var strategy: Strategy? = null

    constructor(strategy: Strategy?) {
        this.strategy = strategy
    }

    fun executeStrategy(num1: Int, num2: Int): Int {
        return strategy!!.doOperation(num1, num2)
    }
}