package TirSu_Tools.Symbol_Library;

import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Element;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Group_Element;

import java.util.ArrayList;
import java.util.List;

/**
 * TirSu_Alphabet
 */
public enum TirSu_Alphabet 
{

    A("a", Letter_Element.HEAD_ROOF, Letter_Element.CENTER_LINE_LONG);

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