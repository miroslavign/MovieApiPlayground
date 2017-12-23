package rs.novotek.movieapiplayground.util

import android.content.Context
import android.content.SharedPreferences
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import rs.novotek.movieapiplayground.util.threadsafeevents.*
import javax.inject.Inject


/**
 * Created by BX on 12/6/2017.
 */
class SharedPrefs(context: Context) {
    init {
        mPref = context.getSharedPreferences(SETTINGS_NAME, Context.MODE_PRIVATE)
        localBus = EventBus()
        localBus?.register(this)
    }

    /**
     * Enum representing your setting names or key for your setting.
     */
    enum class Key {
        /* Recommended naming convention:
         * ints, floats, doubles, longs:
         * SAMPLE_NUM or SAMPLE_COUNT or SAMPLE_INT, SAMPLE_LONG etc.
         *
         * boolean: IS_SAMPLE, HAS_SAMPLE, CONTAINS_SAMPLE
         *
         * String: SAMPLE_KEY, SAMPLE_STR or just SAMPLE
         */
        SAVED_APK_VERSION_KEY,
        DATABASE_CREATED,
        CALLED_FIRST_PARTIAL_FETCH_CONVOS_KEY,
        AUTH_KEYNAME,
        USERID_KEYNAME,
        APP_SYNCED,
        SYNC_IN_PROGRESS,
        FIRST_MESSAGE_SENT_KEYNAME,
        MY_CURRENT_TEAM_ID,
        ACTIVE_INBOX_ID_KEY,
        SAVE_PHOTO_KEY,
        LAST_INSTALLED_DB_VERSION_KEY,
        HAVE_IMPORTED_CONTACTS,
        IS_IMPORTING_CONTACTS,
        FIRST_STATE_AVAILABILITY,
        FIRST_STATE_TEMPLATE,
        FIRST_STATE_ATACH,
        CAN_SEND_MESSAGES_KEY,
        IS_NEW_USER_KEY,
        MIXPANEL_KEY,
        UUID_KEYNAME,
        MY_NEW_NUMBER,
        MY_ORIGINAL_NUMBER,
        MY_NAME,
        MY_EMAIL,
        I_AM_TEAM_ADMIN,
        I_AM_CONTACT_ADMIN,
        STATUS_PAYING,
        STATUS_TRIAL,
        STATUS_PAYING_STRING,
        STATUS_CANCELED,
        HAVE_ASKED_CONTACTS_PERMISSION,
        HAVE_FINISHED_SYNCCONTACTS,
        LAST_ADDR_ID,
        INTRO_PRESENTED_KEYNAME,
        AVATAR_URI,
        AVATAR_SENT,
        EMPTY_AVATAR_URI,
        SUPPORT_CONVO_AVATAR,
        GCM_TOKEN_SENT,
        GCM_TOKEN,
        APP_CONTACT_FORCE_SYNCED,
        RELOG_KEY,
        SIGNATURE_ENA_KEY,
        SIGNATURE_KEY,
        DND_ALL_TIME_KEY,
        DND_SCHEDULE_KEY,
        DND_START_KEY,
        DND_END_KEY,
        WAITING_FOR_MIGRATION,
        DONE_MIGRATION,
        NEW_LOGIN_TOKEN_COMPLETE,
        LIST_SIZE_LIMIT_BANNER_CLOSED,
        LIST_TIP_CLOSED,
        LIST_TIP2_CLOSED,
        CLEARING_DATABASE,
        FEATURE_META_SAVED
    }

    companion object {
        private val SETTINGS_NAME = "default_settings"
        private var sSharedPrefs: SharedPrefs? = null
        private var mPref: SharedPreferences? = null
        private var mEditor: SharedPreferences.Editor? = null
        private var mBulkUpdate = false
        private var localBus: EventBus? = null

        @Inject
        fun getInstance(context: Context): SharedPrefs {
            if (sSharedPrefs == null) {
                sSharedPrefs = SharedPrefs(context.applicationContext)
            }
            return sSharedPrefs as SharedPrefs
        }

        fun unregisterBus() {
            localBus?.unregister(this)
        }
    }

    // STRING
    fun put(key: Key, value: String?) {
        localBus?.post(StringEvent(key.name, value))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: StringEvent) {
        putSafe(event.key, event.value)
    }

    private fun putSafe(key: String, value: String?) {
        synchronized(this) {
            doEdit()
            if (value != null)
                mEditor!!.putString(key, value)
            else
                mEditor!!.remove(key)
            doCommit()
        }
    }

    fun putJsonString(key: String, value: String?) {
        localBus?.post(StringEvent(key, value))
    }
    ///////////////////////


    // INTEGER
    fun put(key: Key, value: Int?) {
        localBus?.post(IntegerEvent(key.name, value))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: IntegerEvent) {
        putSafe(event.key, event.value)
    }

    private fun putSafe(key: String, value: Int?) {
        synchronized(this) {
            doEdit()
            if (value != null)
                mEditor!!.putInt(key, value)
            else
                mEditor!!.remove(key)
            doCommit()
        }
    }
    ///////////////////////


