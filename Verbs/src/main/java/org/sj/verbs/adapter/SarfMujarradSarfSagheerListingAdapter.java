package org.sj.verbs.adapter;


import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import org.jetbrains.annotations.NotNull;
import org.sj.model.SarfSagheer;
import org.sj.verbs.R;
import org.sj.verbs.interfaces.OnItemClickListener;
import org.sj.verbs.utilities.SharedPref;

import java.util.ArrayList;

public class SarfMujarradSarfSagheerListingAdapter extends RecyclerView.Adapter<SarfMujarradSarfSagheerListingAdapter.ViewHolder> {

    private final ArrayList<SarfSagheer> sarfSagheer;
    int rootcolor, weaknesscolor, wazancolor;
    private final Context context;

    OnItemClickListener mItemClickListener;


    String ismzaftitle = "(الْظَرْف:)";
    String ismalatitle = "( الآلَة:)";
    final String alaheader = "اِسْم الآلَة";
    final String zarfheader = "اِسْم الْظَرفْ";


    public SarfMujarradSarfSagheerListingAdapter(ArrayList<SarfSagheer> lists, Context context) {
        this.context = context;
        this.sarfSagheer = lists;


    }






    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        //      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sarfkabeercolumn, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathitable, parent, false);
        //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathisarfsagheer, parent, false);

        return new ViewHolder(view);
    }


    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {

        SharedPreferences shared =getDefaultSharedPreferences(context);

        String preferences = shared.getString("theme", "dark");
        int cweakness = 0;
        int crootword = 0;
        final int cbabcolor;

        if (preferences.equals("dark")) {
            rootcolor = Color.CYAN;
            weaknesscolor = Color.YELLOW;
            wazancolor = Color.BLUE;



        } else {
            rootcolor = Color.RED;
            weaknesscolor = Color.BLACK;
            wazancolor = Color.RED;



        }

        StringBuilder zarf = new StringBuilder();
        StringBuilder ismala = new StringBuilder();
        StringBuilder amr = new StringBuilder();
        StringBuilder nahiamr = new StringBuilder();
        SarfSagheer sagheer = this.sarfSagheer.get(position);
        final Typeface mequran = Typeface.createFromAsset(context.getAssets(), SharedPref.arabicFontSelection());


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        int arabicFontsize = prefs.getInt("arabicFontSizeEntryArray", 20);



            holder.mamaroof.setText(sagheer.getMadhi());
            holder.mumaroof.setText(sagheer.getMudharay());
            holder.ismfail.setText(sagheer.getIsmfael());
            holder.mamajhool.setText(sagheer.getMadhimajhool());
            holder.mumajhool.setText(sagheer.getMudharaymajhool());
            holder.ismmafool.setText(sagheer.getIsmmafool());
            holder.amr.setText(sagheer.getAmrone());
            holder.nahiamr.setText(sagheer.getNahiamrone());
            holder.ismzarfheader.setText(zarfheader);
            holder.ismalaheader.setText(alaheader);
            zarf.append((CharSequence) sagheer.getIsmalaone()).append(", ").append(sagheer.getIsmalatwo()).append(", ").append(sagheer.getIsmalathree());
            ismala.append((CharSequence) sagheer.getZarfone()).append(", ").append(sagheer.getZarftwo()).append(", ").append(sagheer.getZarfthree());
            holder.ismzarf.setText(zarf);


            holder.ismala.setText(ismala);


            holder.weaknessname.setText(sagheer.getWeakness());

            holder.rootword.setText(sagheer.getVerbroot());

        holder.babname.setText(sagheer.getWazanname());

        holder.ismalaheader.setTextSize(arabicFontsize);
        holder.ismzarfheader.setTextSize(arabicFontsize);
        holder.mamaroof.setTextSize(arabicFontsize);

        holder.mumaroof.setTextSize(arabicFontsize);

        holder.masdaro.setTextSize(arabicFontsize);
           holder.masdart.setTextSize(arabicFontsize);

        holder.ismfail.setTextSize(arabicFontsize);


        holder.mamajhool.setTextSize(arabicFontsize);


        holder.mumajhool.setTextSize(arabicFontsize);


        holder.ismmafool.setTextSize(arabicFontsize);


        holder.amr.setTextSize(arabicFontsize);


        holder.nahiamr.setTextSize(arabicFontsize);

        holder.babname.setTextSize(arabicFontsize);


        holder.rootword.setTextSize(arabicFontsize);



        holder.ismzarf.setTextSize(arabicFontsize);

        holder.ismala.setTextSize(arabicFontsize);

        holder.weaknessname.setTextSize(arabicFontsize);


        holder.wazan.setTextSize(arabicFontsize);


        holder.mamaroof.setTypeface(mequran);
        holder.mumaroof.setTypeface(mequran);

        holder.ismfail.setTypeface(mequran);

        holder.mamajhool.setTypeface(mequran);

        holder.mumajhool.setTypeface(mequran);

        holder.ismmafool.setTypeface(mequran);

        holder.amr.setTypeface(mequran);

        holder.nahiamr.setTypeface(mequran);
        holder.babname.setTypeface(mequran);

        holder.rootword.setTypeface(mequran);


        holder.ismzarf.setTypeface(mequran);
        holder.ismala.setTypeface(mequran);
        holder.weaknessname.setTypeface(mequran);
        //  holder.weaknessname.setTextColor(Color.GREEN);

        holder.babname.setTextColor(wazancolor);
        holder.rootword.setTextColor(rootcolor);
        holder.weaknessname.setTextColor(weaknesscolor);







    }


    @Override
    public long getItemId(int position) {
        //  Surah surah = surahArrayList.get(position);

        return sarfSagheer.size();
    }

