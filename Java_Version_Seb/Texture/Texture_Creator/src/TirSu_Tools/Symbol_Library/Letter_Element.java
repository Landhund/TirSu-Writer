package TirSu_Tools.Symbol_Library;

import SVG_Tools.New_SVG_Workspace.Element_Workspace.Element;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Line_Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Letter_Element
 */
public enum Letter_Element          // TODO: #25 Write the Elements of witch the Alphabet Symbols consist
{
    CENTER_LINE_SHORT(new Line_Element().withStartPoint(0,0).withEndPoint(0, 10)),
    CENTER_LINE_MID(new Line_Element().withStartPoint(0,0).withEndPoint(0, 15)),
    CENTER_LINE_LONG(new Line_Element().withStartPoint(0,0).withEndPoint(0,20)),
    ARM_RIGHT_LOW(new Line_Element().withStartPoint(0,10).withEndPoint(-10, 0)),
    ARM_LEFT_LOW(new Line_Element().withStartPoint(0,10).withEndPoint(10, 0)),
    ARM_RIGHT_MID(new Line_Element().withStartPoint(0,15).withEndPoint(-10, 5)),
    ARM_LEFT_MID(new Line_Element().withStartPoint(0,15).withEndPoint(10, 5)),
    ARM_RIGHT_HIGH(new Line_Element().withStartPoint(0,20).withEndPoint(-10, 10)),
    ARM_LEFT_HIGH(new Line_Element().withStartPoint(0,20).withEndPoint(10, 10)),
    T_ARM_LOW(new Line_Element().withStartPoint(-5,10).withEndPoint(5,10)),
    T_ARM_MID(new Line_Element().withStartPoint(-5,15).withEndPoint(5,15)),
    HEAD_ROOF(new Line_Element().withStartPoint(10,20).withEndPoint(0,30), new Line_Element().withStartPoint(-10,20).withEndPoint(0,30), new Line_Element().withStartPoint(0, 20).withEndPoint(0, 30)),
    HEAD_ROOF_INVERTED(new Line_Element().withStartPoint(-10,30).withEndPoint(0,20), new Line_Element().withStartPoint(10,30).withEndPoint(0,20)),
    HEAD_TRIANGLE(new Line_Element().withStartPoint(10,20).withEndPoint(0,30), new Line_Element().withStartPoint(-10,20).withEndPoint(0,30), new Line_Element().withStartPoint(-10,20).withEndPoint(10,20)),
    HEAD_TRIANGLE_INVERSE(new Line_Element().withStartPoint(-10,30).withEndPoint(0,20), new Line_Element().withStartPoint(10,30).withEndPoint(0, 20), new Line_Element().withStartPoint(-10,30).withEndPoint(10,30));


    private Letter_Element(Element... elements)
    {
        for (Element element : elements) {
            this.elements.add(element);
        }
    }

    private List<Element> elements = new ArrayList();

    public List<Element> getElements() {
        return elements;
    }
}