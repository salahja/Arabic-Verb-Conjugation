package org.sj.verbs;

import androidx.annotation.NonNull;

import org.sj.noun.GenericNounSuffixContainer;
import org.sj.noun.INounSuffixContainer;
import org.sj.noun.TrilateralUnaugmentedNouns;
import org.sj.noun.trilateral.augmented.AugmentedTrilateralActiveParticipleConjugator;
import org.sj.noun.trilateral.augmented.AugmentedTrilateralPassiveParticipleConjugator;
import org.sj.noun.trilateral.augmented.modifier.activeparticiple.ActiveParticipleModifier;
import org.sj.noun.trilateral.unaugmented.UnaugmentedTrilateralActiveParticipleConjugator;
import org.sj.noun.trilateral.unaugmented.UnaugmentedTrilateralPassiveParticipleConjugator;
import org.sj.noun.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator;
import org.sj.noun.trilateral.unaugmented.modifier.instrumental.InstrumentalModifier;
import org.sj.noun.trilateral.unaugmented.modifier.passiveparticiple.PassiveParticipleModifier;
import org.sj.noun.trilateral.unaugmented.modifier.timeandplace.TimeAndPlaceModifier;
import org.sj.noun.trilateral.unaugmented.timeandplace.TimeAndPlaceConjugator;
import org.sj.verb.trilateral.augmented.AugmentedTrilateralRoot;
import org.sj.verb.trilateral.augmented.MazeedConjugationResult;
import org.sj.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import org.sj.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator;
import org.sj.verb.trilateral.augmented.imperative.AugmentedImperativeConjugator;
import org.sj.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import org.sj.verb.trilateral.augmented.passive.past.AugmentedPassivePastConjugator;
import org.sj.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator;
import org.sj.verb.trilateral.unaugmented.ConjugationResult;
import org.sj.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import org.sj.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import org.sj.verb.util.KovRulesManager;
import org.sj.verb.util.SarfDictionary;
import org.sj.verb.util.TrilateralKovRule;
import org.sj.verbs.activity.SystemConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GatherAll {


  public GatherAll() {
  }

  private static final GatherAll instance = new GatherAll();

  public static GatherAll getInstance() {
    return instance;
  }

  public ArrayList<ArrayList> getMujarradListing(String verbmood, String verbroot, String unaugmentedFormula) {
    ArrayList<ArrayList> skabeer = buildUnaugmentedLists(verbmood, verbroot,unaugmentedFormula);
 //   return skabeer;

    return buildUnaugmentedLists(verbmood, verbroot,unaugmentedFormula);
  }
  public ArrayList<ArrayList> getMujarradListing(String verbmood, String verbroot) {
    return buildUnaugmentedLists(verbmood, verbroot);
  }
  public ArrayList<ArrayList> getMazeedListing(String verbmood, String verbroot) {
    return buildAugmentedLists(verbmood, verbroot);
  }

  public ArrayList<ArrayList> getMujarradParticiple(String verbmood, String verbroot, String unaugmentedFormula) {
    return buildUnAugmentedParticpleList(verbmood, verbroot,unaugmentedFormula);
  }
  public ArrayList<ArrayList> getMujarradIsmAla(String verbmood, String verbroot, String unaugmentedFormula) {
    return buildUnAugmentedNounofInstrument(verbmood, verbroot,unaugmentedFormula);

  }

  public ArrayList<ArrayList> getMujarradZarf(String verbmood, String verbroot, String unaugmentedFormula) {
    return buildUnAugmentedNounofTimeAndPlace(verbmood, verbroot,unaugmentedFormula);
  }
  private ArrayList<ArrayList> origbuildUnAugmentedNounofTimeAndPlace(String verbmood, String verbroot, String unaugmentedFormula) {

    ArrayList<ArrayList> skabeer = new ArrayList<>();
    char c1 = verbroot.charAt(0);
    char c2 = verbroot.charAt(1);
    char c3 = verbroot.charAt(2);
    Character C1 = verbroot.charAt(0);
    Character C2 = verbroot.charAt(1);
    Character C3 = verbroot.charAt(2);

    List  lzarf ;

    TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
    final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(verbroot,unaugmentedFormula);

   /*
    "A" -> "??????????????"
"B" -> "??????????????"
"C" -> "??????????????????"
     */
    TimeAndPlaceConjugator zarfconjugator = TimeAndPlaceConjugator.getInstance();
    TimeAndPlaceModifier zarfmodifier = TimeAndPlaceModifier.getInstance();
    List mafalconjuationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "??????????????");
    org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult mafal = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalconjuationlist, "??????????????");
    List zarfinalmafal = mafal.getFinalResult();

    List mafilconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "??????????????");
    org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult mafil = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafilconjugationlist, "??????????????");
    List zarffinalmafil = mafal.getFinalResult();

    List mafalatunconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "??????????????????");
    org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult mafalatun = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalatunconjugationlist, "??????????????????");
    List zarffinalmafalatun = mafal.getFinalResult();



    List<String> zarfmafal = new ArrayList<>();
    List<String> zarfmafil = new ArrayList<>();
    List<String> zarfmafalatun = new ArrayList<>();
    List<String> all = new ArrayList<>();
    all.addAll(  zarfinalmafal);
    all.addAll(zarffinalmafalatun);
    all.addAll(zarffinalmafil);
    skabeer.add((ArrayList) all);

    return skabeer;
  }
  private ArrayList<ArrayList> buildUnAugmentedNounofTimeAndPlace(String verbmood, String verbroot, String unaugmentedFormula) {

    ArrayList<ArrayList> skabeer = new ArrayList<>();
    char c1 = verbroot.charAt(0);
    char c2 = verbroot.charAt(1);
    char c3 = verbroot.charAt(2);
    Character C1 = verbroot.charAt(0);
    Character C2 = verbroot.charAt(1);
    Character C3 = verbroot.charAt(2);

    List  lzarf ;

    TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
    final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(verbroot,unaugmentedFormula);
   /*
    "A" -> "??????????????"
"B" -> "??????????????"
"C" -> "??????????????????"
     */
    TrilateralUnaugmentedNouns nounsObject = new TrilateralUnaugmentedNouns(unaugmentedTrilateralRoot);
    List timeAndPlaces = nounsObject.getTimeAndPlaces();

    TimeAndPlaceConjugator zarfconjugator = TimeAndPlaceConjugator.getInstance();
    TimeAndPlaceModifier zarfmodifier = TimeAndPlaceModifier.getInstance();
    List mafalconjuationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "??????????????");
    org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult mafal = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalconjuationlist, "??????????????");
    List zarfinalmafal = mafal.getFinalResult();

    List mafilconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "??????????????");
    org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult mafil = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafilconjugationlist, "??????????????");
    List zarffinalmafil = mafil.getFinalResult();

    List mafalatunconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "??????????????????");
    org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult mafalatun = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalatunconjugationlist, "??????????????????");
    List zarffinalmafalatun = mafalatun.getFinalResult();



    List<String> zarfmafal = new ArrayList<>();
    List<String> zarfmafil = new ArrayList<>();
    List<String> zarfmafalatun = new ArrayList<>();

    for (Object s : zarfinalmafal) {
      if(s.toString().length()>0){
        zarfmafal.add(s.toString());
      }

    }

    for (Object s : zarffinalmafil) {
      if(s.toString().length()>0){
        zarfmafil.add(s.toString());
      }

    }

    for (Object s : zarffinalmafalatun) {
      if(s.toString().length()>0){
        zarfmafalatun.add(s.toString());
      }

    }
    List<String> all = new ArrayList<>();


    skabeer.add((ArrayList) zarfmafal);
    skabeer.add((ArrayList) zarfmafil);
    skabeer.add((ArrayList) zarfmafalatun);
    return skabeer;
  }
  private ArrayList<ArrayList> OringbuildUnAugmentedNounofInstrument(String verbmood, String verbroot, String unaugmentedFormula) {
    ArrayList<ArrayList> skabeer = new ArrayList<>();
    char c1 = verbroot.charAt(0);
    char c2 = verbroot.charAt(1);
    char c3 = verbroot.charAt(2);
    Character C1 = verbroot.charAt(0);
    Character C2 = verbroot.charAt(1);
    Character C3 = verbroot.charAt(2);
    List  ismMifalMifaltun ;
    List  ismMifaaal,lzarf ;

    TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
    final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(verbroot,unaugmentedFormula);

// amr.removeAll(Collections.singleton(null));


    List  standardInstrumentals = org.sj.noun.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator.getInstance().getAppliedFormulaList(unaugmentedTrilateralRoot);
    TrilateralUnaugmentedNouns nounsObject = new TrilateralUnaugmentedNouns(unaugmentedTrilateralRoot);
    List timeAndPlaces = nounsObject.getTimeAndPlaces();
    /*
    0 = "??????????????"
1 = "??????????????????"
2 = "????????????????"
3 = "??????????????????"
     */



    StandardInstrumentalConjugator conjugator = StandardInstrumentalConjugator.getInstance();
    InstrumentalModifier modifier = InstrumentalModifier.getInstance();
    GenericNounSuffixContainer instance = GenericNounSuffixContainer.getInstance();
    //  final IUnaugmentedTrilateralNounConjugator conjugator =new
    //   final IUnaugmentedTrilateralNounModifier modifier = null;
    final INounSuffixContainer nounSuffixContainer;
    final String title="??????????????????";

    List mifal = conjugator.createNounList(unaugmentedTrilateralRoot, "??????????????");
    ConjugationResult conjResultmifal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifal, "??????????????");
    List finalmifal = conjResultmifal.getFinalResult();

    List mifalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "??????????????????");
    ConjugationResult conjResult = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifalatun, "??????????????????");
    List finalmifalatun = conjResult.getFinalResult();


    List mifaal = conjugator.createNounList(unaugmentedTrilateralRoot, "????????????????");
    ConjugationResult conjResultmifaal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifaal, "????????????????");
    List finalmifaal = conjResultmifaal.getFinalResult();

    List faalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "??????????????????");
    ConjugationResult conjResultfaalatun = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), faalatun, "??????????????????");
    List finalfaalatun = conjResultfaalatun.getFinalResult();







    //skabeer.add((ArrayList) mifalmifaltun);
    skabeer.add((ArrayList) finalmifaal);
    return skabeer;
  }

  private ArrayList<ArrayList> buildUnAugmentedNounofInstrument(String verbmood, String verbroot, String unaugmentedFormula) {
    ArrayList<ArrayList> skabeer = new ArrayList<>();
    char c1 = verbroot.charAt(0);
    char c2 = verbroot.charAt(1);
    char c3 = verbroot.charAt(2);


    TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
    final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(verbroot,unaugmentedFormula);

// amr.removeAll(Collections.singleton(null));


    List  standardInstrumentals = org.sj.noun.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator.getInstance().getAppliedFormulaList(unaugmentedTrilateralRoot);
    TrilateralUnaugmentedNouns nounsObject = new TrilateralUnaugmentedNouns(unaugmentedTrilateralRoot);
    List timeAndPlaces = nounsObject.getTimeAndPlaces();
    /*
    0 = "??????????????"
1 = "??????????????????"
2 = "????????????????"
3 = "??????????????????"
     */



    StandardInstrumentalConjugator conjugator = StandardInstrumentalConjugator.getInstance();
    InstrumentalModifier modifier = InstrumentalModifier.getInstance();
    GenericNounSuffixContainer instance = GenericNounSuffixContainer.getInstance();



    List mifal = conjugator.createNounList(unaugmentedTrilateralRoot, "??????????????");
    ConjugationResult conjResultmifal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifal, "??????????????");
    List finalAlamifal = conjResultmifal.getFinalResult();

    List mifalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "??????????????????");
    ConjugationResult conjResult = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifalatun, "??????????????????");
    List finalAlamifalatun = conjResult.getFinalResult();


    List mifaal = conjugator.createNounList(unaugmentedTrilateralRoot, "????????????????");
    ConjugationResult conjResultmifaal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifaal, "????????????????");
    List finalAlamifaal = conjResultmifaal.getFinalResult();

    List faalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "??????????????????");
    ConjugationResult conjResultfaalatun = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), faalatun, "??????????????????");
    List finalfaalatun = conjResultfaalatun.getFinalResult();






    List<String> alamifal = new ArrayList<>();
    List<String> alamifalatun = new ArrayList<>();
    List<String> alamifaal = new ArrayList<>();



    for (Object s : finalAlamifal) {
      if(s.toString().length()>0){
        alamifal.add(s.toString());
      }

    }

    for (Object s : finalAlamifalatun) {
      if(s.toString().length()>0){
        alamifalatun.add(s.toString());
      }

    }

    for (Object s : finalAlamifaal) {
      if(s.toString().length()>0){
        alamifaal.add(s.toString());
      }

    }


    skabeer.add((ArrayList) alamifal);
    skabeer.add((ArrayList) alamifalatun);
    skabeer.add((ArrayList) alamifaal);
