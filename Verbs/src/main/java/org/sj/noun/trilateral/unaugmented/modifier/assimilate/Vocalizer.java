package org.sj.noun.trilateral.unaugmented.modifier.assimilate;

import java.util.*;

import org.sj.noun.trilateral.unaugmented.modifier.*;
import org.sj.noun.trilateral.unaugmented.modifier.assimilate.vocalizer.*;
import org.sj.verb.trilateral.Substitution.*;

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
public class Vocalizer {
    private List modifiers = new LinkedList();

    public Vocalizer() {
        modifiers.add(new Vocalizer1());
        modifiers.add(new Vocalizer2());
        modifiers.add(new Vocalizer31());
        modifiers.add(new Vocalizer32());
        modifiers.add(new Vocalizer41());
        modifiers.add(new Vocalizer42());
    }

    public void apply(ConjugationResult conjResult) {
        Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IUnaugmentedTrilateralNounModificationApplier modifier = (IUnaugmentedTrilateralNounModificationApplier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}