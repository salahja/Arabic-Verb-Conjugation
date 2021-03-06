public class GrammarEngine
{
    private Tense PerfectTense;

    private Tense IndicativeTense;

    private Tense SubjunctiveTense;

    private Tense JussiveTense;

    private Tense ImperativeTense;

    private Verb TheVerb;

  //  private Transliterator TheTransliterator;

    public GrammarEngines()
    {
        this.PerfectTense = new PerfectTense();
    //    this.IndicativeTense = new IndicativeTense();
     //   this.SubjunctiveTense = new SubjunctiveTense();
     //   this.JussiveTense = new JussiveTense();
      //  this.ImperativeTense = new ImperativeTense();
      //  this.TheTransliterator = new Transliterator();
    }

    public Conjugation Conjugate(Verb AVerb)
    {
        Conjugation conjugation = new Conjugation();
        this.TheVerb = AVerb;
   //     conjugation = ACONDatabase.getExceptionalConjugationForVerb(AVerb);
        if (conjugation == null)
        {
            if (this.TheVerb.Paradigm == "")
            {
                this.TheVerb.Paradigm = "I";
            }
            if (this.TheVerb.Tense == "P")
            {
                conjugation = this.PerfectTense.Conjugate(this.TheVerb);
            }
            if (this.TheVerb.Tense == "I")
            {
                conjugation = this.IndicativeTense.Conjugate(this.TheVerb);
            }
            if (this.TheVerb.Tense == "S")
            {
                conjugation = this.SubjunctiveTense.Conjugate(this.TheVerb);
            }
            if (this.TheVerb.Tense == "J")
            {
                conjugation = this.JussiveTense.Conjugate(this.TheVerb);
            }
            if (this.TheVerb.Tense == "M")
            {
                conjugation = this.ImperativeTense.Conjugate(this.TheVerb);
            }
            conjugation = this.GrammarCheck(conjugation);
        }
        conjugation = this.Translate(conjugation);
   //     conjugation = this.TheTransliterator.TransliterateConjugation(conjugation);
        return this.Unvowel(conjugation);
    }

    private Conjugation GrammarCheck(Conjugation AConjugation)
    {
        if (AConjugation == null)
        {
            return AConjugation;
        }
        AConjugation.singularFirst.arabic = this.ApplyIndividualGrammarRules(AConjugation.singularFirst.arabic);
        AConjugation.singularSecondM.arabic = this.ApplyIndividualGrammarRules(AConjugation.singularSecondM.arabic);
        AConjugation.singularSecondF.arabic = this.ApplyIndividualGrammarRules(AConjugation.singularSecondF.arabic);
        AConjugation.singularThirdM.arabic = this.ApplyIndividualGrammarRules(AConjugation.singularThirdM.arabic);
        AConjugation.singularThirdF.arabic = this.ApplyIndividualGrammarRules(AConjugation.singularThirdF.arabic);
        AConjugation.dualSecondM.arabic = this.ApplyIndividualGrammarRules(AConjugation.dualSecondM.arabic);
        AConjugation.dualSecondF.arabic = this.ApplyIndividualGrammarRules(AConjugation.dualSecondF.arabic);
        AConjugation.dualThirdM.arabic = this.ApplyIndividualGrammarRules(AConjugation.dualThirdM.arabic);
        AConjugation.dualThirdF.arabic = this.ApplyIndividualGrammarRules(AConjugation.dualThirdF.arabic);
        AConjugation.pluralFirst.arabic = this.ApplyIndividualGrammarRules(AConjugation.pluralFirst.arabic);
        AConjugation.pluralSecondM.arabic = this.ApplyIndividualGrammarRules(AConjugation.pluralSecondM.arabic);
        AConjugation.pluralSecondF.arabic = this.ApplyIndividualGrammarRules(AConjugation.pluralSecondF.arabic);
        AConjugation.pluralThirdM.arabic = this.ApplyIndividualGrammarRules(AConjugation.pluralThirdM.arabic);
        AConjugation.pluralThirdF.arabic = this.ApplyIndividualGrammarRules(AConjugation.pluralThirdF.arabic);
        return AConjugation;
    }

    private Conjugation Translate(Conjugation AConjugation)
    {
        Conjugation conjugation = new Translator().TranslateRoot(this.TheVerb.Root.Radicals, this.TheVerb.VowelPerfect, this.TheVerb.VowelImperfect, this.TheVerb.Paradigm, this.TheVerb.Tense, this.TheVerb.Voice);
        if (conjugation == null)
        {
            return AConjugation;
        }
        AConjugation.infintive.english = conjugation.infintive.english;
        AConjugation.singularFirst.english = conjugation.singularFirst.english;
        AConjugation.singularSecondM.english = conjugation.singularSecondM.english;
        AConjugation.singularSecondF.english = conjugation.singularSecondF.english;
        AConjugation.singularThirdM.english = conjugation.singularThirdM.english;
        AConjugation.singularThirdF.english = conjugation.singularThirdF.english;
        AConjugation.dualSecondM.english = conjugation.dualSecondM.english;
        AConjugation.dualSecondF.english = conjugation.dualSecondF.english;
        AConjugation.dualThirdM.english = conjugation.dualThirdM.english;
        AConjugation.dualThirdF.english = conjugation.dualThirdF.english;
        AConjugation.pluralFirst.english = conjugation.pluralFirst.english;
        AConjugation.pluralSecondM.english = conjugation.pluralSecondM.english;
        AConjugation.pluralSecondF.english = conjugation.pluralSecondF.english;
        AConjugation.pluralThirdM.english = conjugation.pluralThirdM.english;
        AConjugation.pluralThirdF.english = conjugation.pluralThirdF.english;
        return AConjugation;
    }

    private String ApplyIndividualGrammarRules(String AWord)
    {
        if (AWord == null)
        {
            return null;
        }
        if (AWord.Length <= 1)
        {
            return AWord;
        }
        if (this.TheVerb.Voice == "A" && this.TheVerb.Paradigm == "I" && this.TheVerb.Tense != "P" && this.TheVerb.Root.R1 == "??" && this.TheVerb.Root.R2 != this.TheVerb.Root.R3)
        {
            AWord = this.DeVav(AWord);
        }
        if (this.TheVerb.Paradigm == "VIII")
        {
            AWord = this.ContractVIII(AWord);
        }
        AWord = this.Contract(AWord);
        AWord = this.FixHamza(AWord);
        AWord = this.FixLamAleph(AWord);
        return AWord;
    }

    private String DeVav(String AWord)
    {
        AWord = AWord.Replace("????", "");
        return AWord;
    }

    private String Contract(String AWord)
    {
        AWord = AWord.Replace("??????", "????");
        AWord = AWord.Replace("??????", "????");
        return AWord;
    }

    private String ContractVIII(String AWord)
    {
        String arg_BC_0 = AWord.SubString(0, 2);
        String str = AWord.SubString(5, AWord.Length - 5);
        String text = AWord.SubString(2, 3);
        text = text.Replace("??????", "????");
        text = text.Replace("??????", "????");
        text = text.Replace("??????", "????");
        text = text.Replace("??????", "??????");
        text = text.Replace("??????", "??????");
        text = text.Replace("??????", "????");
        text = text.Replace("??????", "??????");
        text = text.Replace("??????", "????");
        text = text.Replace("??????", "????????");
        return arg_BC_0 + text + str;
    }

    private String FixHamza(String AWord)
    {
        StringBuilder sb = new StringBuilder(AWord);
        sb.Replace("??", "??");
        if (this.TheVerb.Root.R1 == "??")
        {
            sb.Replace("????????", "??????", 0, 4);
            sb.Replace("??????", "??????", 0, 4);
        }

        /*
public StringBuilder Replace(
  string oldValue,//from  w w  w .  j a va2  s  .c o  m
  string newValue,
  int startIndex,
  int count
)*/
        StringBuilder sb=new StringBuilder(AWord);
        String substring = sb.substring(1, sb.length() - 2);
        sb.toString().regionMatches()
        sb.Replace("????", "????", 1, sb.Length - 2);

        sb.Replace("??????", "??????", 1, sb.Length - 2);

        sb.Replace("????", "????", 1, sb.Length - 2);

        sb.Replace("??????", "??????", 1, sb.Length - 2);

        sb.Replace("????", "????", 1, sb.Length - 2);

        sb.Replace("??????", "??????", 1, sb.Length - 2);
        sb.Replace("??????", "??????", 1, sb.Length - 2);
        sb.Replace("????", "????", 1, sb.Length - 2);
        sb.Replace("????", "????", 1, sb.Length - 2);
        sb.Replace("????", "????", 1, sb.Length - 2);
        sb.Replace("????????", "????????", 1, sb.Length - 2);
        sb.Replace("????????", "????????", 1, sb.Length - 2);
         sb.Replace("????????", "????????", 1, sb.Length - 2);
        sb.Replace("????????", "????????", 1, sb.Length - 2);
        sb.Replace("????????", "????????", 1, sb.Length - 2);
        sb.Replace("????????", "????????", 1, sb.Length - 2);
        sb.Replace("????????", "????????", 1, sb.Length - 2);
        sb.Replace("????????", "????????", 1, sb.Length - 2);
        sb.Replace("????????", "????????", 1, sb.Length - 2);

        sb.Replace("??????", "??????", sb.Length - 4, 4);
        sb.Replace("??????", "??????", sb.Length - 4, 4);
        sb.Replace("??????", "??????", sb.Length - 4, 4);
        sb.Replace("????", "????", sb.Length - 4, 4);
        sb.Replace("????", "????", sb.Length - 4, 4);
         sb.Replace("????", "????", sb.Length - 4, 4);
         sb.Replace("??????", "??????", sb.Length - 4, 4);
        sb.Replace("??????", "??");
        sb.Replace("????????", "??");
        sb.Replace("????????", "??");
        sb.Replace("????", "????");
        if (this.TheVerb.Root.R2 == "??")
        {
            sb.Replace("????", "????", sb.Length - 2, 2);

            sb.replace(sb.length()-2,2,"????");
            sb.Replace("????", "????", sb.Length - 2, 2);
            sb.Replace("????", "????", sb.Length - 2, 2);
            sb.Replace("????", "????", sb.Length - 2, 2);
            sb.Replace("????", "????", sb.Length - 2, 2);
            sb.Replace("????", "????", sb.Length - 2, 2);
            sb.Replace("????", "????", sb.Length - 2, 2);
            sb.Replace("????", "????", sb.Length - 2, 2);
            sb.Replace("????", "????", sb.Length - 2, 2);
            sb.Replace("????", "????", sb.Length - 2, 2);
            sb.Replace("????", "????", sb.Length - 2, 2);
            sb.Replace("????", "????", sb.Length - 2, 2);
            sb.Replace("??????", "??????", sb.Length - 3, 3);
            sb.Replace("??????", "??????", sb.Length - 3, 3);
            sb.Replace("??????", "??????", sb.Length - 3, 3);
            sb.Replace("??????", "??????", sb.Length - 3, 3);
            sb.Replace("??????", "??????", sb.Length - 3, 3);
            sb.Replace("??????", "??????", sb.Length - 3, 3);
            sb.Replace("??????", "??????", sb.Length - 3, 3);
             sb.Replace("??????", "??????", sb.Length - 3, 3);
            sb.Replace("??????", "??????", sb.Length - 3, 3);
            sb.Replace("??????", "??????", sb.Length - 3, 3);
            sb.Replace("??????", "??????", sb.Length - 3, 3);
            sb.Replace("??????", "??????", sb.Length - 3, 3);

            if(ones==1){

                int abc1=sb.indexOf("????");
                int abc2=sb.indexOf("????");
                int abc3=sb.indexOf("??????");
                int abc4=sb.indexOf("????");
                int abc5=sb.indexOf("??????");
                int abc6=sb.indexOf("????");
                int abc7=sb.indexOf("??????");
                int abc8=sb.indexOf("??????");
                int abc9=sb.indexOf("????");
                int abd1=sb.indexOf("????");
                int abd2=sb.indexOf("????");
                int abd3=sb.indexOf("????????");
                int abd4=sb.indexOf("????????");
                int abd5=sb.indexOf("????????");
                int abd6=sb.indexOf("????????");
                int abd7=sb.indexOf("????????");
                int abd8=sb.indexOf("????????");
                 int abd9=sb.indexOf("????????");
                int abe1=sb.indexOf("????????");
                int abe2=sb.indexOf("????????"); ;
                int abe3=sb.indexOf("??????");
                int abe4=sb.indexOf("??????");
                int abe5=sb.indexOf("??????");
                int abe6=sb.indexOf("????");
                int abe7=sb.indexOf("????");
                int abe8=sb.indexOf("????");
                 int abe9=sb.indexOf("??????");
            }
        }
        return sb.ToString();
    }

    private String FixLamAleph(String AWord)
    {
        AWord = AWord.Replace("??????", "??????");
        AWord = AWord.Replace("????????", "????????");
        return AWord;
    }

    private Conjugation Unvowel(Conjugation AConjugation)
    {
        if (AConjugation == null)
        {
            return AConjugation;
        }
        AConjugation.singularFirst.unvoweledArabic = this.StripVowels(AConjugation.singularFirst.arabic);
        AConjugation.singularSecondM.unvoweledArabic = this.StripVowels(AConjugation.singularSecondM.arabic);
        AConjugation.singularSecondF.unvoweledArabic = this.StripVowels(AConjugation.singularSecondF.arabic);
        AConjugation.singularThirdM.unvoweledArabic = this.StripVowels(AConjugation.singularThirdM.arabic);
        AConjugation.singularThirdF.unvoweledArabic = this.StripVowels(AConjugation.singularThirdF.arabic);
        AConjugation.dualSecondM.unvoweledArabic = this.StripVowels(AConjugation.dualSecondM.arabic);
        AConjugation.dualSecondF.unvoweledArabic = this.StripVowels(AConjugation.dualSecondF.arabic);
        AConjugation.dualThirdM.unvoweledArabic = this.StripVowels(AConjugation.dualThirdM.arabic);
        AConjugation.dualThirdF.unvoweledArabic = this.StripVowels(AConjugation.dualThirdF.arabic);
        AConjugation.pluralFirst.unvoweledArabic = this.StripVowels(AConjugation.pluralFirst.arabic);
        AConjugation.pluralSecondM.unvoweledArabic = this.StripVowels(AConjugation.pluralSecondM.arabic);
        AConjugation.pluralSecondF.unvoweledArabic = this.StripVowels(AConjugation.pluralSecondF.arabic);
        AConjugation.pluralThirdM.unvoweledArabic = this.StripVowels(AConjugation.pluralThirdM.arabic);
        AConjugation.pluralThirdF.unvoweledArabic = this.StripVowels(AConjugation.pluralThirdF.arabic);
        return AConjugation;
    }

    private String  StripVowels(String AString)
    {
        if (AString != null)
        {
            AString = AString.Replace("??", "");
            AString = AString.Replace("??", "");
            AString = AString.Replace("??", "");
            AString = AString.Replace("??", "");
        }
        return AString;
    }
}
 
