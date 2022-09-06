package Script_Element.TirSu;

import java.util.List;

public class TirSu_Master
{
    TirSu_Circle tirSu_circle;
    TirSu_Sentences tirSu_sentences;
    List<String> alphabetSymbols;


    public TirSu_Master(String text, boolean githyanki)
    {
        int wordAmount = text.split(" ").length;
        if (wordAmount == 1)
        {
            TirSu_Circle oneWord = new TirSu_Circle(text, this.alphabetSymbols, githyanki);
            tirSu_circle = oneWord;
            oneWord.saveTIRSU(true);
        }
        else
        {
            TirSu_Sentences sentence = new TirSu_Sentences(text, githyanki);
            tirSu_sentences = sentence;
            sentence.saveTIRSU(true);
        }
    }

    public TirSu_Master(String text, List<String> alphabetSymbols, boolean githyanki)
    {
        this.alphabetSymbols = alphabetSymbols;
        int wordAmount = text.split(" ").length;
        if (wordAmount == 1)
        {
            TirSu_Circle oneWord = new TirSu_Circle(text, this.alphabetSymbols, githyanki);
            tirSu_circle = oneWord;
            oneWord.saveTIRSU(true);
        }
        else
        {
            TirSu_Sentences sentence = new TirSu_Sentences(text, githyanki);
            tirSu_sentences = sentence;
            sentence.saveTIRSU(true);
        }
    }

    public TirSu_Master(String text, String filename, boolean githyanki)
    {
        int wordAmount = text.split(" ").length;
        if (wordAmount == 1)
        {
            TirSu_Circle oneWord = new TirSu_Circle(text, filename, githyanki);
            tirSu_circle = oneWord;
            oneWord.saveTIRSU(true);
        }
        else
        {
            TirSu_Sentences sentence = new TirSu_Sentences(text, filename, githyanki);
            tirSu_sentences = sentence;
            sentence.saveTIRSU(true);
        }
    }

    public TirSu_Master(String text, String filename, List<String> alphabetSymbols,boolean githyanki)
    {
        this.alphabetSymbols = alphabetSymbols;
        int wordAmount = text.split(" ").length;
        if (wordAmount == 1)
        {
            TirSu_Circle oneWord = new TirSu_Circle(text, filename, this.alphabetSymbols, githyanki);
            tirSu_circle = oneWord;
            oneWord.saveTIRSU(true);
        }
        else
        {
            TirSu_Sentences sentence = new TirSu_Sentences(text, filename, this.alphabetSymbols, githyanki);
            tirSu_sentences = sentence;
            sentence.saveTIRSU(true);
        }
    }

    public void saveTIRSU(boolean override)
    {
        if (tirSu_sentences != null)
        {
            tirSu_sentences.saveTIRSU(override);
        }
        if (tirSu_circle != null)
        {
            tirSu_circle.saveTIRSU(override);
        }
    }
}