return skabeer;
  }














  private ArrayList<ArrayList> buildUnAugmentedParticpleList(String verbmood, String verbroot, String unaugmentedFormula) {
    ArrayList<ArrayList> skabeer = new ArrayList<>();
    char c1 = verbroot.charAt(0);
    char c2 = verbroot.charAt(1);
    char c3 = verbroot.charAt(2);


    TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
    final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(verbroot,unaugmentedFormula);

    //ismfale and ismmafool
    List conjugatedIsmFael = UnaugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
            unaugmentedTrilateralRoot.getConjugation());


    final org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult conjugationResult = org.sj.noun.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier.
            getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmFael, "");

    final List finalIsmFael = conjugationResult.getFinalResult();


    List conjugatedIsmMafool = UnaugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
            unaugmentedTrilateralRoot.getConjugation());


    final org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult ismmafoolresult =
            PassiveParticipleModifier.
                    getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmMafool, "");
    final List ismmafoolresultFinalResult = ismmafoolresult.getFinalResult();


    List<String> listismfael = new ArrayList<>();
    List<String> listismmafool = new ArrayList<>();


    List<String> vdetails=new ArrayList<>();
    vdetails.add(String.valueOf(rule.getDesc()));
    vdetails.add(unaugmentedTrilateralRoot.getConjugationname());
    // vdetails.add(unaugmentedTrilateralRoot.getVerb());
    vdetails.add(verbroot);


    for (Object s : finalIsmFael) {
      listismfael.add(s.toString());

    }
    for (Object s : ismmafoolresultFinalResult) {
      listismmafool.add(s.toString());

    }














    skabeer.add((ArrayList) listismfael);
    skabeer.add((ArrayList) listismmafool);


    //  skabeer.add((ArrayList) strings);
    return skabeer;


  }

  public ArrayList<String> getMujarradSarfSagheer(String verbmood, String verbroot,String unaugmentedFormula) {
    ArrayList<ArrayList> skabeer = buildUnaugmentedLists(verbmood, verbroot, unaugmentedFormula);



    return skabeer.get(0);
  }

  public ArrayList<ArrayList> getMazeedListing(String verbmood, String verbroot, String augmentedFormula) {


    return buildAugmentedLists(verbmood, verbroot,augmentedFormula);
  }






  @NonNull
  private ArrayList<ArrayList> buildUnaugmentedLists(String verbmood, String verbroot ) {
    ArrayList<ArrayList> skabeer = new ArrayList<>();
    char c1 = verbroot.charAt(0);
    char c2 = verbroot.charAt(1);
    char c3 = verbroot.charAt(2);


    List madhimajhool;
    List mudharay = null;
    List amr,nahiamr;
    List madhi;
    List mudharaymajhool = null;

    TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
    final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(verbroot);

    //   madhi = org.sj.verb.trilateral.unaugmented.active.ActivePastConjugator.getInstance().createVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
    madhi = org.sj.verb.trilateral.unaugmented.active.ActivePastConjugator.getInstance().createVerbList(unaugmentedTrilateralRoot);
    final ConjugationResult build = UnaugmentedTrilateralModifier.getInstance()
            .build(unaugmentedTrilateralRoot, rule.getKov(), madhi,
                    SystemConstants.PAST_TENSE, true, true);
    final List finalResult1 = build.getFinalResult();
    madhimajhool = org.sj.verb.trilateral.unaugmented.passive.PassivePastConjugator.getInstance().createVerbList(unaugmentedTrilateralRoot);


    switch (verbmood) {
      case "Indicative":


        mudharay = org.sj.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                createNominativeVerbList(unaugmentedTrilateralRoot);


        mudharaymajhool = org.sj.verb.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                createNominativeVerbList(unaugmentedTrilateralRoot);
        break;
      case "Subjunctive":

        mudharay = org.sj.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                createAccusativeVerbList(unaugmentedTrilateralRoot);


        mudharaymajhool = org.sj.verb.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                createAccusativeVerbList(unaugmentedTrilateralRoot);

        break;
      case "Jussive":

        mudharay = org.sj.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                createJussiveVerbList(unaugmentedTrilateralRoot);


        mudharaymajhool = org.sj.verb.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                createJussiveVerbList(unaugmentedTrilateralRoot);

        break;
      case "Emphasized":

        mudharay = org.sj.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                createEmphasizedVerbList(unaugmentedTrilateralRoot);


        mudharaymajhool = org.sj.verb.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                createEmphasizedVerbList(unaugmentedTrilateralRoot);

        break;
    }

    nahiamr = org.sj.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
            createJussiveVerbList(unaugmentedTrilateralRoot);
    amr = org.sj.verb.trilateral.unaugmented.UnaugmentedImperativeConjugator.getInstance().createVerbList(unaugmentedTrilateralRoot);

    //    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String tense, boolean active, boolean applyGemination) {

    //   result =  AugmentedActivePastConjugator.getInstance().createVerbList(augmentedRoot, getForm());
    final ConjugationResult madhiconjresult = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), madhi,

            SystemConstants.PAST_TENSE, true, true);
    final ConjugationResult madhimajhoolconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), madhimajhool,

            SystemConstants.PAST_TENSE, false, true);

    final ConjugationResult mudharayconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), mudharay,

            SystemConstants.PRESENT_TENSE, true, true);

    final ConjugationResult mudharaymajhoolconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), mudharaymajhool,

            SystemConstants.PRESENT_TENSE, false, true);

    final ConjugationResult amrconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), amr,
            SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, true);
    final ConjugationResult nahiamrconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), nahiamr,

            SystemConstants.PRESENT_TENSE, true, true);

    //ismfale and ismmafool
    List conjugatedIsmFael = UnaugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
            unaugmentedTrilateralRoot.getConjugation());


    final org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult conjugationResult = org.sj.noun.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier.
            getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmFael, "");

    final List finalIsmFael = conjugationResult.getFinalResult();


    List conjugatedIsmMafool = UnaugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
            unaugmentedTrilateralRoot.getConjugation());


    final org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult ismmafoolresult =
            PassiveParticipleModifier.
                    getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmMafool, "");
    final List ismmafoolresultFinalResult = ismmafoolresult.getFinalResult();


    ///ismala
    /*
    0 = "??????????????"
1 = "??????????????????"
2 = "????????????????"
3 = "??????????????????"
     */



    StandardInstrumentalConjugator conjugator = StandardInstrumentalConjugator.getInstance();
    InstrumentalModifier modifier = InstrumentalModifier.getInstance();
    GenericNounSuffixContainer instance = GenericNounSuffixContainer.getInstance();


    List mifal = conjugator.createNounList(unaugmentedTrilateralRoot, "??????????????");
    ConjugationResult conjResultmifal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifal, "??????????????");
    List finalAlamifal = conjResultmifal.getFinalResult();

    List mifalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "??????????????????");
    ConjugationResult conjResult = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifalatun, "??????????????????");
    List finalAlamifalatun = conjResult.getFinalResult();


    List mifaal = conjugator.createNounList(unaugmentedTrilateralRoot, "????????????????");
    ConjugationResult conjResultmifaal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifaal, "????????????????");
    List finalAlamifaal = conjResultmifaal.getFinalResult();

    List faalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "??????????????????");
    ConjugationResult conjResultfaalatun = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), faalatun, "??????????????????");
    List finalfaalatun = conjResultfaalatun.getFinalResult();
    //zarf
    TimeAndPlaceConjugator zarfconjugator = TimeAndPlaceConjugator.getInstance();
    TimeAndPlaceModifier zarfmodifier = TimeAndPlaceModifier.getInstance();
    List mafalconjuationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "??????????????");
    org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult mafal = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalconjuationlist, "??????????????");
    List zarfinalmafal = mafal.getFinalResult();

    List mafilconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "??????????????");
    org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult mafil = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafilconjugationlist, "??????????????");
    List zarffinalmafil = mafil.getFinalResult();

    List mafalatunconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "??????????????????");
    org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult mafalatun = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalatunconjugationlist, "??????????????????");
    List zarffinalmafalatun = mafalatun.getFinalResult();
















    madhi = madhiconjresult.getFinalResult();
    madhimajhool = madhimajhoolconj.getFinalResult();
    mudharay = mudharayconj.getFinalResult();
    mudharaymajhool = mudharaymajhoolconj.getFinalResult();
    amr = amrconj.getFinalResult();
    nahiamr=nahiamrconj.getFinalResult();
    amr.removeAll(Collections.singleton(null));

    String la="????";


    final List list = nahiamr.subList(6, 11);
    ArrayList<String> nm=new ArrayList<>();


    StringBuilder sb;
    for (Object o : list) {
      sb=new StringBuilder();
      nm.add( sb.append(la).append(" ").append(o.toString()).toString());

    }


    List<String> listmadhi = new ArrayList<>();
    List<String> listmadhimajhool = new ArrayList<>();
    List<String> listmudharay = new ArrayList<>();
    List<String> listmudharymajhool = new ArrayList<>();
    List<String> listamr = new ArrayList<>();
    List<String> listamrnahi = new ArrayList<>();
    List<String> listismfael = new ArrayList<>();
    List<String> listismmafool = new ArrayList<>();
    List<String> listmifal = new ArrayList<>();
    List<String> listmifalatun = new ArrayList<>();
    List<String> listlmifaal = new ArrayList<>();
    List<String> listlzarfmafal = new ArrayList<>();
    List<String> listlzarfmafil = new ArrayList<>();
    List<String> listlzarfmafalatun = new ArrayList<>();

    for (Object s : finalAlamifal) {
      if(s.toString().length()>0){
        listmifal.add(s.toString());
      }

    }

    for (Object s : finalAlamifalatun) {
      if(s.toString().length()>0){
        listmifalatun.add(s.toString());
      }

    }

    for (Object s : finalAlamifaal) {
      if(s.toString().length()>0){
        listlmifaal.add(s.toString());
      }

    }

    for (Object s : zarffinalmafil) {
      if(s.toString().length()>0) {
        listlzarfmafal.add(s.toString());
      }
    }

    for (Object s : zarffinalmafil) {
      if(s.toString().length()>0) {
        listlzarfmafil.add(s.toString());
      }
    }

    for (Object s : zarffinalmafalatun) {
      if(s.toString().length()>0) {
        listlzarfmafalatun.add(s.toString());
      }
    }


    for (Object s : madhi) {
      listmadhi.add(s.toString());

    }
    for (Object s : madhimajhool) {
      try {
        listmadhimajhool.add(s.toString());

      } catch (NullPointerException e){

        listmadhimajhool.add("-");
      }


    }


    for (Object s : mudharay) {
      listmudharay.add(s.toString());

    }
    for (Object s : mudharaymajhool) {


      try {
        listmudharymajhool.add(s.toString());

      } catch (NullPointerException e){

        listmudharymajhool.add("-");
      }


    }
    for (Object s : finalIsmFael) {
      listismfael.add(s.toString());

    }
    for (Object s : ismmafoolresultFinalResult) {
      listismmafool.add(s.toString());

    }


    for (Object s : amr) {
      listamr.add(s.toString());

    }
    for (Object s : nm) {
      listamrnahi.add(s.toString());

    }



    List<String> vdetails=new ArrayList<>();
    vdetails.add(rule.getDesc());
    vdetails.add(unaugmentedTrilateralRoot.getConjugationname());

    vdetails.add(verbroot);

    vdetails.add(listmadhi.get(0));
    vdetails.add(listmadhimajhool.get(0));
    vdetails.add(listmudharay.get(0));
    vdetails.add(listmudharymajhool.get(0));
    vdetails.add(listamr.get(0));
    vdetails.add(listamrnahi.get(0));
    vdetails.add(listismfael.get(0));

    vdetails.add(listismmafool.get(0));
    vdetails.add(listmifal.get(0));
    vdetails.add(listmifalatun.get(0));
    vdetails.add(listlmifaal.get(0));
    // vdetails.add(listlmifaal.get(0));
    vdetails.add(listlzarfmafal.get(0));
    vdetails.add(listlzarfmafil.get(0));
    vdetails.add(listlzarfmafalatun.get(0));
    vdetails.add("mujarrad");
    vdetails.add(unaugmentedTrilateralRoot.getConjugation());
    skabeer.add((ArrayList) vdetails);
    skabeer.add((ArrayList) listmadhi);
    skabeer.add((ArrayList) listmadhimajhool);
    skabeer.add((ArrayList) listmudharay);
    skabeer.add((ArrayList) listmudharymajhool);
    skabeer.add((ArrayList) listamr);
    skabeer.add((ArrayList) listamrnahi);

    skabeer.add((ArrayList) listismfael);
    skabeer.add((ArrayList) listismmafool);

    skabeer.add((ArrayList) listmifal);
    skabeer.add((ArrayList) listlmifaal);
    skabeer.add((ArrayList) listmifalatun);
    skabeer.add((ArrayList) listlzarfmafal);
    skabeer.add((ArrayList) listlzarfmafil);
    skabeer.add((ArrayList) listlzarfmafalatun);
    List<String> strings = new ArrayList<>(madhi.size());

    //  skabeer.add((ArrayList) strings);
    return skabeer;
  }
  @NonNull
  private ArrayList<ArrayList> buildUnaugmentedLists(String verbmood, String verbroot, String unaugmentedFormula) {
    ArrayList<ArrayList> skabeer = new ArrayList<>();
    char c1 = verbroot.charAt(0);
    char c2 = verbroot.charAt(1);
    char c3 = verbroot.charAt(2);


    List madhimajhool;
    List mudharay = null;
    List amr,nahiamr;
    List madhi;
    List mudharaymajhool = null;

    TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
    final UnaugmentedTrilateralRoot unaugmentedTrilateralRoot = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(verbroot,unaugmentedFormula);

    //   madhi = org.sj.verb.trilateral.unaugmented.active.ActivePastConjugator.getInstance().createVerbList((UnaugmentedTrilateralRoot) unaugmentedTrilateralRoot);
    madhi = org.sj.verb.trilateral.unaugmented.active.ActivePastConjugator.getInstance().createVerbList(unaugmentedTrilateralRoot);
    final ConjugationResult build = UnaugmentedTrilateralModifier.getInstance()
          .build(unaugmentedTrilateralRoot, rule.getKov(), madhi,
                SystemConstants.PAST_TENSE, true, true);
    final List finalResult1 = build.getFinalResult();
    madhimajhool = org.sj.verb.trilateral.unaugmented.passive.PassivePastConjugator.getInstance().createVerbList(unaugmentedTrilateralRoot);


    switch (verbmood) {
      case "Indicative":


        mudharay = org.sj.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                createNominativeVerbList(unaugmentedTrilateralRoot);


        mudharaymajhool = org.sj.verb.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                createNominativeVerbList(unaugmentedTrilateralRoot);
        break;
      case "Subjunctive":

        mudharay = org.sj.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                createAccusativeVerbList(unaugmentedTrilateralRoot);


        mudharaymajhool = org.sj.verb.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                createAccusativeVerbList(unaugmentedTrilateralRoot);

        break;
      case "Jussive":

        mudharay = org.sj.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                createJussiveVerbList(unaugmentedTrilateralRoot);


        mudharaymajhool = org.sj.verb.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                createJussiveVerbList(unaugmentedTrilateralRoot);

        break;
      case "Emphasized":

        mudharay = org.sj.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
                createEmphasizedVerbList(unaugmentedTrilateralRoot);


        mudharaymajhool = org.sj.verb.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().
                createEmphasizedVerbList(unaugmentedTrilateralRoot);

        break;
    }

    nahiamr = org.sj.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().
          createJussiveVerbList(unaugmentedTrilateralRoot);
    amr = org.sj.verb.trilateral.unaugmented.UnaugmentedImperativeConjugator.getInstance().createVerbList(unaugmentedTrilateralRoot);

    //    public ConjugationResult build(UnaugmentedTrilateralRoot root, int kov, List conjugations, String tense, boolean active, boolean applyGemination) {

    //   result =  AugmentedActivePastConjugator.getInstance().createVerbList(augmentedRoot, getForm());
    final ConjugationResult madhiconjresult = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), madhi,

          SystemConstants.PAST_TENSE, true, true);
    final ConjugationResult madhimajhoolconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), madhimajhool,

          SystemConstants.PAST_TENSE, false, true);

    final ConjugationResult mudharayconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), mudharay,

          SystemConstants.PRESENT_TENSE, true, true);

    final ConjugationResult mudharaymajhoolconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), mudharaymajhool,

          SystemConstants.PRESENT_TENSE, false, true);

    final ConjugationResult amrconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), amr,
          SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, true);
    final ConjugationResult nahiamrconj = UnaugmentedTrilateralModifier.getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), nahiamr,

          SystemConstants.PRESENT_TENSE, true, true);

    //ismfale and ismmafool
    List conjugatedIsmFael = UnaugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
          unaugmentedTrilateralRoot.getConjugation());


    final org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult conjugationResult = org.sj.noun.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier.
          getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmFael, "");

    final List finalIsmFael = conjugationResult.getFinalResult();


    List conjugatedIsmMafool = UnaugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList(unaugmentedTrilateralRoot,
          unaugmentedTrilateralRoot.getConjugation());


    final org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult ismmafoolresult =
          PassiveParticipleModifier.
                getInstance().build(unaugmentedTrilateralRoot, rule.getKov(), conjugatedIsmMafool, "");
    final List ismmafoolresultFinalResult = ismmafoolresult.getFinalResult();


    ///ismala
    /*
    0 = "??????????????"
1 = "??????????????????"
2 = "????????????????"
3 = "??????????????????"
     */



    StandardInstrumentalConjugator conjugator = StandardInstrumentalConjugator.getInstance();
    InstrumentalModifier modifier = InstrumentalModifier.getInstance();
    GenericNounSuffixContainer instance = GenericNounSuffixContainer.getInstance();


    List mifal = conjugator.createNounList(unaugmentedTrilateralRoot, "??????????????");
    ConjugationResult conjResultmifal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifal, "??????????????");
    List finalAlamifal = conjResultmifal.getFinalResult();

    List mifalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "??????????????????");
    ConjugationResult conjResult = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifalatun, "??????????????????");
    List finalAlamifalatun = conjResult.getFinalResult();


    List mifaal = conjugator.createNounList(unaugmentedTrilateralRoot, "????????????????");
    ConjugationResult conjResultmifaal = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), mifaal, "????????????????");
    List finalAlamifaal = conjResultmifaal.getFinalResult();

    List faalatun = conjugator.createNounList(unaugmentedTrilateralRoot, "??????????????????");
    ConjugationResult conjResultfaalatun = modifier.build(unaugmentedTrilateralRoot, rule.getKov(), faalatun, "??????????????????");
    List finalfaalatun = conjResultfaalatun.getFinalResult();
    //zarf
    TimeAndPlaceConjugator zarfconjugator = TimeAndPlaceConjugator.getInstance();
    TimeAndPlaceModifier zarfmodifier = TimeAndPlaceModifier.getInstance();
    List mafalconjuationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "??????????????");
    org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult mafal = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalconjuationlist, "??????????????");
    List zarfinalmafal = mafal.getFinalResult();

    List mafilconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "??????????????");
    org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult mafil = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafilconjugationlist, "??????????????");
    List zarffinalmafil = mafil.getFinalResult();

    List mafalatunconjugationlist = zarfconjugator.createNounList(unaugmentedTrilateralRoot, "??????????????????");
    org.sj.noun.trilateral.unaugmented.modifier.ConjugationResult mafalatun = zarfmodifier.build(unaugmentedTrilateralRoot, rule.getKov(), mafalatunconjugationlist, "??????????????????");
    List zarffinalmafalatun = mafalatun.getFinalResult();
    madhi = madhiconjresult.getFinalResult();
    madhimajhool = madhimajhoolconj.getFinalResult();
    mudharay = mudharayconj.getFinalResult();
    mudharaymajhool = mudharaymajhoolconj.getFinalResult();
    amr = amrconj.getFinalResult();
    nahiamr=nahiamrconj.getFinalResult();
    amr.removeAll(Collections.singleton(null));

    String la="????";


    final List list = nahiamr.subList(6, 11);
    ArrayList<String> nm=new ArrayList<>();


    StringBuilder sb;
    for (Object o : list) {
      sb=new StringBuilder();
      nm.add( sb.append(la).append(" ").append(o.toString()).toString());

    }


    List<String> listmadhi = new ArrayList<>();
    List<String> listmadhimajhool = new ArrayList<>();
    List<String> listmudharay = new ArrayList<>();
    List<String> listmudharymajhool = new ArrayList<>();
    List<String> listamr = new ArrayList<>();
    List<String> listamrnahi = new ArrayList<>();
    List<String> listismfael = new ArrayList<>();
    List<String> listismmafool = new ArrayList<>();

