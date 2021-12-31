package org.sj.verbs.CustomKeyboard;



import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import org.sj.verbs.R;
import org.sj.verbs.activity.ConjugatorAct;


public class OvalCustomKeyboard extends LinearLayout implements View.OnClickListener {


    private final SparseArray<String> keyValues = new SparseArray<>();
    OvalCustomKeyboard keyboard;

    public OvalCustomKeyboard(ConjugatorAct keyBoardInitActivity) {
        super(keyBoardInitActivity);
    }

    public OvalCustomKeyboard(ConjugatorAct context, String s) {
        super(context);
    }

    public OvalCustomKeyboard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public OvalCustomKeyboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.round_arabic_keyboard, this, true);
        Button key_delete = findViewById(R.id.key_delete);
        Button key_AC = findViewById(R.id.key_AC);
        Button key_enter = findViewById(R.id.key_enter);
        keyboard = findViewById(R.id.arabic_keyboard);
      //  Button key_exit = findViewById(R.id.key_exit);


        Button dhad = findViewById(R.id.dhad);
        Button suwad = findViewById(R.id.suwad);
        Button qaf = findViewById(R.id.qaf);
        Button fa = findViewById(R.id.fa);
        Button ghain = findViewById(R.id.ghain);
        Button ayn = findViewById(R.id.ayn);
        Button haaa = findViewById(R.id.haaa);
        Button kha = findViewById(R.id.kha);
        Button ha = findViewById(R.id.ha);
        Button jeem = findViewById(R.id.jeem);


        dhad.setOnClickListener(this);
        suwad.setOnClickListener(this);
        qaf.setOnClickListener(this);
        fa.setOnClickListener(this);
        ghain.setOnClickListener(this);
        ayn.setOnClickListener(this);
        haaa.setOnClickListener(this);
        kha.setOnClickListener(this);
        ha.setOnClickListener(this);
        jeem.setOnClickListener(this);



        keyValues.put(R.id.dhad, "ض");
        keyValues.put(R.id.suwad, "ص");
        keyValues.put(R.id.qaf, "ق");
        keyValues.put(R.id.fa, "ف");
        keyValues.put(R.id.ghain, "غ");
        keyValues.put(R.id.ayn, "ع");
        keyValues.put(R.id.haaa, "ه");
        keyValues.put(R.id.kha, "خ");
        keyValues.put(R.id.ha, "ح");
        keyValues.put(R.id.jeem, "ج");


        Button sheen = findViewById(R.id.sheen);
        Button seen = findViewById(R.id.seen);
        Button ya = findViewById(R.id.ya);
        Button ba = findViewById(R.id.ba);
        Button lam = findViewById(R.id.lam);
        Button alif = findViewById(R.id.hamza);
        Button ta = findViewById(R.id.ta);
        Button nun = findViewById(R.id.nun);
        Button meem = findViewById(R.id.meem);
        Button kaf = findViewById(R.id.kaf);

        sheen.setOnClickListener(this);
        seen.setOnClickListener(this);
        ya.setOnClickListener(this);
        ba.setOnClickListener(this);
        lam.setOnClickListener(this);
        alif.setOnClickListener(this);
        ta.setOnClickListener(this);
        nun.setOnClickListener(this);
        meem.setOnClickListener(this);
        kaf.setOnClickListener(this);


        //   key00.setOnClickListener(this);
        key_delete.setOnClickListener(this);
        key_AC.setOnClickListener(this);
        key_enter.setOnClickListener(this);
   //     key_exit.setOnClickListener(this);
        //  key_dot.setOnClickListener(this);

        keyValues.put(R.id.sheen, "ش");
        keyValues.put(R.id.seen, "س");
        keyValues.put(R.id.ya, "ي");
        keyValues.put(R.id.ba, "ب");
        keyValues.put(R.id.lam, "ل");
        keyValues.put(R.id.hamza, "ا");
        keyValues.put(R.id.ta, "ت");
        keyValues.put(R.id.nun, "ن");
        keyValues.put(R.id.meem, "م");
        keyValues.put(R.id.kaf, "ك");


        Button zoay = findViewById(R.id.zoay);
        Button toay = findViewById(R.id.toay);
        Button dhal = findViewById(R.id.dhal);
        Button dal = findViewById(R.id.dal);
        Button zaa = findViewById(R.id.zaa);
        Button raa = findViewById(R.id.raa);
        Button waw = findViewById(R.id.waw);
        Button tamarboot = findViewById(R.id.tamarboota);
        Button tha = findViewById(R.id.tha);


        zoay.setOnClickListener(this);
        toay.setOnClickListener(this);
        dhal.setOnClickListener(this);
        dal.setOnClickListener(this);
        zaa.setOnClickListener(this);
        raa.setOnClickListener(this);
        waw.setOnClickListener(this);
        tamarboot.setOnClickListener(this);
        tha.setOnClickListener(this);

        keyValues.put(R.id.zoay, "ظ");
        keyValues.put(R.id.toay, "ط");
        keyValues.put(R.id.dhal, "ذ");
        keyValues.put(R.id.dal, "د");
        keyValues.put(R.id.zaa, "ز");
        keyValues.put(R.id.raa, "ر");
        keyValues.put(R.id.waw, "و");
        keyValues.put(R.id.tamarboota, "ة");
        keyValues.put(R.id.tha, "ث");

    }


    @Override
    public void onClick(View view) {

    }
}
