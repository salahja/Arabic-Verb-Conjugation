package org.sj.verb.trilateral.augmented.active.present.formula;

import org.sj.verb.trilateral.augmented.*;
import org.sj.verb.util.ArabCharUtil;


public class AugmentedPresentVerb2 extends AugmentedPresentVerb {
    public AugmentedPresentVerb2(AugmentedTrilateralRoot root, String cp, String lastDpr, String connectedPronoun) {
        super(root, cp, lastDpr, connectedPronoun);
    }


    public String form() {
        return cp+ArabCharUtil.DAMMA+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SHADDA+ArabCharUtil.KASRA+root.getC3()+lastDpr+connectedPronoun;
    }
}
