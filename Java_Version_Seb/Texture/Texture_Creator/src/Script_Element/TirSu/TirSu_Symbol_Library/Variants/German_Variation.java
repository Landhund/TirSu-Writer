package Script_Element.TirSu.TirSu_Symbol_Library.Variants;

import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Element;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Group_Element;
import Script_Element.TirSu.TirSu_Symbol_Library.Letter_Element;
import Script_Element.TirSu.TirSu_Symbol_Library.TirSu_Alphabet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum German_Variation
{
    Ä("ä", "a|e", TirSu_Alphabet.A, TirSu_Alphabet.E),
    Ö("ö", "o|e", TirSu_Alphabet.O, TirSu_Alphabet.E),
    Ü("ü", "u|e", TirSu_Alphabet.U, TirSu_Alphabet.E),
    IE("ie");

    private German_Variation(String letter, String alternative, TirSu_Alphabet... letters)
    {
        this.letter = letter;

        for (Letter_Element letter_Element : elements)
        {
            this.elements.add(letter_Element);
        }

    }

    private German_Variation(String letter, Letter_Element... elements)
    {
        this.letter = letter;
        this.alternative = letter;

        for (Letter_Element letter_Element : elements)
        {
            this.elements.add(letter_Element);
        }

    }


    // -------------------------------- Variables -------------------------------- \\

    static List<String> german_TirSu = new ArrayList<>();
    private String letter;
    private String alternative;
    private List<Letter_Element> elements = new ArrayList<>();

    // ------------------------------------------------------------------------------ \\


    // -------------------------------- Alphabet-Setup-Script -------------------------------- \\
    public static List<String> getGerman_TirSu()
    {
        german_TirSu.addAll(TirSu_Alphabet.getScriptureAlphabet());
        return german_TirSu;
    }
    // ------------------------------------------------------------------------------ \\

    /**
     * if (vari.alternative != vari.letter)
     *             {
     *                 String[] alternative = vari.alternative.split("|");
     *                 for (String alt :
     *                         ) {
     *
     *                 }
     *             }
     */

    private static void createLetterList()
    {
        if (German_Variation.getGerman_TirSu().size() < 1)
        {
            List<String> enumNames = Stream.of(German_Variation.values())
                    .map(German_Variation::getLetterString)
                    .collect(Collectors.toList());

            German_Variation.german_TirSu = enumNames;
        }
    }

    private String getLetterString()
    {
        return this.letter;
    }



    // -------------------------------- Element Methods -------------------------------- \\
    public Group_Element getLetter()
    {

        Group_Element letter = new Group_Element()
                .withAttributes(new AttributeValue(Global_Att.ID).withValue( "Letter_" + this.letter))
                .withAttributes(new AttributeValue(Global_Att.FILL))
                .withAttributes(new AttributeValue(Global_Att.STROKE));

        for (Letter_Element l_ele : this.elements)
        {
            letter.addElementsToGroup(l_ele.getElements().toArray(new Element[0]));
        }
        return letter;
    }
}
