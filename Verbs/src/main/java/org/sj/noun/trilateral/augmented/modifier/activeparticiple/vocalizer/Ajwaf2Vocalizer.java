package org.sj.noun.trilateral.augmented.modifier.activeparticiple.vocalizer;

import java.util.*;

import org.sj.noun.*;
import org.sj.verb.trilateral.Substitution.*;
import org.sj.verb.trilateral.augmented.MazeedConjugationResult;
import org.sj.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import org.sj.verb.trilateral.augmented.MazeedConjugationResult;
import org.sj.verb.util.ArabCharUtil;

import java.util.*;

import org.sj.noun.*;
import org.sj.verb.trilateral.Substitution.*;
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
public class Ajwaf2Vocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Ajwaf2Vocalizer() {
        substitutions.add(new InfixSubstitution("ْيِ","ِي"));// EX: (مُبِيدٌ، مُستَقِيلٌ)
        substitutions.add(new InfixSubstitution("َيِ","َا"));// EX: (مُنْهالٌ، مُكْتالٌ)

    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        int kov = mazeedConjugationResult.getKov();
        int formulaNo = mazeedConjugationResult.getFormulaNo();

        switch (kov) {
        case 18:
            switch (formulaNo) {
            case 1:
            case 5:
            case 9:
                return true;
            }


        case 19:
            switch (formulaNo) {
            case 1:
            case 9:
                return true;
            }

        case 20:
            switch (formulaNo) {
            case 1:
            case 4:
            case 5:
            case 9:
                return true;
            }

        }

        return false;

    }

    public List getSubstitutions() {
        return substitutions;
    }
}
