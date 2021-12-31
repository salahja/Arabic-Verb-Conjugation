package org.sj.noun.trilateral.unaugmented.modifier.exaggeration;

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
public class ExaggerationModifier implements IUnaugmentedTrilateralNounModifier{
    private Vocalizer vocalizer = new Vocalizer();
    private Mahmouz mahmouz = new Mahmouz();

    private ExaggerationModifier() {
    }

    private static ExaggerationModifier instance = new ExaggerationModifier();

    public static ExaggerationModifier getInstance() {
        return instance;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String formula) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations, formula);
        vocalizer.apply(conjResult);
        mahmouz.apply(conjResult);
        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}
