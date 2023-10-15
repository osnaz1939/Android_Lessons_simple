package android.lessons.simple.clean.domainwithsoa.firstservice

class FirstInteractor {

    fun getNiceNum(): Int {
        return UseCaseFirstNice().getNumberOfLessons() + FirstUtility().sumNumber(UseCaseFirstBest().getBestNumberOfLessons())
    }
}