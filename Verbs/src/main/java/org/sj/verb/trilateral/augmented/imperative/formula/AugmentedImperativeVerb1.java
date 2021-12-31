package org.sj.verb.trilateral.augmented.imperative.formula;

import org.sj.verb.util.ArabCharUtil;
import org.sj.verb.trilateral.augmented.*;
import org.sj.verb.trilateral.augmented.imperative.*;


public class AugmentedImperativeVerb1 extends AugmentedImperativeVerb {

    public AugmentedImperativeVerb1(AugmentedTrilateralRoot root,  String lastDim, String connectedPronoun) {
        super(root, lastDim, connectedPronoun);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.trilingual.augmented.imperative.AugmentedImperativeVerb
     *   method
     */
    public String form() {
        return "أ"+ArabCharUtil.FATHA+root.getC1()+ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDim+connectedPronoun;
    }
}
