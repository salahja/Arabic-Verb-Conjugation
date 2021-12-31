package org.sj.verb.trilateral.augmented.modifier.substituter.active;


import java.util.*;
import org.sj.verb.trilateral.Substitution.*;
import org.sj.verb.trilateral.augmented.MazeedConjugationResult;
import org.sj.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import org.sj.verb.trilateral.augmented.modifier.substituter.AbstractGenericSubstituter;


public class SpecialSubstituter1 extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
  private List substitutions = new LinkedList();

  public SpecialSubstituter1() {
    substitutions.add(new InfixSubstitution("وْتَ","تَّ"));// EX: (اتَّصَلَ، يَتَّصِلُ، اتَّصِلْ)

  }

  public List getSubstitutions() {
    return substitutions;
  }

  public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
    int kov = mazeedConjugationResult.getKov();
    int formulaNo = mazeedConjugationResult.getFormulaNo();
    return mazeedConjugationResult. getRoot().getC1() == 'و' && formulaNo == 5 && (kov == 9 || kov == 10 || kov == 11 || kov == 29 || kov == 30);
  }
}
