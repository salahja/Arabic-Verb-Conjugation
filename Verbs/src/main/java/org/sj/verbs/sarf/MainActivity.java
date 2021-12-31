package org.sj.verbs.sarf;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.sj.verbs.R;
import org.sj.verbs.activity.BaseActivity;
import org.sj.verbs.activity.ConjugatorAct;
import org.sj.verbs.fragments.SettingsFragmentVerb;
import org.sj.verbs.utilities.SharedPref;

import java.util.Locale;


public class MainActivity extends BaseActivity {

    Button mujarradListingbtn, mazeedlistingbtn,  conjugatorbtn,
          settingbtn ;
    FloatingActionButton btnBottomSheet;
    RelativeLayout layoutBottomSheet;
    BottomSheetBehavior sheetBehavior;

    public static final String TAG = "bottom";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences shared =
              androidx.preference.PreferenceManager.getDefaultSharedPreferences(this);
        String preferences = shared.getString("theme", "dark");
        if (preferences.equals("light")) {
            switchTheme("light");
        } else if (preferences.equals("dark")) {
            switchTheme("dark");

        } else if (preferences.equals("blue")) {
            switchTheme("blue");


        } else if (preferences.equals("brown")) {
            switchTheme("brown");





        }

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
         setContentView(R.layout.activity_verb_conjugation);
      //  setContentView(R.layout.main_activity);





        if (isFirstTime()) {


            SettingsFragmentVerb fragment = new SettingsFragmentVerb();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.add(R.id.frame_container, fragment);
            transaction.commit();

        }

        initView();
      SetupBOttomMenu();

        Intent conjugatorintent = new Intent(MainActivity.this, ConjugatorAct.class);
        // finish();
        startActivity(conjugatorintent);





    }


    private void SetupBOttomMenu() {


        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SettingsFragmentVerb fragments = new SettingsFragmentVerb();
                FragmentTransaction transactions = getSupportFragmentManager().beginTransaction()
                      .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transactions.replace(R.id.frame_container, fragments).addToBackStack("mujarrad");
                transactions.commit();

            }
        });
     /*
        conjugatorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent conjugatorintent = new Intent(MainActivity.this, ConjugatorAct.class);
                // finish();
                startActivity(conjugatorintent);
            }
        });
      */



    }



    private boolean isFirstTime() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {

            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.apply();
        }

        return !ranBefore;
    }


    public void setLocaleEnglish() {
        Locale locale = new Locale(Config.LANG_EN);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext()
                .getResources()
                .updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());
    }


    private void initView() {

        btnBottomSheet = findViewById(R.id.fab);
    //   mazeedlistingbtn = findViewById(R.id.mazeedlist);
    //    mujarradListingbtn = findViewById(R.id.thulathilisting);
       settingbtn = findViewById(R.id.conjugatorsetting);
     //  conjugatorbtn = findViewById(R.id.conjugator);

        layoutBottomSheet = findViewById(R.id.bottom_sheet);
      sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);

        SharedPref pref = new SharedPref(this);




        btnBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleBottomSheet();
            }

            public void toggleBottomSheet() {
                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    //    btnBottomSheet.setText("Close sheet");
                } else {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    //    btnBottomSheet.setText("Expand sheet");
                }
            }
        });
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        //       btnBottomSheet.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        //      btnBottomSheet.setText("Expand Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });






    }


}