//
    List<String> listmifal = new ArrayList<>();
    List<String> listmifalatun = new ArrayList<>();
    List<String> listmifaal = new ArrayList<>();
    List<String> listlzarfmafal = new ArrayList<>();
    List<String> listlzarfmafil = new ArrayList<>();
    List<String> listlzarfmafalatun = new ArrayList<>();

    for (Object s : finalAlamifal) {
      if(s.toString().length()>0){
        listmifal.add(s.toString());
      }

    }

    for (Object s : finalAlamifalatun) {
      if(s.toString().length()>0){
        listmifalatun.add(s.toString());
      }

    }

    for (Object s : finalAlamifaal) {
      if(s.toString().length()>0){
        listmifaal.add(s.toString());
      }

    }

    for (Object s : zarffinalmafil) {
      if(s.toString().length()>0) {
        listlzarfmafal.add(s.toString());
      }
    }

    for (Object s : zarffinalmafil) {
      if(s.toString().length()>0) {
        listlzarfmafil.add(s.toString());
      }
    }

    for (Object s : zarffinalmafalatun) {
      if(s.toString().length()>0) {
        listlzarfmafalatun.add(s.toString());
      }
    }




    for (Object s : madhi) {
      listmadhi.add(s.toString());

    }
    for (Object s : madhimajhool) {
      try {
        listmadhimajhool.add(s.toString());

      } catch (NullPointerException e){

        listmadhimajhool.add("-");
      }


    }


    for (Object s : mudharay) {
      listmudharay.add(s.toString());

    }
    for (Object s : mudharaymajhool) {


      try {
        listmudharymajhool.add(s.toString());

      } catch (NullPointerException e){

        listmudharymajhool.add("-");
      }


    }
    for (Object s : finalIsmFael) {
      listismfael.add(s.toString());

    }
    for (Object s : ismmafoolresultFinalResult) {
      listismmafool.add(s.toString());

    }


    for (Object s : amr) {
      listamr.add(s.toString());

    }
    for (Object s : nm) {
      listamrnahi.add(s.toString());

    }




    List<String> vdetails=new ArrayList<>();



    // vdetails.add(unaugmentedTrilateralRoot.getVerb());



    vdetails.add(rule.getDesc());
    vdetails.add(unaugmentedTrilateralRoot.getConjugationname());

    vdetails.add(verbroot);

    vdetails.add(listmadhi.get(0));
    vdetails.add(listmadhimajhool.get(0));
    vdetails.add(listmudharay.get(0));
    vdetails.add(listmudharymajhool.get(0));
    vdetails.add(listamr.get(0));
    vdetails.add(listamrnahi.get(0));
    vdetails.add(listismfael.get(0));

    vdetails.add(listismmafool.get(0));
    vdetails.add(listmifal.get(0));
    vdetails.add(listmifalatun.get(0));
    vdetails.add(listmifaal.get(0));
    // vdetails.add(listlmifaal.get(0));
    vdetails.add(listlzarfmafal.get(0));
    vdetails.add(listlzarfmafil.get(0));
    vdetails.add(listlzarfmafalatun.get(0));
    vdetails.add("mujarrad");
    vdetails.add(unaugmentedTrilateralRoot.getConjugation());


     skabeer.add((ArrayList) vdetails);
    skabeer.add((ArrayList) listmadhi);
    skabeer.add((ArrayList) listmadhimajhool);
    skabeer.add((ArrayList) listmudharay);
    skabeer.add((ArrayList) listmudharymajhool);
    skabeer.add((ArrayList) listamr);
    skabeer.add((ArrayList) listamrnahi);

    skabeer.add((ArrayList) listismfael);
    skabeer.add((ArrayList) listismmafool);

    skabeer.add((ArrayList) listmifal);
    skabeer.add((ArrayList) listmifalatun);
    skabeer.add((ArrayList) listmifaal);


    skabeer.add((ArrayList) listlzarfmafal);
    skabeer.add((ArrayList) listlzarfmafil);
    skabeer.add((ArrayList) listlzarfmafalatun);

    //  skabeer.add((ArrayList) strings);
    return skabeer;
  }
  @NonNull
  private ArrayList<ArrayList> buildAugmentedLists(String verbmood, String verbroot, String augmentedFormula) {
    AugmentedTrilateralRoot augmentedRoot = SarfDictionary.getInstance().getAugmentedTrilateralRoot(verbroot,augmentedFormula);
    List ismfael;
    List ismmafool;

    List madhimajhool;
    List mudharay = null;
    List amr,nahiamr;
    List madhi;
    List mudharaymajhool = null;
    char c1 = verbroot.charAt(0);
    char c2 = verbroot.charAt(1);
    char c3 = verbroot.charAt(2);
    ArrayList<ArrayList> skabeer = new ArrayList<>();


    TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);


 
    madhi = AugmentedActivePastConjugator.getInstance().createVerbList(augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
    madhimajhool = AugmentedPassivePastConjugator.getInstance().createVerbList(augmentedRoot,           Integer.parseInt(augmentedRoot.getForm()));


    switch (verbmood) {
      case "Indicative":

        mudharay = AugmentedActivePresentConjugator.getInstance().
                getNominativeConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedFormula));
        mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                getNominativeConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedFormula));
        break;
      case "Subjunctive":

        mudharay = AugmentedActivePresentConjugator.getInstance().
                getAccusativeConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedFormula));
        mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                getAccusativeConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedFormula));

        break;
      case "Jussive":

        mudharay = AugmentedActivePresentConjugator.getInstance().
                getJussiveConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedFormula));
        mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                getJussiveConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedFormula));

        break;
      case "Emphasized":

        mudharay = AugmentedActivePresentConjugator.getInstance().
                getEmphasizedConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedFormula));

        mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                getEmphasizedConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedFormula));

        break;
    }

    nahiamr = AugmentedActivePresentConjugator.getInstance().
          getJussiveConjugator().createVerbList(augmentedRoot,            Integer.parseInt(augmentedFormula));

    amr = AugmentedImperativeConjugator.getInstance().
          getNotEmphsizedConjugator().createVerbList(augmentedRoot,            Integer.parseInt(augmentedFormula));


    final MazeedConjugationResult madhiconjresult = AugmentedTrilateralModifier.getInstance().build(augmentedRoot, rule.getKov(),   Integer.parseInt(augmentedRoot.getForm()), madhi,

          SystemConstants.PAST_TENSE, true, true);
    final MazeedConjugationResult madhimajhoolconj = AugmentedTrilateralModifier.getInstance().build(augmentedRoot, rule.getKov(),   Integer.parseInt(augmentedRoot.getForm()), madhimajhool,

          SystemConstants.PAST_TENSE, true, true);

    final MazeedConjugationResult mudharayconj = AugmentedTrilateralModifier.getInstance().build(augmentedRoot, rule.getKov(),   Integer.parseInt(augmentedRoot.getForm()), mudharay,

          SystemConstants.PRESENT_TENSE, true, true);

    final MazeedConjugationResult mudharaymajhoolconj = AugmentedTrilateralModifier.getInstance().build(augmentedRoot, rule.getKov(),   Integer.parseInt(augmentedRoot.getForm()), mudharaymajhool,

          SystemConstants.PRESENT_TENSE, false, true);

    final MazeedConjugationResult amrconj = AugmentedTrilateralModifier.getInstance().build(augmentedRoot, rule.getKov(),   Integer.parseInt(augmentedRoot.getForm()), amr,

          SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, true);
    final MazeedConjugationResult nahiamrconj = AugmentedTrilateralModifier.getInstance().build(augmentedRoot, rule.getKov(),   Integer.parseInt(augmentedRoot.getForm()), nahiamr,

          SystemConstants.PRESENT_TENSE, true, true);


    ismfael = AugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList(augmentedRoot,
           Integer.parseInt(augmentedFormula));
    MazeedConjugationResult conjResult = ActiveParticipleModifier.getInstance().build(augmentedRoot, rule.getKov(),
          Integer.parseInt(augmentedRoot.getForm()), ismfael, true);
    ismfael = conjResult.getFinalResult();

    ismmafool = AugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList(augmentedRoot,
           Integer.parseInt(augmentedFormula));
    MazeedConjugationResult ismmafoolresult = ActiveParticipleModifier.getInstance().build(augmentedRoot, rule.getKov(),
          Integer.parseInt(augmentedRoot.getForm()),  ismmafool, true);
    ismmafool = conjResult.getFinalResult();


    madhi = madhiconjresult.getFinalResult();
    madhimajhool = madhimajhoolconj.getFinalResult();
    mudharay = mudharayconj.getFinalResult();
    mudharaymajhool = mudharaymajhoolconj.getFinalResult();
    amr = amrconj.getFinalResult();
    nahiamr=nahiamrconj.getFinalResult();
    amr.removeAll(Collections.singleton(null));


    String la="????";


    final List list = nahiamr.subList(6, 11);
    ArrayList<String> nm=new ArrayList<>();


    StringBuilder sb;
    for (Object o : list) {
      sb=new StringBuilder();
      nm.add( sb.append(la).append(" ").append(o.toString()).toString());

    }
    List<String> listmadhi = new ArrayList<>();
    List<String> listmadhimajhool = new ArrayList<>();
    List<String> listmudharay = new ArrayList<>();
    List<String> listmudharymajhool = new ArrayList<>();
    List<String> listamr = new ArrayList<>();
    List<String> listamrnahi = new ArrayList<>();
    List<String> listismfael = new ArrayList<>();
    List<String> listismmafool = new ArrayList<>();





    List<String> vdetails=new ArrayList<>();
    vdetails.add(String.valueOf(rule.getDesc()));

    vdetails.add(augmentedRoot.getBabname());
    //vdetails.add(    rule.getDesc());

    vdetails.add(verbroot);
    for (Object s : madhi) {
      listmadhi.add(s.toString());

    }
    for (Object s : madhimajhool) {
      try {
        listmadhimajhool.add(s.toString());

      } catch (NullPointerException e){

        listmadhimajhool.add("-");
      }


    }


    for (Object s : mudharay) {
      listmudharay.add(s.toString());

    }
    for (Object s : mudharaymajhool) {


      try {
        listmudharymajhool.add(s.toString());

      } catch (NullPointerException e){

        listmudharymajhool.add("-");
      }


    }
    for (Object s : ismfael) {
      listismfael.add(s.toString());

    }
    for (Object s : ismmafool) {
      listismmafool.add(s.toString());

    }


    for (Object s : amr) {
      listamr.add(s.toString());

    }
    for (Object s : nm) {
      listamrnahi.add(s.toString());

    }



    vdetails.add(listmadhi.get(0));
    vdetails.add(listmadhimajhool.get(0));
    vdetails.add(listmudharay.get(0));
    vdetails.add(listmudharymajhool.get(0));
    vdetails.add(listamr.get(0));
    vdetails.add(listamrnahi.get(0));
    vdetails.add(listismfael.get(0));

    vdetails.add(listismmafool.get(0));
    vdetails.add("");
    vdetails.add("");
    vdetails.add("");
    vdetails.add("");
    vdetails.add("");
    vdetails.add("");

    vdetails.add("mazeed");
    vdetails.add(augmentedRoot.getForm());
 
    skabeer.add((ArrayList) vdetails);
    skabeer.add((ArrayList) listmadhi);
    skabeer.add((ArrayList) listmadhimajhool);
    skabeer.add((ArrayList) listmudharay);
    skabeer.add((ArrayList) listmudharymajhool);
    skabeer.add((ArrayList) listamr);
    skabeer.add((ArrayList) listamrnahi);

    skabeer.add((ArrayList) listismfael);
    skabeer.add((ArrayList) listismmafool);
















    return skabeer;
  }
  @NonNull
  private ArrayList<ArrayList> buildAugmentedLists(String verbmood, String verbroot) {
    AugmentedTrilateralRoot augmentedRoot = SarfDictionary.getInstance().getAugmentedTrilateralRoot(verbroot);
    List ismfael;
    List ismmafool;

    List madhimajhool;
    List mudharay = null;
    List amr,nahiamr;
    List madhi;
    List mudharaymajhool = null;
    char c1 = verbroot.charAt(0);
    char c2 = verbroot.charAt(1);
    char c3 = verbroot.charAt(2);
    ArrayList<ArrayList> skabeer = new ArrayList<>();


    TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);


  
    madhi = AugmentedActivePastConjugator.getInstance().createVerbList(augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
    madhimajhool = AugmentedPassivePastConjugator.getInstance().createVerbList(augmentedRoot,           Integer.parseInt(augmentedRoot.getForm()));


    switch (verbmood) {
      case "Indicative":

        mudharay = AugmentedActivePresentConjugator.getInstance().
                getNominativeConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
        mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                getNominativeConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
        break;
      case "Subjunctive":

        mudharay = AugmentedActivePresentConjugator.getInstance().
                getAccusativeConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
        mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                getAccusativeConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));

        break;
      case "Jussive":

        mudharay = AugmentedActivePresentConjugator.getInstance().
                getJussiveConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));
        mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                getJussiveConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));

        break;
      case "Emphasized":

        mudharay = AugmentedActivePresentConjugator.getInstance().
                getEmphasizedConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));

        mudharaymajhool = AugmentedPassivePresentConjugator.getInstance().
                getEmphasizedConjugator().createVerbList(augmentedRoot, Integer.parseInt(augmentedRoot.getForm()));

        break;
    }

    nahiamr = AugmentedActivePresentConjugator.getInstance().
            getJussiveConjugator().createVerbList(augmentedRoot,            Integer.parseInt(augmentedRoot.getForm()));

    amr = AugmentedImperativeConjugator.getInstance().
            getNotEmphsizedConjugator().createVerbList(augmentedRoot,          Integer.parseInt(augmentedRoot.getForm()));


    final MazeedConjugationResult madhiconjresult = AugmentedTrilateralModifier.getInstance().build(augmentedRoot, rule.getKov(),   Integer.parseInt(augmentedRoot.getForm()), madhi,

            SystemConstants.PAST_TENSE, true, true);
    final MazeedConjugationResult madhimajhoolconj = AugmentedTrilateralModifier.getInstance().build(augmentedRoot, rule.getKov(),   Integer.parseInt(augmentedRoot.getForm()), madhimajhool,

            SystemConstants.PAST_TENSE, true, true);

    final MazeedConjugationResult mudharayconj = AugmentedTrilateralModifier.getInstance().build(augmentedRoot, rule.getKov(),   Integer.parseInt(augmentedRoot.getForm()), mudharay,

            SystemConstants.PRESENT_TENSE, true, true);

    final MazeedConjugationResult mudharaymajhoolconj = AugmentedTrilateralModifier.getInstance().build(augmentedRoot, rule.getKov(),   Integer.parseInt(augmentedRoot.getForm()), mudharaymajhool,

            SystemConstants.PRESENT_TENSE, false, true);

    final MazeedConjugationResult amrconj = AugmentedTrilateralModifier.getInstance().build(augmentedRoot, rule.getKov(),   Integer.parseInt(augmentedRoot.getForm()), amr,

            SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, true);
    final MazeedConjugationResult nahiamrconj = AugmentedTrilateralModifier.getInstance().build(augmentedRoot, rule.getKov(),   Integer.parseInt(augmentedRoot.getForm()), nahiamr,

            SystemConstants.PRESENT_TENSE, true, true);


    ismfael = AugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList(augmentedRoot,
            Integer.parseInt(augmentedRoot.getForm()));
    MazeedConjugationResult conjResult = ActiveParticipleModifier.getInstance().build(augmentedRoot, rule.getKov(),
            Integer.parseInt(augmentedRoot.getForm()), ismfael, true);
    ismfael = conjResult.getFinalResult();

    ismmafool = AugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList(augmentedRoot,
            Integer.parseInt(augmentedRoot.getForm()));
    MazeedConjugationResult ismmafoolresult = ActiveParticipleModifier.getInstance().build(augmentedRoot, rule.getKov(),
            Integer.parseInt(augmentedRoot.getForm()),  ismmafool, true);
    ismmafool = conjResult.getFinalResult();


    madhi = madhiconjresult.getFinalResult();
    madhimajhool = madhimajhoolconj.getFinalResult();
    mudharay = mudharayconj.getFinalResult();
    mudharaymajhool = mudharaymajhoolconj.getFinalResult();
    amr = amrconj.getFinalResult();
    nahiamr=nahiamrconj.getFinalResult();
    amr.removeAll(Collections.singleton(null));


    String la="????";


    final List list = nahiamr.subList(6, 11);
    ArrayList<String> nm=new ArrayList<>();


    StringBuilder sb;
    for (Object o : list) {
      sb=new StringBuilder();
      nm.add( sb.append(la).append(" ").append(o.toString()).toString());

    }
    List<String> listmadhi = new ArrayList<>();
    List<String> listmadhimajhool = new ArrayList<>();
    List<String> listmudharay = new ArrayList<>();
    List<String> listmudharymajhool = new ArrayList<>();
    List<String> listamr = new ArrayList<>();
    List<String> listamrnahi = new ArrayList<>();
    List<String> listismfael = new ArrayList<>();
    List<String> listismmafool = new ArrayList<>();

    List<String> vdetails=new ArrayList<>();
    vdetails.add(String.valueOf(rule.getDesc()));

      vdetails.add(augmentedRoot.getBabname());
    //vdetails.add(    rule.getDesc());

    vdetails.add(verbroot);
    for (Object s : madhi) {
      listmadhi.add(s.toString());

    }
    for (Object s : madhimajhool) {
      try {
        listmadhimajhool.add(s.toString());

      } catch (NullPointerException e){

        listmadhimajhool.add("-");
      }


    }


    for (Object s : mudharay) {
      listmudharay.add(s.toString());

    }
    for (Object s : mudharaymajhool) {


      try {
        listmudharymajhool.add(s.toString());

      } catch (NullPointerException e){

        listmudharymajhool.add("-");
      }


    }
    for (Object s : ismfael) {
      listismfael.add(s.toString());

    }
    for (Object s : ismmafool) {
      listismmafool.add(s.toString());

    }


    for (Object s : amr) {
      listamr.add(s.toString());

    }
    for (Object s : nm) {
      listamrnahi.add(s.toString());

    }



    vdetails.add(listmadhi.get(0));
    vdetails.add(listmadhimajhool.get(0));
    vdetails.add(listmudharay.get(0));
    vdetails.add(listmudharymajhool.get(0));
    vdetails.add(listamr.get(0));
    vdetails.add(listamrnahi.get(0));
    vdetails.add(listismfael.get(0));

    vdetails.add(listismmafool.get(0));
    vdetails.add("");
    vdetails.add("");
    vdetails.add("");
    vdetails.add("");
    vdetails.add("");
    vdetails.add("");

    vdetails.add("mazeed");
    vdetails.add(augmentedRoot.getForm());
 
    skabeer.add((ArrayList) vdetails);
    skabeer.add((ArrayList) listmadhi);
    skabeer.add((ArrayList) listmadhimajhool);
    skabeer.add((ArrayList) listmudharay);
    skabeer.add((ArrayList) listmudharymajhool);
    skabeer.add((ArrayList) listamr);
    skabeer.add((ArrayList) listamrnahi);

    skabeer.add((ArrayList) listismfael);
    skabeer.add((ArrayList) listismmafool);
    return skabeer;
  }



  public ArrayList<ArrayList> buildAugmenteParticiples(String verbroot, String augmentedFormula) {
    AugmentedTrilateralRoot augmentedRoot = SarfDictionary.getInstance().getAugmentedTrilateralRoot(verbroot,augmentedFormula);
    List ismfael;
    List ismmafool;

    char c1 = verbroot.charAt(0);
    char c2 = verbroot.charAt(1);
    char c3 = verbroot.charAt(2);
    ArrayList<ArrayList> skabeer = new ArrayList<>();



    TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);




    ismfael = AugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList(augmentedRoot,
             Integer.parseInt(augmentedFormula));
    MazeedConjugationResult conjResult = ActiveParticipleModifier.getInstance().build(augmentedRoot, rule.getKov(),
            Integer.parseInt(augmentedRoot.getForm()), ismfael, true);
    ismfael = conjResult.getFinalResult();

    ismmafool = AugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList(augmentedRoot,
             Integer.parseInt(augmentedFormula));
    MazeedConjugationResult ismmafoolresult = ActiveParticipleModifier.getInstance().build(augmentedRoot, rule.getKov(),
            Integer.parseInt(augmentedRoot.getForm()),  ismmafool, true);
    ismmafool = conjResult.getFinalResult();







    List<String> listismfael = new ArrayList<String>(ismfael);
    List<String> listismmafool = new ArrayList<String>(ismmafool);


    List<String> vdetails=new ArrayList<>();
    vdetails.add(String.valueOf(rule.getDesc()));
    vdetails.add(augmentedRoot.getBabname());
 
    skabeer.add((ArrayList) listismfael);
    skabeer.add((ArrayList) listismmafool);
    return skabeer;
  }

}
