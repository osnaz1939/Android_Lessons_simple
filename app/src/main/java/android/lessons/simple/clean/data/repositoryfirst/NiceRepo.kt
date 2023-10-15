package android.lessons.simple.clean.data.repositoryfirst

import android.lessons.simple.clean.data.repositoryfirst.datasources.DataSourceFirst
import android.lessons.simple.clean.data.repositoryfirst.datasources.DataSourceSecond

class NiceRepo : IRepo {
    override fun getNiceNumber(): Int {
        val first = DataSourceFirst().getNumber()
        val second = DataSourceSecond().getNumber()

        if (first > second) return first
        return second
    }

    override fun getNiceString(): String {
        return " lessons "
    }
}