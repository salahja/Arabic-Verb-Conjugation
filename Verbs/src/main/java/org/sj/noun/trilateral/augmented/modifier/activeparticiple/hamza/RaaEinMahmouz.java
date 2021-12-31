package org.sj.noun.trilateral.augmented.modifier.activeparticiple.hamza;


import java.util.*;

import org.sj.noun.*;
import org.sj.verb.trilateral.Substitution.*;
import org.sj.verb.trilateral.augmented.*;
import org.sj.verb.trilateral.augmented.modifier.*;

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


public class RaaEinMahmouz extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    List substitutions = new LinkedList();

    public RaaEinMahmouz() {
        substitutions.add(new InfixSubstitution("ْءٍ","ٍ"));// EX: (مُرٍ، )
        substitutions.add(new InfixSubstitution("ْءِ","ِ"));// EX: (مُرِيَة، )
        substitutions.add(new InfixSubstitution("ْءُ","ُ"));// EX: (مُرُونَ، )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        AugmentedTrilateralRoot root = mazeedConjugationResult.getRoot();
        return root.getC1() == 'ر' && root.getC2() == 'ء' && root.getC3() == 'ي' && mazeedConjugationResult.getFormulaNo() == 1;
    }
}
