package org.sj.verb.trilateral.augmented.modifier.substituter.passive;

import java.util.*;
import org.sj.verb.trilateral.Substitution.*;
import org.sj.verb.trilateral.augmented.MazeedConjugationResult;
import org.sj.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import org.sj.verb.trilateral.augmented.modifier.substituter.AbstractGenericSubstituter;

public class GenericSubstituter5 extends AbstractGenericSubstituter {
  private List substitutions = new LinkedList();

  public GenericSubstituter5() {
    substitutions.add(new InfixSubstitution("زْت","زْد"));// EX: (ازْدُرِدَ)



  }

  public List getSubstitutions() {
    return substitutions;
  }

  public boolean isApplied(MazeedConjugationResult mazeedConjugationResult) {
    return mazeedConjugationResult. getRoot().getC1() == 'ز' && super.isApplied(mazeedConjugationResult);
  }
}