// --Commented out by Inspection START (17/12/21, 7:28 AM):
//    public Object getItem(int position) {
//
//        return sarfSagheer.get(position);
//    }
// --Commented out by Inspection STOP (17/12/21, 7:28 AM)

    @Override
    public int getItemCount() {
        return sarfSagheer.size();

    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder
          implements View.OnClickListener // current clickListerner
    {
        public final Chip amr, nahiamr, ismfail,   mumaroof,
              mamaroof, ismmafool,  mumajhool, mamajhool,
              ismzarf, ismala,   verify;
        public final TextView babno,ismalaheader,ismzarfheader,masdart,masdaro,babname,rootword,weaknessname,wazan;


        public ViewHolder(View view) {
            super(view);

            babno = view.findViewById(R.id.babno);
            ismfail = view.findViewById(R.id.ismfail);
            masdaro = view.findViewById(R.id.masdar);
            mumaroof = view.findViewById(R.id.mumaroof);
            mamaroof = view.findViewById(R.id.mamaroof);
            ismmafool = view.findViewById(R.id.ismmafool);
            masdart = view.findViewById(R.id.masdar2);
            mumajhool = view.findViewById(R.id.mumajhool);
            mamajhool = view.findViewById(R.id.mamajhool);
            amr = view.findViewById(R.id.amr);
            nahiamr = view.findViewById(R.id.nahiamr);
            ismala = view.findViewById(R.id.ismaalatable);
            ismzarf = view.findViewById(R.id.zarftable);
            babname = view.findViewById(R.id.babno);
            rootword = view.findViewById(R.id.rootword);
            weaknessname = view.findViewById(R.id.weknessname);
            ismzarfheader = view.findViewById(R.id.ismzarfheader);
            ismalaheader = view.findViewById(R.id.ismalaheader);
            wazan = view.findViewById(R.id.wazan);
            verify = view.findViewById(R.id.conjugateall);





            mumajhool.setTooltipText("Click for Verb Conjugation");

            view.setOnClickListener(this);
            ismfail.setOnClickListener(this);//R.id.ismfail);

            mumaroof.setOnClickListener(this);//R.id.mumaroof);
            mamaroof.setOnClickListener(this);//R.id.mamaroof);
            ismmafool.setOnClickListener(this);//R.id.ismmafool);

            mumajhool.setOnClickListener(this);//R.id.mumajhool);
            mamajhool.setOnClickListener(this);//R.id.mamajhool);
            amr.setOnClickListener(this);//R.id.amr);
            nahiamr.setOnClickListener(this);//R.id.nahiamr);
            ismala.setOnClickListener(this);//R.id.ismaalatable);
            ismzarf.setOnClickListener(this);//R.id.zarftable);

            rootword.setOnClickListener(this);//R.id.weaknesstype);



            verify.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }

    }


}
