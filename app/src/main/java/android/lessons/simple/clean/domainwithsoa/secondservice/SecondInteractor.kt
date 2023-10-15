package android.lessons.simple.clean.domainwithsoa.secondservice

import android.lessons.simple.clean.data.repositoryfirst.NiceRepo

class SecondInteractor {

    fun getTheme(): String {
        val resultString = NiceRepo().getNiceString()
        return "$resultString${SecondUtility().mutateString(resultString)}"
    }
}