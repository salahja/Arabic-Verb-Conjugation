package org.sj.verb.trilateral.augmented.active.past.formula;

import org.sj.verb.trilateral.augmented.*;
import org.sj.verb.util.ArabCharUtil;

public class AugmentedPastVerb4 extends AugmentedPastVerb {
    public AugmentedPastVerb4(AugmentedTrilateralRoot root, String lastDpa, String connectedPronoun) {
        super(root, lastDpa, connectedPronoun);
    }


    public String form() {
     //   return "��"+ArabCharUtil.SKOON+ root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;
        return "ان"+ArabCharUtil.SKOON+ root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;


    }
}
