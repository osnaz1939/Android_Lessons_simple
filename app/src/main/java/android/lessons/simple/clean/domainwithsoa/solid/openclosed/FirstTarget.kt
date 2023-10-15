package android.lessons.simple.clean.domainwithsoa.solid.openclosed

import android.ITargetNumber

class FirstTarget : ITargetNumber {
    override fun getTargetNumber(): Int {
        return 500
    }
}