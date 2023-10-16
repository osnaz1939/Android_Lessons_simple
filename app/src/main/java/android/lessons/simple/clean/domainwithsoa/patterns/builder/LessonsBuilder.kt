package android.lessons.simple.clean.domainwithsoa.patterns.builder

import android.util.Log

class LessonsBuilder(
    private val defaultNum: Int = 0,
    private val defaultTheme: String = " lessons "
) : IBuilder {

    private var numLessons = defaultNum
    private var themeLessons = defaultTheme

    override fun setNum(num: Int) {
        numLessons = num
    }

    override fun setTheme(theme: String) {
        themeLessons = theme
    }

    fun printLessons() {
        Log.e("is ", numLessons.toString() + themeLessons)
    }
}