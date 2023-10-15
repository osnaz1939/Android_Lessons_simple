package android.lessons.simple.clean.domainwithsoa.solid.openclosed

import android.ITargetNumber

class SecondTarget : ITargetNumber {
    override fun getTargetNumber(): Int {
        return 750
    }
}