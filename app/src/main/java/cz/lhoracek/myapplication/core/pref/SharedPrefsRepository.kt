package cz.lhoracek.myapplication.core.pref

import android.content.Context
import android.content.SharedPreferences

class SharedPrefsRepository constructor(val context: Context, val sharedPreferences: SharedPreferences) :
    ISharedPreferencesRepository {
    companion object {
        const val KEY = "KEY"
    }

    override fun getValue(): String {
        return sharedPreferences.getString(KEY, "defaultUrl")
    }


}