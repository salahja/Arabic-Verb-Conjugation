package org.sj.noun.trilateral.augmented.modifier;

import org.sj.noun.*;
import org.sj.verb.trilateral.augmented.MazeedConjugationResult;
import org.sj.verb.trilateral.augmented.modifier.*;
import org.sj.noun.trilateral.augmented.AugmentedTrilateralNoun;
import org.sj.verb.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verb.util.ArabCharUtil;


/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractFaaMahmouz extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();

        switch (kov) {
        case 3:
        case 4:
        case 5:
        case 15:
        case 18:
        case 21:
        case 24:
        case 27:
            return true;
        }
        return false;
    }
}
