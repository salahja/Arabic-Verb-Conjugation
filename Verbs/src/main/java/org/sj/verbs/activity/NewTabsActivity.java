package org.sj.verbs.activity;

import static org.sj.verbs.utilities.ArabicLiterals.LALIF;
import static org.sj.verbs.utilities.Constants.QURAN_VERB_ROOT;
import static org.sj.verbs.utilities.Constants.QURAN_VERB_WAZAN;
import static org.sj.verbs.utilities.Constants.VERBCASE;
import static org.sj.verbs.utilities.Constants.VERBTYPE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.preference.PreferenceManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.sj.verbs.R;
import org.sj.verbs.VerbConjugaorApp;
import org.sj.verbs.fragments.Dictionary_frag;
import org.sj.verbs.fragments.FragmentIsmIsmAla;
import org.sj.verbs.fragments.FragmentIsmZarf;
import org.sj.verbs.fragments.FragmentIsmfaelIsmMafools;
import org.sj.verbs.fragments.FragmentVerb;
import org.sj.verbs.fragments.TabSagheerFragmentVerb;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class NewTabsActivity extends BaseActivity {
    private static final int NUM_PAGES_THULATHI = 7;
    private static final int NUM_PAGES_MAZEED = 5;
    private boolean ismujarrad;
    Bundle dataBundle;


    // Arrey of strings FOR TABS TITLES

    private final String[] thulathientitles = new String[]{"Hans Weir", "Lane Lexicon", "Sarf-e-Sagheer ", "Verb Conjugaton", "Active/Passive Pcpl", "N.Of Instrument", "N.Place/Time"};
    private final String[] thulathiartitles = new String[]{"قاموس هانز" ,  "لين معجم", "صرف صغير", "تصريف الأفعال ", "لاسم الفاعل/الاسم المفعول", "الاسم الآلة", "الاسم الظرف"};
    private final String[] mazeedentitles = new String[]{"Hans Weir", "Lane Lexicon", "Sarf-e-Sagheer ", "Verb Conjugaton", "Active/Passive Participle"};
    private final String[] mazeedartitles = new String[]{"قاموس هانز","لين معجم",  "صرف صغير", "تصريف الأفعال ", "لاسم الفاعل/الاسم المفعول"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtabs);
        FloatingTextButton callButton = findViewById(R.id.action_button);
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(VerbConjugaorApp.getContext());

        String language = shared.getString("lang", "en");

        callButton.setOnClickListener(view -> {

            // viewPager.adapters=null;
            finish();
            //      Snackbar.make(viewById, "Call button clicked", Snackbar.LENGTH_SHORT).show();
        });
        FragmentManager fm = getSupportFragmentManager();

        ViewStateAdapter sa = new ViewStateAdapter(fm, getLifecycle());
        final ViewPager2 viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(sa);
        final TabLayout tabLayout = findViewById(R.id.tabLayout);
        dataBundle = new Bundle();
        Bundle bundle = getIntent().getExtras();

        String root = bundle.getString(QURAN_VERB_ROOT);
        final String ss = root.replaceAll("[\\[\\]]", "");
        String verbroot = ss.replaceAll("[,;\\s]", "");
        int starts = verbroot.indexOf(LALIF);
        if (starts != -1) {
            verbroot = verbroot.replace(LALIF, "ء");
        }
        String verbform = null;
        String verbmood = null;
        String verbtype = null;
        if(null!=bundle) {
             verbform = bundle.getString(QURAN_VERB_WAZAN);
            verbmood = bundle.getString(VERBCASE);
           verbtype=bundle.getString(VERBTYPE);
        }
        ismujarrad = verbtype.equals("mujarrad");


            dataBundle.putSerializable(QURAN_VERB_ROOT, verbroot);
            dataBundle.putString(QURAN_VERB_WAZAN, verbform);
            dataBundle.putString(VERBCASE, verbmood);
            dataBundle.putString(VERBTYPE, verbtype);



        // Up to here, we have working scrollable pages
        if (ismujarrad) {
            if (language.equals("en")) {

                new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(thulathientitles[position])).attach();


            } else {


                new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(thulathiartitles[position])).attach();


            }
        } else {

            if (language.equals("en")) {

                new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(mazeedentitles[position])).attach();


            } else {


                new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(mazeedartitles[position])).attach();


            }


        }



        // Now we have tabs, NOTE: I am hardcoding the order, you'll want to do something smarter

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        // And now we have tabs that, when clicked, navigate to the correct page
    }
    private class ViewStateAdapter extends FragmentStateAdapter {

        public ViewStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // Hardcoded in this order, you'll want to use lists and make sure the titles match


            if (position == 0) {
                Dictionary_frag fragv = new Dictionary_frag(NewTabsActivity.this, "hans");
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else
            if (position == 1) {
                Dictionary_frag fragv = new Dictionary_frag(NewTabsActivity.this, "lanes");
                fragv.setArguments(dataBundle);
                return fragv.newInstance();
            } else     if (position == 2) {
                TabSagheerFragmentVerb fragv = new TabSagheerFragmentVerb(NewTabsActivity.this);
                fragv.setArguments(dataBundle);
                return fragv.newInstance();


            } else if (position == 3) {
                FragmentVerb fragv = new   FragmentVerb();
                fragv.setArguments(dataBundle);
                return fragv.newInstance();


            } else if (position == 4) {
                FragmentIsmfaelIsmMafools fragvs = new   FragmentIsmfaelIsmMafools();
                fragvs.setArguments(dataBundle);
                return fragvs.newInstance();
            } else if (position == 5) {
                FragmentIsmIsmAla fragvsi = new   FragmentIsmIsmAla();
                fragvsi.setArguments(dataBundle);
                return fragvsi.newInstance();
            } else if (position == 6) {
                FragmentIsmZarf fragvsi = new FragmentIsmZarf();
                fragvsi.setArguments(dataBundle);
                return fragvsi.newInstance();
            }

            FragmentVerb fragv = new   FragmentVerb();
            fragv.setArguments(dataBundle);
            return fragv.newInstance();
        }


        @Override
        public int getItemCount() {
            if (ismujarrad) {
                return NUM_PAGES_THULATHI;
            } else {
                return NUM_PAGES_MAZEED;
            }
        }
    }
}
