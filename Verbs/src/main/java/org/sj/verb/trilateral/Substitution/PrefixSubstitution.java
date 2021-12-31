package org.sj.verb.trilateral.Substitution;

import org.sj.verb.trilateral.TrilateralRoot;

public class PrefixSubstitution extends Substitution {

    public PrefixSubstitution(String segment, String result) {
        super(segment, result);
    }

    public String apply(String word, TrilateralRoot root) {
        return word.startsWith(segment)? word.replaceFirst(segment,result): null;
    }
}
