package org.sj.verbs.adapter;


import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.sj.verbs.R;
import org.sj.verbs.interfaces.OnItemClickListener;
import org.sj.verbs.utilities.SharedPref;

import java.util.ArrayList;

import database.entity.kov;

public class rulesbottomsheetadapter extends RecyclerView.Adapter<rulesbottomsheetadapter.ViewHolder> {


        private final Context context;

        OnItemClickListener mItemClickListener;

        private ArrayList<kov> kovArrayList;


        public rulesbottomsheetadapter(ArrayList<kov> lists, Context context) {
            this.context = context;
            this.kovArrayList = lists;


        }





        @NonNull
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            //      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sarfkabeercolumn, parent, false);
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rules, parent, false);
            //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thulathisarfsagheer, parent, false);

            return new ViewHolder(view);
        }


        public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
 
            SharedPreferences shared =getDefaultSharedPreferences(context);


            kov toArray = kovArrayList.get(position);

            final Typeface mequran = Typeface.createFromAsset(context.getAssets(), SharedPref.arabicFontSelection());


            
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
     //   String fonts=      prefs.getString("Arabic_Font_Size", "25");
       //     final int arabicFontsize = Integer.parseInt(fonts);
            StringBuilder sb=new StringBuilder();
            sb.append(toArray.getRulename()).append("(").append(toArray.getExample()).append(")");
        //    holder.rulenumber.setTextSize(arabicFontsize);
            holder.rulenumber.setText(sb.toString());

          //  holder.rulenumber.setTextSize(arabicFontsize);
            holder.rulenumber.setTypeface(mequran);







        }


        @Override
        public long getItemId(int position) {


            return kovArrayList.size();
        }

// --Commented out by Inspection START (17/12/21, 7:24 AM):
//        public Object getItem(int position) {
//
//            return kovArrayList.get(position);
//        }
// --Commented out by Inspection STOP (17/12/21, 7:24 AM)

        @Override
        public int getItemCount() {
            return kovArrayList.size();

        }

        public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
            this.mItemClickListener = mItemClickListener;
        }

        public void setVerbArrayList(ArrayList<kov> sarfsagheer) {
            this.kovArrayList = sarfsagheer;
        }


        public class ViewHolder extends RecyclerView.ViewHolder
              implements View.OnClickListener // current clickListerner
        {

            public final TextView rulenumber,rulename;


            public ViewHolder(View view) {
                super(view);
 
                rulenumber = view.findViewById(R.id.tvKovNumber);
                rulename = view.findViewById(R.id.tvKovName);









                view.setOnClickListener(this);

                rulename.setOnClickListener(this);


            }


            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(v, getLayoutPosition());
                }
            }

        }


    }

