package SVG_Tools;

import SVG_Tools.SVG_Elements.Circle_Element;
import SVG_Tools.SVG_Elements.General_Element;

import java.util.HashMap;


public class Circle_Creator
{
    private static int id = 0;
    private static String name = "circle";



    public Circle_Creator()
    {

    }

    public String generateCircle(Circle_Element cx, Circle_Element cy, Circle_Element r, General_Element... general_elements)
    {
        String circle = "<circle ";
        if (cx.equals(Circle_Element.CX) && cy.equals(Circle_Element.CY) && r.equals(Circle_Element.R))
        {
            circle += cx.getElement();
            circle += cy.getElement();
            circle += r.getElement();
        }
        else throw new IllegalArgumentException("Circle Input not valid!");

        if (general_elements != null)
        {
            for (General_Element element : general_elements)
            {
                circle += element.getElement();
            }
        }

        circle += "/>";
        id++;

        return circle;
    }

    public String generateCircle(Circle_Element cx, Circle_Element cy, Circle_Element r, Circle_Element se, General_Element... general_elements)
    {
        String circle = "<circle ";
        if (cx.equals(Circle_Element.CX) && cy.equals(Circle_Element.CY) && r.equals(Circle_Element.R) && se.equals(Circle_Element.SE))
        {
            circle += cx.getElement();
            circle += cy.getElement();
            circle += r.getElement();

            double segmentLength = calculateStroke_Dasharray(se.getValue(), r.getValue());

            General_Element stroke_dasharray = General_Element.STROKE_DASHARRAY;
            stroke_dasharray.setValue(segmentLength*4 + "," + segmentLength*1);
        }
        else throw new IllegalArgumentException("Circle Input not valid!");

        if (general_elements != null)
        {
            for (General_Element element : general_elements)
            {
                circle += element.getElement();
            }
        }

        circle += "/>";
        id++;

        return circle;
    }

    // ---------------------------------------- Helping Methodes ---------------------------------------- \\

    private double calculateStroke_Dasharray(String se, String r)
    {

        int radius = Integer.parseInt(r);
        int segmentAmount = Integer.parseInt(se);

        double lengthOfCircle = 2*Math.PI*radius;
        double lengthOfSegment = lengthOfCircle/segmentAmount;
        double lengthOfLineInSegment = lengthOfSegment/5;
        return lengthOfLineInSegment;
    }

    private double angleOfRotation(int segmentAmount)
    {
        double angleOfSegment = 360.0/segmentAmount;
        double angleOfSegmentStroke = (angleOfSegment/5)*3;
        return angleOfSegmentStroke-90;
    }

}
