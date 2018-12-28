package com.example.jesustovartrujillo.barbermarket;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment {

    public static final String KEY_PREF_NIGHTMODE = "pref_nightmode";
    public static final String KEY_PREF_USERNAME = "pref_username";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }
}