package rs.novotek.domain.util

/**
 * Created by BX on 12/6/2017.
 */
interface SharedPrefsManager {

    fun getVersion(): String?
    fun setVersion(version: String?)

    fun getDatabaseCreated(): Boolean?
    fun setDatabaseCreated(value: Boolean?)

}