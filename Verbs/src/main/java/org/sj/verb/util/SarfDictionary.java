package org.sj.verb.util;


import org.sj.verb.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import org.sj.verbs.VerbConjugaorApp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import database.DatabaseUtils;
import database.entity.Mazeed;
import database.entity.MujarradVerbs;
import database.entity.VerbsTriMazeedDictEntity;

public class SarfDictionary {
  private SarfDictionary() {
  }

  private static SarfDictionary instance = new SarfDictionary();

  public static SarfDictionary getInstance() {
    return instance;
  }

  public AugmentedTrilateralRoot getAugmentedTrilateralRoot(String rootText) {
    char c1 = rootText.charAt(0);
    char c2 = rootText.charAt(1);
    char c3 = rootText.charAt(2);
    List roots = new LinkedList();
    AugmentedTrilateralRoot augroot = new
          AugmentedTrilateralRoot();
    //  AugmentedTrilateralRootTree augmentedRootsTree = DatabaseManager.getInstance().getAugmentedTrilateralRootTree(c1);
    DatabaseUtils utils = new DatabaseUtils(VerbConjugaorApp.getContext());
    final ArrayList<VerbsTriMazeedDictEntity> triVerbMazeed = utils.getTriVerbMazeed(rootText);

    for (VerbsTriMazeedDictEntity root : triVerbMazeed) {
      roots.add(root.getRoots());
      augroot.setC1(root.getRoots().charAt(0));
      augroot.setC2(root.getRoots().charAt(1));
      augroot.setC3(root.getRoots().charAt(2));
      augroot.setForm(root.getForm());
      augroot.setBabname(root.getBabname());
      augroot.setVerbtype(root.getVerbtype());

      return augroot;
    }
    return null;
  }

  public AugmentedTrilateralRoot getAugmentedTrilateralRoot(String rootText,String formula) {
    char c1 = rootText.charAt(0);
    char c2 = rootText.charAt(1);
    char c3 = rootText.charAt(2);
    List roots = new LinkedList();
    AugmentedTrilateralRoot augroot = new
          AugmentedTrilateralRoot();
    //  AugmentedTrilateralRootTree augmentedRootsTree = DatabaseManager.getInstance().getAugmentedTrilateralRootTree(c1);
    DatabaseUtils utils = new DatabaseUtils(VerbConjugaorApp.getContext());
      ArrayList<Mazeed> triVerbMazeed = utils.getMazeedRoot(rootText);

    for (Mazeed root : triVerbMazeed) {
      if(root.getForm().equals(formula)) {
        roots.add(root.getRoot());
        augroot.setC1(root.getRoot().charAt(0));
        augroot.setC2(root.getRoot().charAt(1));
        augroot.setC3(root.getRoot().charAt(2));
        augroot.setForm(root.getForm());
        augroot.setBabname(root.getBabname());
        augroot.setVerbtype(root.getVerbtype());

        return augroot;
      }
    }
    return null;
  }
 /*
    Iterator iter = roots.iterator();
    while (iter.hasNext()) {
      AugmentedTrilateralRoot aRoot = (AugmentedTrilateralRoot) iter.next();
      if (aRoot.getC1() == c1 && aRoot.getC2() == c2 && aRoot.getC3() == c3) {
        return aRoot;
      }
    }
    return null;
  }
*/


 /*
  public List getUnaugmentedTrilateralRoots(String rootText) {
    char c1 = rootText.charAt(0);
    char c2 = rootText.charAt(1);
    char c3 = rootText.charAt(2);

    UnaugmentedTrilateralRootTree unaugmentedRootsTree = DatabaseManager.getInstance().getUnaugmentedTrilateralRootTree(c1);
    List roots = unaugmentedRootsTree.getRoots();
    java.util.List result = new LinkedList();
    Iterator iter = roots.iterator();
    while (iter.hasNext()) {
      UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) iter.next();
      if (root.getC1() == c1 && root.getC2() == c2 && root.getC3() == c3) {
        result.add(root);
      }
    }
    return result;
  }

  public AugmentedQuadriliteralRoot getAugmentedQuadrilateralRoot(String rootText) {
    char c1 = rootText.charAt(0);
    char c2 = rootText.charAt(1);
    char c3 = rootText.charAt(2);
    char c4 = rootText.charAt(3);

    AugmentedQuadriliteralRootTree augmentedRootsTree = null;
    try {
      augmentedRootsTree = DatabaseManager.getInstance().getAugmentedQuadriliteralRootTree(c1);
    }
    catch (Exception ex) {
      //?????????? ?????? ??????????
      return null;
    }
    List roots = augmentedRootsTree.getRoots();
    Iterator iter = roots.iterator();
    while (iter.hasNext()) {
      AugmentedQuadriliteralRoot aRoot = (AugmentedQuadriliteralRoot) iter.next();
      if (aRoot.getC1() == c1 && aRoot.getC2() == c2 && aRoot.getC3() == c3 && aRoot.getC4() == c4) {
        return aRoot;
      }
    }
    return null;
  }

  public UnaugmentedQuadriliteralRoot getUnaugmentedQuadrilateralRoot(String rootText) {
    char c1 = rootText.charAt(0);
    char c2 = rootText.charAt(1);
    char c3 = rootText.charAt(2);
    char c4 = rootText.charAt(3);

    UnaugmentedQuadriliteralRootTree rootsTree = null;
    try {
      rootsTree = DatabaseManager.getInstance().getUnaugmentedQuadriliteralRootTree(c1);
    }
    catch (Exception ex) {
      //?????????? ?????? ??????????
      return null;
    }
    java.util.List roots = rootsTree.getRoots();

    Iterator iter = roots.iterator();
    while (iter.hasNext()) {
      UnaugmentedQuadriliteralRoot aRoot = (UnaugmentedQuadriliteralRoot) iter.next();
      if (aRoot.getC1() == c1 && aRoot.getC2() == c2 && aRoot.getC3() == c3 && aRoot.getC4() == c4) {
        return aRoot;
      }
    }

    return null;
  }


  */


