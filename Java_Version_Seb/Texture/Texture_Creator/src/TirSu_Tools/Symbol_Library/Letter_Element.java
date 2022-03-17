package TirSu_Tools.Symbol_Library;

import SVG_Tools.New_SVG_Workspace.Element_Workspace.Element;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Ellipse_Element;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Line_Element;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Polyline_Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Letter_Element
 */
public enum Letter_Element          // TODO: #25 Write the Elements of witch the Alphabet Symbols consist
{
    // --------------------- BASE ELEMENTS --------------------- \\
    CENTER_LINE_SHORT(new Line_Element().withStartPoint(0,0).withEndPoint(0, 10)),
    CENTER_LINE_MID(new Line_Element().withStartPoint(0,0).withEndPoint(0, 15)),
    CENTER_LINE_LONG(new Line_Element().withStartPoint(0,0).withEndPoint(0,20)),

    // --------------------- BODY ELEMENTS --------------------- \\
    ARM_RIGHT_LOW(new Line_Element().withStartPoint(0,10).withEndPoint(-10, 0)),
    ARM_LEFT_LOW(new Line_Element().withStartPoint(0,10).withEndPoint(10, 0)),
    ARM_RIGHT_MID(new Line_Element().withStartPoint(0,15).withEndPoint(-10, 5)),
    ARM_LEFT_MID(new Line_Element().withStartPoint(0,15).withEndPoint(10, 5)),
    ARM_RIGHT_HIGH(new Line_Element().withStartPoint(0,20).withEndPoint(-10, 10)),
    ARM_LEFT_HIGH(new Line_Element().withStartPoint(0,20).withEndPoint(10, 10)),
    T_ARM_LOW(new Line_Element().withStartPoint(-7,10).withEndPoint(7,10)),
    T_ARM_MID(new Line_Element().withStartPoint(-7,15).withEndPoint(7,15)),
    T_ARM_HIGH(new Line_Element().withStartPoint(-7, 20).withEndPoint(7, 20)),

    // --------------------- NECK ELEMENTS --------------------- \\
    NECK_HIGH_LONG(new Line_Element().withStartPoint(0,20).withEndPoint(0,35)),
    NECK_HIGH_Short(new Line_Element().withStartPoint(0,20).withEndPoint(0,25)),

    // --------------------- HEAD ELEMENTS --------------------- \\
    HEAD_T(new Line_Element().withStartPoint(-10,35).withEndPoint(10,35)),
    HEAD_DOUBLE_T(new Line_Element().withStartPoint(0,20).withEndPoint(0,35),
            new Line_Element().withStartPoint(-10,35).withEndPoint(10,35),
            new Line_Element().withStartPoint(-10,30).withEndPoint(10,30)),

    HEAD_ARM_RIGHT(new Polyline_Element().withStartPoint(0,25).withNextPoint(0,35).withNextPoint(-10,25)),
    HEAD_DOUBLE_ARM_RIGHT(new Polyline_Element().withStartPoint(0,25).withNextPoint(0,35).withNextPoint(-10,25),
            new Line_Element().withStartPoint(0,30).withEndPoint(-10, 20)),
    HEAD_ARM_LEFT(new Polyline_Element().withStartPoint(0,20).withNextPoint(0,35).withNextPoint(10,25)),
    HEAD_DOUBLE_ARM_LEFT(new Polyline_Element().withStartPoint(0,20).withNextPoint(0,35).withNextPoint(10,25),
            new Line_Element().withStartPoint(0,30).withEndPoint(10, 20)),

    HEAD_ROOF(new Polyline_Element().withStartPoint(-10,25).withNextPoint(0,35).withNextPoint(10,25)),
    HEAD_ROOF_INVERTED(new Polyline_Element().withStartPoint(-10,35).withNextPoint(0,25).withNextPoint(10,35)),

    HEAD_TRIANGLE(new Polyline_Element().withStartPoint(-10,25).withNextPoint(0,35).withNextPoint(10,25).withNextPoint(-10,25).withNextPoint(0,35)),
    HEAD_TRIANGLE_INVERSE(new Polyline_Element().withStartPoint(-10,35).withNextPoint(0,25).withNextPoint(10,35).withNextPoint(-10,35).withNextPoint(0,25)),

    HEAD_ELLIPSE_HIGH(new Ellipse_Element().withCenter(0, 30).withXandYRadius(8,5)),
    HEAD_ELLIPSE_MID(new Ellipse_Element().withCenter(0,20).withXandYRadius(8,5)),
    HEAD_ELLIPSE_LOW(new Ellipse_Element().withCenter(0,15).withXandYRadius(8,5)),

    HEAD_RIGHT_OPEN_SQUARE_HIGH(new Polyline_Element().withStartPoint(-8,25).withNextPoint(8,25).withNextPoint(8,35).withNextPoint(-8,35)),
    HEAD_LEFT_OPEN_SQUARE_HIGH(new Polyline_Element().withStartPoint(8,25).withNextPoint(-8,25).withNextPoint(-8,35).withNextPoint(8,35)),

    HEAD_U_HIGH(new Ellipse_Element().withCenter(0, 35).withXandYRadius(8,10).asU(0,35));


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