package rs.novotek.movieapiplayground

import android.app.Application
import com.facebook.stetho.Stetho
import dagger.android.DaggerApplication
import rs.novotek.domain.Constants
import rs.novotek.movieapiplayground.di.AppComponent
import rs.novotek.movieapiplayground.di.AppModule
import rs.novotek.movieapiplayground.di.DaggerAppComponent

/**
 * Created by BX on 11/30/2017.
 */
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
                        Constants.API_BASE_URL, false, Constants.AUTH_KEY))
                .build()
        appComponent.inject(this)
    }

}