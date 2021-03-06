package org.sj.noun;

import java.util.*;

import org.sj.noun.trilateral.unaugmented.exaggeration.StandardExaggerationConjugator;
import org.sj.verb.trilateral.unaugmented.*;

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
public class TrilateralUnaugmentedNouns {

   //������ ����� ������
    private List standardExaggerations;
    private List nonStandardExaggerations;
    //����� ������ �������
    private List timeAndPlaces;

    //����� �����
    private List standardInstrumentals;
    private List nonStandardInstrumentals;

    //����� �������
    private List elatives;
    //������ �������
    private List assimilates;

    private UnaugmentedTrilateralRoot root;

    public TrilateralUnaugmentedNouns(UnaugmentedTrilateralRoot root) {
        standardExaggerations = StandardExaggerationConjugator.getInstance().getAppliedFormulaList(root);
        nonStandardExaggerations = org.sj.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationConjugator.getInstance().getAppliedFormulaList(root);

        timeAndPlaces = org.sj.noun.trilateral.unaugmented.timeandplace.TimeAndPlaceConjugator.getInstance().getAppliedFormulaList(root);

        standardInstrumentals = org.sj.noun.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator.getInstance().getAppliedFormulaList(root);
        nonStandardInstrumentals = org.sj.noun.trilateral.unaugmented.instrumental.NonStandardInstrumentalConjugator.getInstance().getAppliedFormulaList(root);

        elatives = org.sj.noun.trilateral.unaugmented.elative.ElativeNounConjugator.getInstance().getAppliedFormulaList(root);
        assimilates = org.sj.noun.trilateral.unaugmented.assimilate.AssimilateAdjectiveConjugator.getInstance().getAppliedFormulaList(root);
    }

    public List getAssimilates() {
        return assimilates;
    }

    public List getElatives() {
        return elatives;
    }

    public List getNonStandardExaggerations() {
        return nonStandardExaggerations;
    }

    public List getNonStandardInstrumentals() {
        return nonStandardInstrumentals;
    }

    public UnaugmentedTrilateralRoot getRoot() {
        return root;
    }

    public List getStandardExaggerations() {
        return standardExaggerations;
    }

    public List getStandardInstrumentals() {
        return standardInstrumentals;
    }

    public List getTimeAndPlaces() {
        return timeAndPlaces;
    }
}

