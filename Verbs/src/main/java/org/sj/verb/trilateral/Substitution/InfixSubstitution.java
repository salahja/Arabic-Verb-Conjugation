package org.sj.verb.trilateral.Substitution;

import org.sj.verb.trilateral.TrilateralRoot;

public class InfixSubstitution extends Substitution {

    public InfixSubstitution(String segment, String result) {
        super(segment, result);
    }

    public String apply(String word, TrilateralRoot root) {
        return word.indexOf(segment) != -1? word.replaceAll(segment,result): null;
    }
}
