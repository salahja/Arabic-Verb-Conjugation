package org.sj.conjugator.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.sj.verbs.R;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     FontQuranListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class VerbFormsDialogFrag extends BottomSheetDialogFragment {
    //   public class VerbFormsDialogFrag extends Fragment {
    private static final String ARG_OPTIONS_DATA = "item_count";
    private String form;

    public static VerbFormsDialogFrag newInstance(String[] data) {
        final VerbFormsDialogFrag fragment = new VerbFormsDialogFrag();
        final Bundle args = new Bundle();
        args.putStringArray(ARG_OPTIONS_DATA, data);
        fragment.setArguments(args);
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //  return inflater.inflate(R.layout.verb_forms, container, false);
        View view = inflater.inflate(R.layout.webview, container, false);
        Bundle bundle = this.getArguments();
        String[] stringArray = bundle.getStringArray(ARG_OPTIONS_DATA);
        form = (stringArray[0]);
    //    @SuppressLint("MissingInflatedId") WebView wv = (WebView) view.findViewById(R.id.wview);
     //   Utils utils = new Utils(VerbConjugaorApp.getContext());
        String formstr = "Form";
        if(!form.contains("Form")){

            formstr = formstr.concat(" ").concat(form);
        }else{
            formstr=form;
        }

/*       ArrayList<GrammarRules> list = utils.getGrammarRulesByRules(formstr);
        if (!list.isEmpty()) {
            wv.loadDataWithBaseURL(null, list.get(0).getDetailsrules(), "text/html", "utf-8", null);
        }*/
        return view;
    }

}