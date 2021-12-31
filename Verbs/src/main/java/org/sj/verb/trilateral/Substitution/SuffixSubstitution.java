package org.sj.verb.trilateral.Substitution;

import org.sj.verb.trilateral.TrilateralRoot;

public class SuffixSubstitution extends Substitution {

    public SuffixSubstitution(String segment, String result) {
        super(segment, result);
    }


    public String apply(String word, TrilateralRoot root) {
        if (word.endsWith(segment)) {
            int changeIndex = word.lastIndexOf(segment);
            //String replacement = word.substring(changeIndex, word.length());
            //replacement.replaceAll(segment, result);
            return word.substring(0,changeIndex) + result;
        }
        return  null;
    }
}
