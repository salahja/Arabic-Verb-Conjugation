package org.sj.noun.trilateral.unaugmented.assimilate.nonstandard;

import org.sj.noun.NounFormula;
import org.sj.verb.trilateral.unaugmented.*;
import org.sj.verb.util.*;

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
public class NounFormulaA extends NounFormula{

    public NounFormulaA(UnaugmentedTrilateralRoot root, String suffixNo) {
        super(root, suffixNo);
    }

    //to be used in refection getting the formula name
    public NounFormulaA() {
    }

    public String form() {
        return root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.KASRA+ArabCharUtil.YA+root.getC3()+suffix;
    }

    public String getFormulaName() {
        return "فَعِيل";
    }
}
