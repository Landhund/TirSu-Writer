package TirSu_Tools.Symbol_Library;

import java.util.ArrayList;
import java.util.List;
import TirSu_Tools.Symbol_Library.Letter_Element;

/**
 * TirSu_Alphabet
 */
public enum TirSu_Alphabet 
{

    ;

    private TirSu_Alphabet(String letter, Letter_Element... elements)
    {
        this.letter = letter;

        for (Letter_Element letter_Element : elements) 
        {
            this.elements.add(letter_Element);            
        }
         
    }

    // -------------------------------- Variables

    private String letter;
    private List<Letter_Element> elements = new ArrayList<>();

    public List<Letter_Element> getElements() {
        return elements;
    }
    
}