package org.sj.verb.trilateral.augmented.modifier.substituter.active;

import java.util.*;
import org.sj.verb.trilateral.Substitution.*;
import org.sj.verb.trilateral.augmented.MazeedConjugationResult;
import org.sj.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import org.sj.verb.trilateral.augmented.modifier.substituter.AbstractGenericSubstituter;

public  class GenericSubstituter6 extends AbstractGenericSubstituter {
  private List substitutions = new LinkedList();

  public GenericSubstituter6() {
    substitutions.add(new InfixSubstitution("صْتَ","صْطَ"));// EX: (اصْطَبَر، يَصْطَبِرُ، اصْطَبِرْ)

  }

  public List getSubstitutions() {
    return substitutions;
  }

  public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
    return mazeedConjugationResult. getRoot().getC1() == 'ص' && super.isApplied(mazeedConjugationResult);
  }
}
