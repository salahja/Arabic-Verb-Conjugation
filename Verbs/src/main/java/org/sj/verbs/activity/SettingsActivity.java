package org.sj.verbs.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import org.sj.verbs.R;
import org.sj.verbs.utilities.ThemeHelper;

public class SettingsActivity extends BaseActivity implements
        PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new HeaderFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intents = new Intent(this, ConjugatorAct.class);
        //  Intent intents = new Intent(this, ReadingSurahPartActivity.class);
        finish();
        startActivity(intents);



    }
    @Override
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat caller, Preference pref) {

        if(pref.getKey().equals("Exit")) {
            Intent intents = new Intent(this, ConjugatorAct.class);

            finish();
            startActivity(intents);
        }
        return true;
    }


    public static class HeaderFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.verbpreferences, rootKey);

            Preference button = (Preference)getPreferenceManager().findPreference("exitlink");
            if (button != null) {
                button.setOnPreferenceClickListener(arg0 -> {
                    Intent intents = new Intent(getActivity(), ConjugatorAct.class);
                    //  finish();
                    startActivity(intents);

                    return true;
                });
            }
            Preference theme = getPreferenceManager().findPreference("theme");



            ListPreference themePreference = findPreference("theme");
            if (themePreference != null) {
                themePreference.setOnPreferenceChangeListener(
                        (preference, newValue) -> {
                            String themeOption = (String) newValue;


                            ThemeHelper.applyTheme(themeOption);
                            return true;
                        });
            }



        }
    }
}