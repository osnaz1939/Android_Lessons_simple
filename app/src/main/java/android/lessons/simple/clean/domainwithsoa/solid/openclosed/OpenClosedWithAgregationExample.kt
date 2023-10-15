package android.lessons.simple.clean.domainwithsoa.solid.openclosed

import android.ITargetNumber

class OpenClosedWithAgregationExample(private val producer: ITargetNumber) {

    fun getNumberPolymorphic(): Int {
        return producer.getTargetNumber()
    }

}