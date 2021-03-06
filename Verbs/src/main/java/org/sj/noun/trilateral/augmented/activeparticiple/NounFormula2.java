package org.sj.noun.trilateral.augmented.activeparticiple;

 ;
import org.sj.verb.util.ArabCharUtil;
import org.sj.noun.trilateral.augmented.*;
 import org.sj.verb.trilateral.augmented.*;

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
public class NounFormula2 extends AugmentedTrilateralNoun {
    public NounFormula2(AugmentedTrilateralRoot root, String suffix) {
        super(root, suffix);
    }

    /**
     * form
     *
     * @return String
     * @todo Implement this sarf.noun.trilateral.TrilateralNoun method
     */
    public String form() {
        return ArabCharUtil.MEEM+ArabCharUtil.DAMMA+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SHADDA+ArabCharUtil.KASRA+root.getC3()+suffix;
    }
}
