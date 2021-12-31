package org.sj.verb.trilateral.augmented.imperative.formula;

import org.sj.verb.trilateral.augmented.*;
import org.sj.verb.util.ArabCharUtil;
import org.sj.verb.trilateral.augmented.imperative.*;


public class AugmentedImperativeVerb3 extends AugmentedImperativeVerb {

    public AugmentedImperativeVerb3(AugmentedTrilateralRoot root,  String lastDim, String connectedPronoun) {
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
        return root.getC1()+ArabCharUtil.FATHA+"ا"+root.getC2()+ArabCharUtil.KASRA+root.getC3()+lastDim+connectedPronoun;

    }
}
