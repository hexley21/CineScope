package org.hxl.cinescope.app

import android.app.Application
import org.hxl.cinescope.di.cinemaModule
import org.hxl.cinescope.di.dataModule
import org.hxl.cinescope.di.domainModule
import org.hxl.cinescope.di.networkModule
import org.hxl.cinescope.di.onboardModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CineScopeApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            if (BuildConfig.DEBUG) {
                androidLogger(Level.DEBUG)
            } else {
                androidLogger(Level.NONE)
            }
            androidContext(this@CineScopeApp)
            modules(
                listOf(
                    dataModule,
                    domainModule,
                    networkModule,
                    onboardModule,
                    cinemaModule
                ))
        }
    }
}