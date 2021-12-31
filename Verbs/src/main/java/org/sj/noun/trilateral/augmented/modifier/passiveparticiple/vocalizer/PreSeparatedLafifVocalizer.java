package org.sj.noun.trilateral.augmented.modifier.passiveparticiple.vocalizer;

import java.util.*;

import org.sj.noun.*;
import org.sj.verb.trilateral.Substitution.*;
import org.sj.verb.trilateral.augmented.MazeedConjugationResult;
import org.sj.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;


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
public class PreSeparatedLafifVocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PreSeparatedLafifVocalizer() {

        substitutions.add(new InfixSubstitution("ُوْ","ُو"));// EX: (مُوصٍ)
        substitutions.add(new InfixSubstitution("ُيْ","ُو"));// EX: (مُودٍ)

    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        return kov == 30 && formulaNo == 1;
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
