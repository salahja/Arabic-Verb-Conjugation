package org.sj.noun.trilateral.unaugmented.modifier.passiveparticiple.vocalizer;

import java.util.*;

import org.sj.noun.*;

import org.sj.verb.trilateral.Substitution.*;
import org.sj.noun.trilateral.unaugmented.modifier.*;

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
public class Ajwaf1Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public Ajwaf1Vocalizer() {
        substitutions.add(new InfixSubstitution("ْوُو","ُو"));// EX: (مَؤُوب، مَبُوء، مَقُول،)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        return ((kov == 15 || kov == 16) && (noc ==1 || noc == 4) || (kov == 17 && (noc == 4 || noc == 1 || noc == 5)));
    }
}