  public List getUnaugmentedTrilateralRootsLists(String rootText) {
    char c1 = rootText.charAt(0);
    char c2 = rootText.charAt(1);
    char c3 = rootText.charAt(2);
    java.util.List result = new LinkedList();
    DatabaseUtils utils = new DatabaseUtils(VerbConjugaorApp.getContext());
    final ArrayList<MujarradVerbs> mujarrad = utils.getMujarradVerbs(rootText);
    UnaugmentedTrilateralRoot unaugmentedTrilateralRoot=new UnaugmentedTrilateralRoot();
    //  UnaugmentedTrilateralRootTree unaugmentedRootsTree = DatabaseManager.getInstance().getUnaugmentedTrilateralRootTree(c1);
    for (MujarradVerbs trimujarrad : mujarrad) {



    unaugmentedTrilateralRoot.setC1(trimujarrad.getRoot().charAt(0));
    unaugmentedTrilateralRoot.setC2(trimujarrad.getRoot().charAt(1));
    unaugmentedTrilateralRoot.setC3(trimujarrad.getRoot().charAt(2));
    unaugmentedTrilateralRoot.setConjugation(trimujarrad.getBab());
    unaugmentedTrilateralRoot.setConjugationname(trimujarrad.getBabname());
    unaugmentedTrilateralRoot.setVerbtype(trimujarrad.getVerbtype());
    unaugmentedTrilateralRoot.setVerb(trimujarrad.getVerb());


    result.add(unaugmentedTrilateralRoot);
    }
  //  return unaugmentedTrilateralRoot;
    return result;
  }

  public UnaugmentedTrilateralRoot  getUnaugmentedTrilateralRoots(String rootText) {
    char c1 = rootText.charAt(0);
    char c2 = rootText.charAt(1);
    char c3 = rootText.charAt(2);
    DatabaseUtils utils = new DatabaseUtils(VerbConjugaorApp.getContext());
    final ArrayList<MujarradVerbs> trimujarrad = utils.getMujarradVerbs(rootText);
    UnaugmentedTrilateralRoot unaugmentedTrilateralRoot=new UnaugmentedTrilateralRoot();
  //  UnaugmentedTrilateralRootTree unaugmentedRootsTree = DatabaseManager.getInstance().getUnaugmentedTrilateralRootTree(c1);
    unaugmentedTrilateralRoot.setC1(trimujarrad.get(0).getRoot().charAt(0));
    unaugmentedTrilateralRoot.setC2(trimujarrad.get(0).getRoot().charAt(1));
    unaugmentedTrilateralRoot.setC3(trimujarrad.get(0).getRoot().charAt(2));
    unaugmentedTrilateralRoot.setConjugation(trimujarrad.get(0).getBab());
    unaugmentedTrilateralRoot.setConjugationname(trimujarrad.get(0).getBabname());
    unaugmentedTrilateralRoot.setVerbtype(trimujarrad.get(0).getVerbtype());
    unaugmentedTrilateralRoot.setVerb(trimujarrad.get(0).getVerb());
    unaugmentedTrilateralRoot.setRulename(trimujarrad.get(0).getKovname());
    java.util.List result = new LinkedList();
    result.add(unaugmentedTrilateralRoot);
     return unaugmentedTrilateralRoot;
   // return result;
  }

  public UnaugmentedTrilateralRoot  getUnaugmentedTrilateralRoots(String rootText,String formula) {
    char c1 = rootText.charAt(0);
    char c2 = rootText.charAt(1);
    char c3 = rootText.charAt(2);
    DatabaseUtils utils = new DatabaseUtils(VerbConjugaorApp.getContext());
    final ArrayList<MujarradVerbs> trimujarrad = utils.getMujarradVerbs(rootText);
    UnaugmentedTrilateralRoot unaugmentedTrilateralRoot=new UnaugmentedTrilateralRoot();

    for (MujarradVerbs tri : trimujarrad) {
      if(tri.getBab().equals(formula)){

        unaugmentedTrilateralRoot.setC1(tri.getRoot().charAt(0));
        unaugmentedTrilateralRoot.setC2(tri.getRoot().charAt(1));
        unaugmentedTrilateralRoot.setC3(tri.getRoot().charAt(2));
        unaugmentedTrilateralRoot.setConjugation(tri.getBab());
        unaugmentedTrilateralRoot.setConjugationname(tri.getBabname());
        unaugmentedTrilateralRoot.setVerbtype(tri.getVerbtype());
        unaugmentedTrilateralRoot.setVerb(tri.getVerb());

      }

    }


    //  UnaugmentedTrilateralRootTree unaugmentedRootsTree = DatabaseManager.getInstance().getUnaugmentedTrilateralRootTree(c1);

    java.util.List result = new LinkedList();
    result.add(unaugmentedTrilateralRoot);
    return unaugmentedTrilateralRoot;
    // return result;
  }


}
