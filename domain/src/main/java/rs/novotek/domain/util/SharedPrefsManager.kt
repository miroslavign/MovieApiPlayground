/*
 * SharedPrefsManager.java
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 12/6/2017
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.domain.util

interface SharedPrefsManager {

    fun getVersion(): String?
    fun setVersion(version: String?)

    fun getDatabaseCreated(): Boolean?
    fun setDatabaseCreated(value: Boolean?)

}