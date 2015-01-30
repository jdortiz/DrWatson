package com.powwau.drwatson;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * 20150130. Initial version created by jorge.
 */
public class AppSettingsActivity extends Activity {
    public static class AppSettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getFragmentManager().beginTransaction().
                add(R.id.settings, new AppSettingsFragment()).
                commit();
    }
}
