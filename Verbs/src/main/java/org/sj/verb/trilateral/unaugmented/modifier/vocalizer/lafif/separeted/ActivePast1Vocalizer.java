package org.sj.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted;

import java.util.*;

import org.sj.verb.trilateral.Substitution.*;
import org.sj.verb.trilateral.unaugmented.modifier.*;
import org.sj.verb.trilateral.unaugmented.ConjugationResult;

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
public class ActivePast1Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public ActivePast1Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيَ", "َى")); // EX: (وقَى)
        substitutions.add(new InfixSubstitution("َيُوا", "َوْا")); // EX: (وَقَوْا)
        substitutions.add(new InfixSubstitution("َيَت", "َت")); // EX: (هي وَقَتْ)


    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (kov == 29 || kov == 30) && (noc == 2);
    }
}
