package org.sj.noun.trilateral.unaugmented.modifier.elative;

import java.util.List;
import org.sj.noun.NounLamAlefModifier;
import org.sj.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import org.sj.noun.trilateral.unaugmented.modifier.*;
import org.sj.noun.NounSunLamModifier;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: تطبيق المعالجة الخاصة على اسم الفاعل
 * ابتداء بالادغام ثم الاعلال واخيرا الهمزة
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ElativeModifier implements IUnaugmentedTrilateralNounModifier{
    private Geminator geminator = new Geminator();
    private Vocalizer vocalizer = new Vocalizer();
    private Mahmouz mahmouz = new Mahmouz();

    private AlkhairModifier alkhairModifier = new AlkhairModifier();
    private AlSharModifier alSharModifier = new AlSharModifier();

    private ElativeModifier() {
    }

    private static ElativeModifier instance = new ElativeModifier();

    public static ElativeModifier getInstance() {
        return instance;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String formula) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations, formula);
        if (alkhairModifier.isApplied(conjResult)) {
            alkhairModifier.apply(conjResult);
        }
        else if (alSharModifier.isApplied(conjResult)) {
            alSharModifier.apply(conjResult);
        }
        else {
            if (geminator.isApplied(conjResult))
                geminator.apply(conjResult.getFinalResult(), root);
            vocalizer.apply(conjResult);
            mahmouz.apply(conjResult);
            NounLamAlefModifier.getInstance().apply(conjResult);
            NounSunLamModifier.getInstance().apply(conjResult);
        }
        return conjResult;
    }

}
