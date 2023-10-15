package android.lessons.simple.clean.domain

class UtilityUseCase {

    fun sumNumber(number: Int): Int {
        return number + 100
    }

    fun mutateString(theme: String): String {
        return "$theme the best"
    }
}