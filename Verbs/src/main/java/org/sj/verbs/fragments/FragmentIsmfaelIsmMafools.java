package org.sj.verbs.fragments;

import static org.sj.verbs.utilities.Constants.MUJARRADVERBTAG;
import static org.sj.verbs.utilities.Constants.QURAN_VERB_ROOT;
import static org.sj.verbs.utilities.Constants.QURAN_VERB_WAZAN;
import static org.sj.verbs.utilities.Constants.VERBCASE;
import static org.sj.verbs.utilities.Constants.VERBTYPE;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.sj.verbs.GatherAll;
import org.sj.verbs.R;
import org.sj.verbs.adapter.IsmFaelIsmMafoolSarfKabeerAdapter;

import java.util.ArrayList;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class FragmentIsmfaelIsmMafools extends Fragment {

    RecyclerView recyclerView;


    public FragmentIsmfaelIsmMafools newInstance() {
        FragmentIsmfaelIsmMafools f = new FragmentIsmfaelIsmMafools();

        Bundle dataBundle = getArguments();
        assert dataBundle != null;

        if (null != dataBundle) {

            dataBundle.getString(QURAN_VERB_ROOT);
            dataBundle.getString(QURAN_VERB_WAZAN);//verb formula depnding upon the verbtype mujjarad or mazeed
            dataBundle.getString(VERBCASE);
            dataBundle.getString(VERBTYPE);

        }

        f.setArguments(dataBundle);
        return f;

    }



    boolean regularverb;

    private ArrayList<ArrayList> skabeer = new ArrayList<>();

    private String augmentedFormula;
    private String unaugmentedFormula;
    private String verbroot, verbmood;
    boolean isAugmented, isUnAugmented;





    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.sarfheader, container, false);
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
                //   fm.popBackStack();

            }
        });


        //    Bundle dataBundle = this.getArguments();
        assert dataBundle != null;
        if(dataBundle.getString(VERBTYPE).equals("mujarrad")){
            isUnAugmented=true;
            unaugmentedFormula = dataBundle.getString(QURAN_VERB_WAZAN);
        }else{
            augmentedFormula = dataBundle.getString(QURAN_VERB_WAZAN);
            isAugmented=true;
        }


        verbroot = dataBundle.getString(QURAN_VERB_ROOT);
        verbmood = dataBundle.getString(VERBCASE);





        recyclerView = view.findViewById(R.id.sarfrecview);
        skabeer = setUparrays(view);

        return view;
    }

    @NotNull
    private ArrayList<ArrayList> setUparrays(View view) {


        if (isUnAugmented) {


            ninitThulathiAdapter();


        }  else{
            //   initMazeedAdapter();
            initMazeedAdapterNew();
        }

        recyclerView = view.findViewById(R.id.sarfrecview);

        return skabeer;
    }

    private void initMazeedAdapterNew() {


        ArrayList<ArrayList> arrayLists = GatherAll.getInstance().buildAugmenteParticiples(verbroot, augmentedFormula);

        //  VerbSarfKabeerAdapter ska = new VerbSarfKabeerAdapter(skabeer, getContext());
        IsmFaelIsmMafoolSarfKabeerAdapter ska = new IsmFaelIsmMafoolSarfKabeerAdapter(arrayLists, getContext(), false);
        //AconSarfSagheerAdapter sk=new AconSarfSagheerAdapter(ar, MainActivity.this);
        recyclerView.setAdapter(ska);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


    }

    private void ninitThulathiAdapter() {


        //   OldThulathi();
        ArrayList<ArrayList> mujarradListing = GatherAll.getInstance().getMujarradParticiple(verbmood, verbroot, unaugmentedFormula);


        boolean newsarf = true;
        IsmFaelIsmMafoolSarfKabeerAdapter ska = new IsmFaelIsmMafoolSarfKabeerAdapter(mujarradListing, getContext(), newsarf);
        //AconSarfSagheerAdapter sk=new AconSarfSagheerAdapter(ar, MainActivity.this);
        recyclerView.setAdapter(ska);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }






    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.sarfrecview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ImageView ref;

        ref = view.findViewById(R.id.dismissView);
        //     dismiss(ref);

    }


}
