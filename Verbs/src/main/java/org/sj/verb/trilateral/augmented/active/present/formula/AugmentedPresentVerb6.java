package org.sj.verb.trilateral.augmented.active.present.formula;

import org.sj.verb.trilateral.augmented.*;
import org.sj.verb.util.ArabCharUtil;

public class AugmentedPresentVerb6 extends AugmentedPresentVerb {
    public AugmentedPresentVerb6(AugmentedTrilateralRoot root, String cp, String lastDpr, String connectedPronoun) {
        super(root, cp, lastDpr, connectedPronoun);
    }


    public String form() {
        return cp+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.FATHA+root.getC3()+ArabCharUtil.KASRA+root.getC3()+lastDpr+connectedPronoun;
    }
}
