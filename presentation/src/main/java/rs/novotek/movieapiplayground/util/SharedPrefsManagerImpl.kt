/*
 * SharedPrefsManagerImpl.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 12/6/2018
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground.util

import rs.novotek.domain.util.SharedPrefsManager
import android.content.Context

class SharedPrefsManagerImpl(context :Context) : SharedPrefsManager {
    private var prefs: SharedPrefs? = null
    init {
        prefs = SharedPrefs.getInstance(context)
    }

    override fun setVersion(version: String?) {
        prefs?.put(SharedPrefs.Key.SAVED_APK_VERSION_KEY, version)
    }

    override fun getVersion(): String? {
        return prefs?.getString(SharedPrefs.Key.SAVED_APK_VERSION_KEY)
    }

    override fun getDatabaseCreated(): Boolean? {
        return prefs?.getBoolean(SharedPrefs.Key.DATABASE_CREATED)
    }

    override fun setDatabaseCreated(value: Boolean?) {
        prefs?.put(SharedPrefs.Key.DATABASE_CREATED, value)
    }

}