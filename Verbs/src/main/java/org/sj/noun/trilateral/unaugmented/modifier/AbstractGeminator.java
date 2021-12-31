package org.sj.noun.trilateral.unaugmented.modifier;

import org.sj.noun.*;

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
public abstract class AbstractGeminator extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {

    public AbstractGeminator() {
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        switch (kov) {
        case 2:
            switch (noc) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            }

        case 3:
            return noc == 2 || noc == 1;

        case 8:
            return noc == 4;

        case 12:
            return noc == 2 || noc == 4;
        }
        return false;
    }
}
