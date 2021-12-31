package org.sj.noun.trilateral.augmented.activeparticiple;

import static org.sj.verb.util.ArabCharUtil.MEEM;

import org.sj.noun.trilateral.augmented.*;
import org.sj.verb.util.ArabCharUtil;
import org.sj.verb.trilateral.augmented.*;

public class NounFormula1 extends AugmentedTrilateralNoun {
    public NounFormula1(AugmentedTrilateralRoot root, String suffix) {
        super(root, suffix);
    }


    public String form() {
        return MEEM+ArabCharUtil.DAMMA+root.getC1()+ ArabCharUtil.SKOON+root.getC2()+ArabCharUtil.KASRA+root.getC3()+suffix;
    }
}
