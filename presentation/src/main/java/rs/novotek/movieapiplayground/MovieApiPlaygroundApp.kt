/*
 * MovieApiPlaygroundApp.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 11/30/2017
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground

import android.app.Application
import com.facebook.stetho.Stetho
import rs.novotek.domain.Constants
import rs.novotek.movieapiplayground.di.AppComponent
import rs.novotek.movieapiplayground.di.AppModule
import rs.novotek.movieapiplayground.di.DaggerAppComponent

class MovieApiPlaygroundApp : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }


    /*
    companion object {
        lateinit var component: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
                .application(this)
                .build()
    }
    */


    /*
    private val appComponent: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this, 10, 10,
                        "", false))
                .build()
    }
    */

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
        appComponent =
                DaggerAppComponent
                .builder()
                .appModule(AppModule(this, 10, 10,
                        Constants.API_BASE_URL, false, BuildConfig.IMDB_KEY))
                .build()
        appComponent.inject(this)
    }

}