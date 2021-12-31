package org.sj.noun.trilateral.augmented.modifier.substituter;

import java.util.*;
import org.sj.verb.trilateral.Substitution.*;
import org.sj.noun.trilateral.augmented.modifier.AbstractGenericSubstituter;
import org.sj.verb.trilateral.augmented.MazeedConjugationResult;

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
public class GenericSubstituter2 extends AbstractGenericSubstituter {
    private List substitutions = new LinkedList();

    public GenericSubstituter2() {
        substitutions.add(new InfixSubstitution("دْت","دّ"));// EX: (ادِّخار، )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
        return mazeedConjugationResult.getRoot().getC1() == 'د' && super.isApplied(mazeedConjugationResult);
    }
}
