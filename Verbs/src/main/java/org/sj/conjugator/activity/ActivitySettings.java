package org.sj.conjugator.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SeekBarPreference;

import org.sj.conjugator.fragments.FontQuranListDialogFragment;
import org.sj.conjugator.fragments.ThemeListPrefrence;
import org.sj.verbs.R;

public class ActivitySettings extends BaseActivity implements
        PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {
    static final String SHARED_PREFERENCE_EDITOR_NAME = "shared_pref_name";
    static final String SHARED_PREFERENCE_SEEKBAR_VALUE = "seek_value";
    private static final String TAG = ActivitySettings.class.getSimpleName();
    private static final String TITLE_TAG = "settingsActivityTitle";
    // RelativeLayout layoutBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        //    backa=findViewById(R.id.back);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new HeaderFragment())
                    .commit();
        } else {
            setTitle(savedInstanceState.getCharSequence(TITLE_TAG));
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save current activity title so we can set it again after a configuration change
        outState.putCharSequence(TITLE_TAG, getTitle());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent readingintent = getIntent();
        finish();
        startActivity(readingintent);

    }

   @NonNull
    public Intent getIntent() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("lastread", MODE_PRIVATE);
//        String surahname = pref.getString(SURAH_ARABIC_NAME, "");
        Intent readingintent = new Intent(this, ConjugatorAct.class);
/*        readingintent.putExtra(MUFRADATFRAGTAG, false);
        readingintent.putExtra(CHAPTER, pref.getInt(CHAPTER, 1));
        readingintent.putExtra(AYAH_ID, pref.getInt(AYAH_ID, 1));
        readingintent.putExtra(SURAH_ARABIC_NAME, surahname);*/
        return readingintent;
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (getSupportFragmentManager().popBackStackImmediate()) {
            return true;
        }
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onPreferenceStartFragment(@NonNull PreferenceFragmentCompat caller, Preference pref) {



        if(pref.getKey().equals("themepref")){
            ThemeListPrefrence item = new ThemeListPrefrence();
            //    item.setdata(rootWordMeanings,wbwRootwords,grammarRootsCombined);
            FragmentManager fragmentManager = ActivitySettings.this.getSupportFragmentManager();


            @SuppressLint("CommitTransaction") FragmentTransaction transactions = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_slide_in_top, android.R.anim.fade_out);
            transactions.show(item);
            ThemeListPrefrence.newInstance().show(ActivitySettings.this.getSupportFragmentManager(), "theme");
            setTitle(pref.getTitle());
        }else    if (pref.getKey().equals("Arabic_Font_Selection")) {
            // Instantiate the new Fragment
            FontQuranListDialogFragment item = new FontQuranListDialogFragment();
            //    item.setdata(rootWordMeanings,wbwRootwords,grammarRootsCombined);
            FragmentManager fragmentManager = ActivitySettings.this.getSupportFragmentManager();

            @SuppressLint("CommitTransaction") FragmentTransaction transactions = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_slide_in_top, android.R.anim.fade_out);
            transactions.show(item);
            FontQuranListDialogFragment.newInstance().show(ActivitySettings.this.getSupportFragmentManager(), "Font");
            setTitle(pref.getTitle());

        } else if (pref.getKey().equals("Exit")) {
            Intent readingintent = getIntent();
            finish();
            startActivity(readingintent);
        }
        return true;
    }

    public static class HeaderFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences, rootKey);
            Preference button = (Preference) getPreferenceManager().findPreference("exitlink");
       if (button != null) {
                button.setOnPreferenceClickListener(arg0 -> {
                    Intent intents = new Intent(getActivity(), ConjugatorAct.class);
                    //  finish();
                    startActivity(intents);
                    return true;
                });
            }

    /*        if (button != null) {
                button.setOnPreferenceClickListener(arg0 -> {
                    Intent mintents = new Intent(getActivity(), ConjugatorAct.class);

                    //  finish();
                    startActivity(mintents);
                    return true;
                });
            }
*/

            SeekBarPreference fetchBar = (SeekBarPreference) findPreference("pref_seekbar_key");
            if (fetchBar != null) {
                fetchBar.setOnPreferenceChangeListener((preference, newValue) -> {
                    if (newValue instanceof Integer) {
                        int newValueInt;
                        try {
                            newValueInt = (Integer) newValue;
                        } catch (NumberFormatException nfe) {
                            Log.e(TAG,
                                    "SeekBarPreference is a Integer, but it caused a NumberFormatException");
                            return false;
                        }

                        final SharedPreferences.Editor editor =
                                preference.getContext().getSharedPreferences(SHARED_PREFERENCE_EDITOR_NAME, Context.MODE_PRIVATE).edit();
                        editor.putInt(SHARED_PREFERENCE_SEEKBAR_VALUE, newValueInt);
                        editor.apply();
                        return true;
                    } else {
                        String objType = newValue.getClass().getName();
                        Log.e(TAG, "SeekBarPreference is not a Integer, it is " + objType);
                        return false;
                    }
                });
            }
            ListPreference themePreference = findPreference("theme");
            if (themePreference != null) {
                themePreference.setOnPreferenceChangeListener(
                        (preference, newValue) -> {
                            //  ThemeHelper.applyTheme(themeOption);
                            return true;
                        });
            }

        }
    }
/*
    public class SelectQuranFronts extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.website_preferences, rootKey);
            BottomOptionDialog item = new BottomOptionDialog();
            //    item.setdata(rootWordMeanings,wbwRootwords,grammarRootsCombined);
            FragmentManager fragmentManager = ActivitySettings.this.getSupportFragmentManager();
            @SuppressLint("CommitTransaction") FragmentTransaction transactions = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_slide_in_top, android.R.anim.fade_out);
            transactions.show(item);
            //     WordAnalysisBottomSheet.newInstance(data).show(ActivitySettings.this.getSupportFragmentManager(), WordAnalysisBottomSheet.TAG);
        }
    }*/

}
