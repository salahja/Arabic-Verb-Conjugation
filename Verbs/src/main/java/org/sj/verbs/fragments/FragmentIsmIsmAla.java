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
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.sj.verbs.GatherAll;
import org.sj.verbs.R;
import org.sj.verbs.adapter.IsmAlaSarfKabeerAdapter;

import java.util.ArrayList;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class FragmentIsmIsmAla extends Fragment {
    private static final int WRITE_REQUEST_CODE = 101;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    private FloatingTextButton callButton;

    private String augmentedFormula;
    private String unaugmentedFormula;
    private String verbroot, verbmood;
    boolean isAugmented, isUnAugmented;

    RecyclerView recyclerView;
    Button llPdf;

    public FragmentIsmIsmAla newInstance() {
        FragmentIsmIsmAla f = new FragmentIsmIsmAla();
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



    private ArrayList<ArrayList> skabeer = new ArrayList<>();







    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.sarfheader, container, false);
        callButton = view.findViewById(R.id.action_buttons);
        Bundle dataBundle = getArguments();
        if(dataBundle!=null) {
            String callingfragment = dataBundle.getString(MUJARRADVERBTAG);
            if(callingfragment!=null) {
                if (callingfragment.equals("tverblist")) {
                    callButton.setVisibility(View.VISIBLE);
                } else {
                    callButton.setVisibility(View.GONE);
                }
            }else{
                callButton.setVisibility(View.GONE);
            }
        }

       // callButton = view.findViewById(R.id.action_buttons);
     //   callButton.setVisibility(View.VISIBLE);


     //   Bundle dataBundle = this.getArguments();
        assert dataBundle != null;

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
          //      ffm.popBackStack();
                   fm.popBackStack();

            }
        });

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
        //    SarfSagheerThulathiWeak sw = new SarfSagheerThulathiWeak(getActivity());
        //    SarfSagheerMazeedRegular mw = new SarfSagheerMazeedRegular(getActivity());
        //    sarf = new SarfSagheerThulathiRegular(getActivity());
        //     getsarfsagheer = sf.getThulathiRegularQuery("نصر",NASARA);
        // getsarfsagheer = sw.getThulathiWeakQuery("وجد",ZARABA);
        //  getsarfsagheer = mw.setUpSarfSagheerMazidQuery("نصر", 2);


        return skabeer;
    }

    private void initMazeedAdapterNew() {


    }


    private void ninitThulathiAdapter() {
        //   OldThulathi();
        ArrayList<ArrayList> mujarradListing = GatherAll.getInstance().getMujarradIsmAla(verbmood, verbroot, unaugmentedFormula);




        IsmAlaSarfKabeerAdapter ska = new  IsmAlaSarfKabeerAdapter(mujarradListing, getContext());
        //AconSarfSagheerAdapter sk=new AconSarfSagheerAdapter(ar, MainActivity.this);
        recyclerView.setAdapter(ska);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }








}
