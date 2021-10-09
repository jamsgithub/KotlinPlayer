package com.myself.kotlinplayer.ui.fragment

import android.os.Bundle
import android.preference.PreferenceFragment
import com.myself.kotlinplayer.R

/**
 * @Created by Jams
 * @Created time 2021/10/5 11:12
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/5 11:12
 * @dese todo
 */
class SettingFragment : PreferenceFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.setting_preference)
    }
}