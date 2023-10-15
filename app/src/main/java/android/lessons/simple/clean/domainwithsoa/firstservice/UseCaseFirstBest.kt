package android.lessons.simple.clean.domainwithsoa.firstservice

import android.lessons.simple.clean.data.repositoryfirst.NiceRepo

class UseCaseFirstBest {

    fun getBestNumberOfLessons(): Int {
        return NiceRepo().getNiceNumber() + 220
    }
}