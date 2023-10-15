package android.lessons.simple.clean.domain

import android.lessons.simple.clean.data.repositoryfirst.NiceRepo

class UseCaseFirst {

    fun getNumberOfLessons(): Int {
        return NiceRepo().getNiceNumber() + 20
    }

    fun getNiceNum(): Int {
        return NiceRepo().getNiceNumber() + UtilityUseCase().sumNumber(NiceRepo().getNiceNumber())
    }
}