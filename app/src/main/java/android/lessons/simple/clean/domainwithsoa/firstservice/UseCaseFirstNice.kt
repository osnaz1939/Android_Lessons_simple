package android.lessons.simple.clean.domainwithsoa.firstservice

import android.lessons.simple.clean.data.repositoryfirst.NiceRepo

class UseCaseFirstNice {

    fun getNumberOfLessons(): Int {
        return NiceRepo().getNiceNumber() + 20
    }

}