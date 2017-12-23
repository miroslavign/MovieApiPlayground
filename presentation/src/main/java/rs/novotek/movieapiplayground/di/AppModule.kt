package rs.novotek.movieapiplayground.di

import android.app.Application
import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import rs.novotek.domain.backend.ApiServiceInterceptor
import rs.novotek.domain.backend.RestApi
import rs.novotek.domain.backend.retrofithelper.RetrofitCacheInterceptor
import rs.novotek.domain.util.SchedulerProvider
import rs.novotek.domain.util.SharedPrefsManager
import rs.novotek.movieapiplayground.util.SchedulerProviderImpl
import rs.novotek.movieapiplayground.util.SharedPrefsManagerImpl
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [AppDbModule::class])
class AppModule (private val APP: Application, private val SIZE_OF_CACHE: Long, private val MAX_STALE: Int,
                            private val API_BASE_URL: String, private val IS_DEBUG: Boolean, private val AUTH: String) {

    @Singleton
    @Provides
    fun provideContext(): Context = APP.applicationContext

    @Provides
    @Singleton
    fun provideRestApi(okHttpClient: OkHttpClient, schedulerProvider: SchedulerProvider): RestApi =
            RestApi.newInstance(okHttpClient, schedulerProvider, API_BASE_URL)

    @Provides
    @Singleton
    fun provideOkHttpClient(cacheDir: File, authInterceptor: ApiServiceInterceptor): OkHttpClient {
        // Create Cache
        var cache: Cache? = null
        try {
            cache = Cache(File(cacheDir, "http"), SIZE_OF_CACHE)
        } catch (e: Exception) {
            //Log.e(RestApi.class.getSimpleName(), "Could not create Cache!", e);
        }

        val logging = HttpLoggingInterceptor()
        // set your desired log level
        val level = if (IS_DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        logging.level = level

        // Create OkHttpClient V3
        return OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(authInterceptor)
                //.addInterceptor(new MockResponseInterceptor(Heymarket.instance)) // not like this, avoid context
                .addNetworkInterceptor(StethoInterceptor())
                .addNetworkInterceptor(RetrofitCacheInterceptor(MAX_STALE))
                .addInterceptor(logging)
                .build()
    }

    @Provides
    @Singleton
    fun provideApiServiceInterceptor(): ApiServiceInterceptor {
        return ApiServiceInterceptor.newInstance(AUTH, API_BASE_URL)
    }

    @Provides
    @Singleton
    fun provideCacheDir(context: Context): File {
        return context.cacheDir
    }

    @Provides
    @Singleton
    fun provideAppScheduler(): SchedulerProvider {
        return SchedulerProviderImpl()
    }

    @Provides
    @Singleton
    fun provideSharedPrefsManager(context: Context): SharedPrefsManager {
        return SharedPrefsManagerImpl(context)
    }

}