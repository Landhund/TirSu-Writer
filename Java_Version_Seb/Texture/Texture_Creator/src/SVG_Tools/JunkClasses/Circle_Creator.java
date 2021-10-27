package SVG_Tools.JunkClasses;

import SVG_Tools.JunkClasses.SVG_Elements.SVG_Parameters.Circle_Parameter;



public class Circle_Creator
{
    private static int id = 0;
    private static String name = "circle";



    public Circle_Creator()
    {

    }

    public String generateCircle(Circle_Parameter cx, Circle_Parameter cy, Circle_Parameter r)
    {
        String circle = "<circle ";
        if (cx.equals(Circle_Parameter.CX) && cy.equals(Circle_Parameter.CY) && r.equals(Circle_Parameter.R))
        {
            //circle += cx.getElement();
            //circle += cy.getElement();
            //circle += r.getElement();
        }
        else throw new IllegalArgumentException("Circle Input not valid!");



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
