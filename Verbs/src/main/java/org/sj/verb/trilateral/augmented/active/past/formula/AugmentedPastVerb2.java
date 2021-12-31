package org.sj.verb.trilateral.augmented.active.past.formula;

import org.sj.verb.trilateral.augmented.*;
import org.sj.verb.util.ArabCharUtil;


public class AugmentedPastVerb2 extends AugmentedPastVerb {
    public AugmentedPastVerb2(AugmentedTrilateralRoot root, String lastDpa, String connectedPronoun) {
        super(root, lastDpa, connectedPronoun);
    }


    public String form() {
    String s=   root.getC1()+ ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SHADDA+ArabCharUtil.FATHA+root.getC3()+lastDpa+connectedPronoun;
        ////System.out.println(s);

  return s;
    }
}
