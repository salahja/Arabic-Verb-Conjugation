package org.sj.verb.trilateral.augmented.imperative;

import org.sj.verb.util.*;


public class AugmentedImperativeConjugator {
    private AugmentedImperativeConjugator() {}

    private static AugmentedImperativeConjugator instance = new AugmentedImperativeConjugator();

    private AbstractAugmentedImperativeConjugator notEmphsizedConjugator = new AbstractAugmentedImperativeConjugator(ImperativeConjugationDataContainer.getInstance().getLastDimList(), ImperativeConjugationDataContainer.getInstance().getConnectedPronounList());
    private AbstractAugmentedImperativeConjugator emphsizedConjugator = new AbstractAugmentedImperativeConjugator(ImperativeConjugationDataContainer.getInstance().getEmphasizedLastDimList(), ImperativeConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList());

    public static AugmentedImperativeConjugator getInstance() {
        return instance;
    }

    public AbstractAugmentedImperativeConjugator getEmphsizedConjugator() {
        return emphsizedConjugator;
    }

    public AbstractAugmentedImperativeConjugator getNotEmphsizedConjugator() {
        return notEmphsizedConjugator;
    }
}
