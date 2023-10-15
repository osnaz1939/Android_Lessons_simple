package android

import android.app.Application
import android.lessons.simple.clean.domainwithsoa.solid.openclosed.FirstTarget

class App : Application(), IAppProducer {

    override fun onCreate() {
        super.onCreate()
    }

    //IoC
    override fun getNiceProducer(): ITargetNumber {
        return FirstTarget()
        //return SecondTarget()
    }


}