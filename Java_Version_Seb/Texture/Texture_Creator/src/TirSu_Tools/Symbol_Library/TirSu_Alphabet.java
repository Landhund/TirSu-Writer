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

    A("a", Letter_Element.HEAD_ROOF, Letter_Element.CENTER_LINE_LONG, Letter_Element.NECK_HIGH_LONG),
    B("b", Letter_Element.HEAD_ROOF_INVERTED, Letter_Element.CENTER_LINE_LONG, Letter_Element.T_ARM_HIGH, Letter_Element.NECK_HIGH_Short),
    C("c", Letter_Element.HEAD_ELLIPSE_HIGH, Letter_Element.CENTER_LINE_LONG, Letter_Element.T_ARM_HIGH, Letter_Element.NECK_HIGH_Short),
    D("d", Letter_Element.HEAD_ROOF, Letter_Element.CENTER_LINE_LONG, Letter_Element.T_ARM_HIGH,Letter_Element.NECK_HIGH_LONG),
    E("e", Letter_Element.HEAD_T, Letter_Element.CENTER_LINE_LONG, Letter_Element.NECK_HIGH_LONG),
    F("f", Letter_Element.HEAD_DOUBLE_T, Letter_Element.CENTER_LINE_LONG, Letter_Element.NECK_HIGH_LONG),
    G("g", Letter_Element.HEAD_ELLIPSE_HIGH, Letter_Element.CENTER_LINE_LONG, Letter_Element.T_ARM_HIGH, Letter_Element.T_ARM_MID,Letter_Element.NECK_HIGH_Short),
    H("h", Letter_Element.HEAD_ROOF, Letter_Element.T_ARM_HIGH, Letter_Element.T_ARM_MID, Letter_Element.CENTER_LINE_LONG,Letter_Element.NECK_HIGH_LONG),
    I("i", Letter_Element.NECK_HIGH_LONG, Letter_Element.CENTER_LINE_LONG,Letter_Element.NECK_HIGH_LONG,Letter_Element.NECK_HIGH_LONG),
    J("j", Letter_Element.HEAD_ARM_RIGHT, Letter_Element.CENTER_LINE_LONG, Letter_Element.NECK_HIGH_LONG),
    K("k", Letter_Element.HEAD_DOUBLE_ARM_RIGHT, Letter_Element.CENTER_LINE_LONG, Letter_Element.NECK_HIGH_Short),
    L("l", Letter_Element.HEAD_TRIANGLE, Letter_Element.CENTER_LINE_LONG, Letter_Element.NECK_HIGH_Short),
    M("m", Letter_Element.HEAD_TRIANGLE, Letter_Element.CENTER_LINE_LONG, Letter_Element.T_ARM_HIGH, Letter_Element.NECK_HIGH_Short),
    N("n", Letter_Element.HEAD_TRIANGLE, Letter_Element.CENTER_LINE_LONG, Letter_Element.T_ARM_HIGH, Letter_Element.T_ARM_MID, Letter_Element.NECK_HIGH_Short),
    O("o", Letter_Element.HEAD_ELLIPSE_HIGH, Letter_Element.CENTER_LINE_LONG,Letter_Element.NECK_HIGH_Short),
    P("p", Letter_Element.HEAD_ROOF_ARM_RIGHT, Letter_Element.NECK_HIGH_LONG, Letter_Element.CENTER_LINE_LONG),
    Q("q", Letter_Element.HEAD_TRIANGLE_INVERSE, Letter_Element.NECK_HIGH_Short, Letter_Element.CENTER_LINE_LONG),
    R("r", Letter_Element.HEAD_ROOF_INVERTED, Letter_Element.NECK_HIGH_Short,Letter_Element.CENTER_LINE_LONG,Letter_Element.T_ARM_HIGH,Letter_Element.T_ARM_MID),
    S("s", Letter_Element.HEAD_ELLIPSE_HIGH, Letter_Element.NECK_HIGH_Short, Letter_Element.ARM_RIGHT_HIGH, Letter_Element.CENTER_LINE_LONG),
    T("t", Letter_Element.HEAD_ELLIPSE_HIGH, Letter_Element.NECK_HIGH_Short, Letter_Element.ARM_RIGHT_HIGH, Letter_Element.ARM_RIGHT_MID, Letter_Element.CENTER_LINE_LONG),
    U("u", Letter_Element.HEAD_U_HIGH,Letter_Element.NECK_HIGH_Short,Letter_Element.CENTER_LINE_LONG),
    V("v", Letter_Element.HEAD_U_HIGH,Letter_Element.NECK_HIGH_Short,Letter_Element.CENTER_LINE_LONG,Letter_Element.T_ARM_HIGH),
    W("w",Letter_Element.HEAD_U_HIGH,Letter_Element.NECK_HIGH_Short,Letter_Element.CENTER_LINE_LONG,Letter_Element.T_ARM_HIGH,Letter_Element.T_ARM_MID),
    X("x", Letter_Element.HEAD_RIGHT_OPEN_SQUARE_HIGH,Letter_Element.NECK_HIGH_Short,Letter_Element.CENTER_LINE_LONG),
    Y("y", Letter_Element.HEAD_ROOF_INVERTED,Letter_Element.NECK_HIGH_Short,Letter_Element.CENTER_LINE_LONG),
    Z("z", Letter_Element.HEAD_RIGHT_OPEN_SQUARE_HIGH,Letter_Element.NECK_HIGH_Short,Letter_Element.CENTER_LINE_LONG,Letter_Element.T_ARM_HIGH),

    CH("ch", Letter_Element.HEAD_ROOF, Letter_Element.HEAD_ELLIPSE_MID, Letter_Element.CENTER_LINE_MID, Letter_Element.T_ARM_LOW),
    EA("ea", Letter_Element.HEAD_T, Letter_Element.HEAD_ROOF, Letter_Element.NECK_HIGH_LONG, Letter_Element.CENTER_LINE_LONG),
    OA("oa", Letter_Element.HEAD_ELLIPSE_HIGH, Letter_Element.NECK_HIGH_Short, Letter_Element.ARM_RIGHT_HIGH, Letter_Element.ARM_LEFT_HIGH, Letter_Element.CENTER_LINE_LONG),
    OI("oi", Letter_Element.HEAD_ROOF_INVERTED, Letter_Element.HEAD_ELLIPSE_MID , Letter_Element.CENTER_LINE_MID),
    OU("ou", Letter_Element.HEAD_U_Mid, Letter_Element.HEAD_ELLIPSE_HIGH, Letter_Element.CENTER_LINE_MID),
    SH("sh", Letter_Element.HEAD_ROOF, Letter_Element.HEAD_ELLIPSE_MID, Letter_Element.ARM_RIGHT_MID, Letter_Element.CENTER_LINE_MID),
    TH("th", Letter_Element.HEAD_ROOF, Letter_Element.HEAD_ELLIPSE_MID, Letter_Element.ARM_RIGHT_LOW, Letter_Element.ARM_RIGHT_MID, Letter_Element.CENTER_LINE_MID),
    ZH("zh", Letter_Element.HEAD_RIGHT_OPEN_SQUARE_HIGH, Letter_Element.NECK_HIGH_Short, Letter_Element.T_ARM_HIGH, Letter_Element.T_ARM_MID, Letter_Element.CENTER_LINE_LONG);

    private TirSu_Alphabet(String letter, Letter_Element... elements)
    {
        this.letter = letter;

        for (Letter_Element letter_Element : elements) 
        {
            this.elements.add(letter_Element);            
        }
         
    }

    // -------------------------------- Variables -------------------------------- \\

    private String letter;
    private List<Letter_Element> elements = new ArrayList<>();


    // -------------------------------- Methodes -------------------------------- \\
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