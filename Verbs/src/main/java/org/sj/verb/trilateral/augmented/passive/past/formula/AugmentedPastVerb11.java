package org.sj.verb.trilateral.augmented.passive.past.formula;

import org.sj.verb.trilateral.augmented.*;
import org.sj.verb.util.ArabCharUtil;


public class AugmentedPastVerb11 extends AugmentedPastVerb {

    public AugmentedPastVerb11(AugmentedTrilateralRoot root, String lastDpa, String connectedPronoun) {
        super(root, lastDpa, connectedPronoun);
    }


    public String form() {
        return "ا"+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.DAMMA+"و"+ArabCharUtil.SHADDA+ArabCharUtil.KASRA+root.getC3()+lastDpa+connectedPronoun;
    }
}