    // BOOLEAN
    fun put(key: Key, value: Boolean?) {
        localBus?.post(BooleanEvent(key.name, value))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: BooleanEvent) {
        putSafe(event.key, event.value)
    }

    private fun putSafe(key: String, value: Boolean?) {
        synchronized(this) {
            doEdit()
            if (value != null)
                mEditor!!.putBoolean(key, value)
            else
                mEditor!!.remove(key)
            doCommit()
        }
    }
    ///////////////////////


    // FLOAT
    fun put(key: Key, value: Float?) {
        localBus?.post(FloatEvent(key.name, value))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: FloatEvent) {
        putSafe(event.key, event.value)
    }

    private fun putSafe(key: String, value: Float?) {
        synchronized(this) {
            doEdit()
            if (value != null)
                mEditor?.putFloat(key, value)
            else
                mEditor?.remove(key)
            doCommit()
        }
    }
    ///////////////////////


    // DOUBLE
    /**
     * Convenience method for storing doubles.
     *
     *
     * There may be instances where the accuracy of a double is desired.
     * SharedPreferences does not handle doubles so they have to
     * cast to and from String.
     *
     * @param key The enum of the preference to store.
     * @param val The new value for the preference.
     */
    fun put(key: Key, value: Double?) {
        localBus?.post(DoubleEvent(key.name, value))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: DoubleEvent) {
        putSafe(event.key, event.value)
    }

    private fun putSafe(key: String, value: Double?) {
        synchronized(this) {
            doEdit()
            if (value != null)
                mEditor?.putString(key, value.toString())
            else
                mEditor?.remove(key)
            doCommit()
        }
    }
    ///////////////////////


    // LONG
    fun put(key: Key, value: Long?) {
        localBus?.post(LongEvent(key.name, value))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: LongEvent) {
        putSafe(event.key, event.value)
    }

    private fun putSafe(key: String, value: Long?) {
        synchronized(this) {
            doEdit()
            if (value != null)
                mEditor?.putLong(key, value)
            else
                mEditor?.remove(key)
            doCommit()
        }
    }
    ///////////////////////


    fun getString(key: Key, defaultValue: String): String? {
        return mPref?.getString(key.name, defaultValue)
    }

    fun getJsonString(key: String, defaultValue: String): String? {
        return mPref?.getString(key, defaultValue)
    }

    fun getString(key: Key): String? {
        return mPref?.getString(key.name, null)
    }

    fun getInt(key: Key): Int? {
        return mPref?.getInt(key.name, 0)
    }

    fun getInt(key: Key, defaultValue: Int): Int? {
        return mPref?.getInt(key.name, defaultValue)
    }

    fun getLong(key: Key): Long? {
        return mPref?.getLong(key.name, 0L)
    }

    fun getLong(key: Key, defaultValue: Long): Long? {
        return mPref?.getLong(key.name, defaultValue)
    }

    fun getFloat(key: Key): Float? {
        return mPref?.getFloat(key.name, 0f)
    }

    fun getFloat(key: Key, defaultValue: Float): Float? {
        return mPref?.getFloat(key.name, defaultValue)
    }

    /**
     * Convenience method for retrieving doubles.
     *
     *
     * There may be instances where the accuracy of a double is desired.
     * SharedPreferences does not handle doubles so they have to
     * cast to and from String.
     *
     * @param key The enum of the preference to fetch.
     */
    fun getDouble(key: Key): Double {
        return getDouble(key, 0.0)
    }

    /**
     * Convenience method for retrieving doubles.
     *
     *
     * There may be instances where the accuracy of a double is desired.
     * SharedPreferences does not handle doubles so they have to
     * cast to and from String.
     *
     * @param key The enum of the preference to fetch.
     */
    private fun getDouble(key: Key, defaultValue: Double): Double {
        try {
            return java.lang.Double.valueOf(mPref?.getString(key.name, defaultValue.toString()))!!
        } catch (nfe: NumberFormatException) {
            return defaultValue
        }

    }

    fun getBoolean(key: Key, defaultValue: Boolean): Boolean? {
        return mPref?.getBoolean(key.name, defaultValue)
    }

    fun getBoolean(key: Key): Boolean? {
        return mPref?.getBoolean(key.name, false)
    }

    /**
     * Remove keys from SharedPreferences.
     *
     * @param keys The enum of the key(s) to be removed.
     */
    fun remove(vararg keys: Key) {
        doEdit()
        for (key in keys) {
            mEditor?.remove(key.name)
        }
        doCommit()
    }

    /**
     * Remove all keys from SharedPreferences.
     */
    fun clear() {
        doEdit()
        mEditor!!.clear()
        doCommit()
    }

    fun edit() {
        mBulkUpdate = true
        mEditor = mPref?.edit()
    }

    fun commit() {
        mBulkUpdate = false
        mEditor?.commit()
        mEditor = null
    }

    private fun doEdit() {
        if (!mBulkUpdate && mEditor == null) {
            mEditor = mPref?.edit()
        }
    }

    private fun doCommit() {
        if (!mBulkUpdate && mEditor != null) {
            mEditor?.commit()
            mEditor = null
        }
    }

}