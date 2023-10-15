package android.lessons.simple.clean.domain

import android.lessons.simple.clean.data.repositoryfirst.NiceRepo

class UseCaseSecond {

    fun getThemeString(): String {
        val resultString = NiceRepo().getNiceString()
        return "$resultString${UtilityUseCase().mutateString(resultString)}"
    }
}