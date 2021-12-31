package org.sj.noun.trilateral.augmented.modifier.activeparticiple;

import java.util.List;
 

import org.sj.noun.trilateral.augmented.modifier.*;
import org.sj.noun.NounLamAlefModifier;
import org.sj.noun.NounSunLamModifier;
import org.sj.noun.*;
import org.sj.noun.trilateral.augmented.modifier.Substituter;
import org.sj.verb.trilateral.augmented.*;
import org.sj.verb.trilateral.augmented.modifier.*;




import org.sj.verb.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verb.trilateral.augmented.MazeedConjugationResult;
import org.sj.verb.trilateral.augmented.modifier.vocalizer.IFormulaApplyingChecker;
import org.sj.verb.trilateral.augmented.modifier.vocalizer.FormulaApplyingChecker;
import org.sj.verb.trilateral.augmented.modifier.AugmentedTrilateralModifierListener;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ����� �������� ������ ��� ��� ������
 * ������ �������� �� ������� ������ ������
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */

public class ActiveParticipleModifier {
    private Substituter substituter = new Substituter();
    private Geminator geminator = new Geminator();
    private Vocalizer vocalizer = new Vocalizer();
    private Mahmouz mahmouz = new Mahmouz();

    private ActiveParticipleModifier() {
    }

    private static ActiveParticipleModifier instance = new ActiveParticipleModifier();

    public static ActiveParticipleModifier getInstance() {
        return instance;
    }
// AugmentedTrilateralModifierListener listener //todo
    public MazeedConjugationResult build(AugmentedTrilateralRoot root, int kov, int formulaNo, List conjugations, boolean listener) {
        MazeedConjugationResult conjResult = new MazeedConjugationResult(kov, formulaNo, root, conjugations);
        substituter.apply(conjResult);
        geminator.apply(conjResult);

        boolean applyVocalization = true;
        int result = FormulaApplyingChecker.getInstance().check(root, formulaNo);
        if (result == IFormulaApplyingChecker.NOT_VOCALIZED) {
            applyVocalization = false;
        }
        else if (result == IFormulaApplyingChecker.TWO_STATE) {
            if (listener)
          //  if (listener == null)
                applyVocalization = true;
            else
                //asking the listener to apply or not the vocaliztion
              //    applyVocalization = listener.doSelectVocalization();
            applyVocalization=true;
        }

        if (applyVocalization) {
            vocalizer.apply(conjResult);
        }


        mahmouz.apply(conjResult);
        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}

