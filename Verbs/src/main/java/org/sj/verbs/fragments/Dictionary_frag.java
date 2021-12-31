package org.sj.verbs.fragments;

import static org.sj.verbs.utilities.ArabicLiterals.AlifMaksuraString;
import static org.sj.verbs.utilities.ArabicLiterals.Hamza;
import static org.sj.verbs.utilities.ArabicLiterals.LALIF;
import static org.sj.verbs.utilities.ArabicLiterals.Ya;
import static org.sj.verbs.utilities.Constants.MUJARRADVERBTAG;
import static org.sj.verbs.utilities.Constants.QURAN_VERB_ROOT;
import static org.sj.verbs.utilities.Constants.QURAN_VERB_WAZAN;
import static org.sj.verbs.utilities.Constants.SARFKABEERWEAKNESS;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.sj.verbs.R;
import org.sj.verbs.VerbConjugaorApp;
import org.sj.verbs.activity.NewTabsActivity;
import org.sj.verbs.adapter.LexiconAdapter;

import java.util.ArrayList;

import database.DatabaseUtils;
import database.entity.hanslexicon;
import database.entity.lanelexicon;
import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class Dictionary_frag extends Fragment {
    private static final int WRITE_REQUEST_CODE = 101;
    private static final String TAG = "PermissionDemo";


    RecyclerView recyclerView;
    private String verbweakness;
    private String callingfragment;
    private ArrayList<ArrayList> skabeer = new ArrayList<>();
    private Context context;
    private int verbformmazeed;
    private String verbform;
    private String verbroot, arabicword;

    private ArrayList<lanelexicon> lanesdictionary;
    private ArrayList<hanslexicon> hansdictionary;
    ArrayList<String> worddifinition = new ArrayList<>();
    String language;
    private String vocabroot;

    public Dictionary_frag(Context context, String language) {
        this.context = context;
        this.language = language;

    }



    public Dictionary_frag newInstance() {

        Dictionary_frag f = new Dictionary_frag((NewTabsActivity) context, language);

        Bundle dataBundle = getArguments();
        assert dataBundle != null;
        if (null != dataBundle) {
            //  Parcelable[] dictionaries = dataBundle.getParcelableArray("dictionary");

            String string = dataBundle.getString(QURAN_VERB_ROOT);
            verbform = dataBundle.getString(QURAN_VERB_WAZAN);
            verbweakness = dataBundle.getString(SARFKABEERWEAKNESS);
            callingfragment = dataBundle.getString(MUJARRADVERBTAG);
            vocabroot = dataBundle.getString(QURAN_VERB_ROOT);
        }

        f.setArguments(dataBundle);

        return f;

    }


    @Override
    public void onDetach() {
        super.onDetach();
        recyclerView.removeAllViews();
        Log.d("TAG", "verb fragment Detached");
    }


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.sarfkabeerheader, container, false);
        FloatingTextButton callButton = view.findViewById(R.id.action_buttons);
        Bundle dataBundle = getArguments();
        if (dataBundle != null) {
            String callingfragment = dataBundle.getString(MUJARRADVERBTAG);
            if (callingfragment != null) {
                if (callingfragment.equals("tverblist")) {
                    callButton.setVisibility(View.VISIBLE);
                } else {
                    callButton.setVisibility(View.GONE);
                }
            } else {
                callButton.setVisibility(View.GONE);
            }
        }
        //   callButton.setVisibility(View.VISIBLE);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //     FragmentManager fragmentManager = null;
                //   fragmentManager.popBackStack("mujarrad", FragmentManager.POP_BACK_STACK_INCLUSIVE);

                FragmentManager fm = getActivity()
                        .getSupportFragmentManager();
                //   fm.popBackStack ("mujarrad", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                //    getFragmentManager().popBackStack();
                //   FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.popBackStack();
                //     fm.popBackStack();

            }
        });


        assert dataBundle != null;
        DatabaseUtils utils = new DatabaseUtils(VerbConjugaorApp.getContext());
        verbroot = dataBundle.getString(QURAN_VERB_ROOT);
        arabicword = dataBundle.getString("arabicword");
        vocabroot = dataBundle.getString(QURAN_VERB_ROOT);
      if (language.equals("lanes")) {
            char[] chars = verbroot.toCharArray();
            //lanbes convert hamza to ALif
            Character c1=verbroot.charAt(0);
             Character c2=verbroot.charAt(1);
            Character c3=verbroot.charAt(2);
          int indexOfHamza = verbroot.indexOf(Hamza);
          if(indexOfHamza!=-1){
              verbroot=    verbroot.replaceAll(Hamza,LALIF);
          }



            StringBuilder difinitionbuilder = new StringBuilder();

            lanesdictionary = utils.getLanesDifinition(verbroot);
            for (lanelexicon lanes : lanesdictionary) {
                //  <p style="margin-left:200px; margin-right:50px;">
                difinitionbuilder.append("<p style=\"margin-left:200px; margin-right:50px;\">");
                difinitionbuilder.append(lanes.getDefinition()).append("</p>");
            }
            worddifinition.add(difinitionbuilder.toString());
        }

        else   if (language.equals("hans")) {
            char[] chars = verbroot.toCharArray();
          int indexOfHamza = verbroot.indexOf(Hamza);
          int indexofAlifMaksura = verbroot.indexOf(Ya);
          if(indexOfHamza!=-1){
              verbroot=    verbroot.replaceAll(Hamza,LALIF);
          }
          if(indexofAlifMaksura!=-1){
              verbroot=    verbroot.replaceAll(Ya,AlifMaksuraString);
          }

            StringBuilder lanessb = new StringBuilder();

            hansdictionary = utils.getHansDifinition(verbroot);
            for (hanslexicon lanes : hansdictionary) {
                //  <p style="margin-left:200px; margin-right:50px;">
                lanessb.append("<p style=\"margin-left:200px; margin-right:50px;\">");
                lanessb.append(lanes.getDefinition()).append("</p>");
            }
            worddifinition.add(lanessb.toString());
        }








        recyclerView = view.findViewById(R.id.sarfrecview);

        LexiconAdapter lanesLexiconAdapter;
        if (language.equals("lanes")||language.equals("hans")) {
            if (worddifinition.isEmpty()) {
                worddifinition.add("Word not Updated");
            }
            lanesLexiconAdapter = new LexiconAdapter(worddifinition, getContext(), language);
            recyclerView.setAdapter(lanesLexiconAdapter);
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }


    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.sarfrecview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


    }

}

