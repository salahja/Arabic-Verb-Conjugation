package org.sj.verb.trilateral.unaugmented.modifier.hamza;

import org.sj.verb.trilateral.unaugmented.*;
import org.sj.verb.trilateral.Substitution.*;
import org.sj.verb.trilateral.unaugmented.modifier.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الصف الأب المشترك لمهموز العين حسب شرط الفحص المشترك للمضارع والأمر والماضي           </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractEinMahmouz extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    public AbstractEinMahmouz() {
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        switch (kov) {
        case 6:
        case 9:
        case 13:
        case 22:
        case 25:
        case 29:
            return true;
        }
        return false;
    }
}
