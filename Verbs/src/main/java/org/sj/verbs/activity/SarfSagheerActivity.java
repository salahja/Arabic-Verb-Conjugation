package org.sj.verbs.activity;



import static org.sj.verbs.utilities.Constants.VERBTYPE;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.sj.verbs.R;
import org.sj.verbs.fragments.RulesBottomSheet;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class SarfSagheerActivity extends BaseActivity {



    private String verbtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      //  bottomNavigationView = findViewById(R.id.bottomNavView);


        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {

            verbtype=bundle.getString(VERBTYPE);
        }
        FloatingTextButton callButton = findViewById(R.id.sagheeractivtyfloat);
        callButton.setOnClickListener(view -> {
            SarfSagheerActivity.super.finish();
            Intent conjugatorintent = new Intent(SarfSagheerActivity.this, ConjugatorAct.class);
            // finish();
            startActivity(conjugatorintent);
            //  Snackbar.make(viewById, "Call button clicked", Snackbar.LENGTH_SHORT).show();
        });



        //    item.setdata(rootWordMeanings,wbwRootwords,grammarRootsCombined);
        FragmentManager fragmentManager =  getSupportFragmentManager();


           String[] data = {verbtype };
        FragmentTransaction transactions = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_slide_in_top, android.R.anim.fade_out);

        RulesBottomSheet.newInstance(data).show(getSupportFragmentManager(), RulesBottomSheet.TAG);


    }
}