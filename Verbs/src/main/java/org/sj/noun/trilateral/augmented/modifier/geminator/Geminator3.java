package org.sj.noun.trilateral.augmented.modifier.geminator;

import java.util.*;

import org.sj.noun.*;
import org.sj.verb.trilateral.Substitution.*;
import org.sj.verb.trilateral.augmented.MazeedConjugationResult;
import org.sj.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
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
public class Geminator3 extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();
    public Geminator3() {
        substitutions.add(new InfixSubstitution("تْت","تّ"));// EX: (مُتَّبِعٌ، مُتَّئِمٌ)
    }


    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return mazeedConjugationResult.getRoot().getC1() == 'ت' && (kov == 1 || kov == 6) && formulaNo == 5;
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
