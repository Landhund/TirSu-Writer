package SVG_Tools.SVG_Elements;

import java.util.HashMap;

public class Circle_Creator_V2
{
    private HashMap<Circle_Element, String> defaultElements = new HashMap<>();
    private HashMap<General_Element, String> general_element = new HashMap<>();

    public Circle_Creator_V2()
    {
        defaultElements.put(Circle_Element.CX, Circle_Element.CX.getValue());
        defaultElements.put(Circle_Element.CY, Circle_Element.CY.getValue());
        defaultElements.put(Circle_Element.R, Circle_Element.R.getValue());
    }

    public Circle_Creator_V2(int r)
    {
        defaultElements.put(Circle_Element.CX, Circle_Element.CX.getValue());
        defaultElements.put(Circle_Element.CY, Circle_Element.CY.getValue());
        defaultElements.put(Circle_Element.R, String.valueOf(r));
    }

    public Circle_Creator_V2(int r, int se)
    {
        defaultElements.put(Circle_Element.CX, Circle_Element.CX.getValue());
        defaultElements.put(Circle_Element.CY, Circle_Element.CY.getValue());
        defaultElements.put(Circle_Element.R, String.valueOf(r));
        defaultElements.put(Circle_Element.SE, String.valueOf(se));
    }

    public Circle_Creator_V2(int cx, int cy, int r)
    {
        defaultElements.put(Circle_Element.CX, String.valueOf(cx));
        defaultElements.put(Circle_Element.CY, String.valueOf(cy));
        defaultElements.put(Circle_Element.R, String.valueOf(r));
    }

    public Circle_Creator_V2(int cx, int cy, int r, int se)
    {
        defaultElements.put(Circle_Element.CX, String.valueOf(cx));
        defaultElements.put(Circle_Element.CY, String.valueOf(cy));
        defaultElements.put(Circle_Element.R, String.valueOf(r));
        defaultElements.put(Circle_Element.SE, String.valueOf(se));
    }

    public int getValueFor(Circle_Element element)
    {
        return Integer.parseInt(defaultElements.get(element));
    }

    public void addGeneralElements(General_Element... general_elements)
    {
        for (General_Element element : general_elements)
        {
            general_element.put(element, null);
        }
    }

    public void removeGeneralElements(General_Element... general_elements)
    {
        for (General_Element element : general_elements)
        {
            if (general_element.containsKey(element))
            {
                general_element.remove(element);
            }
        }
    }

    public String generateCircle(General_Element... general_elements)
    {
        String circle = "<circle ";
        for (Circle_Element element : defaultElements.keySet())
        {
            circle += getElement(element) + " ";
        }

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


    // ---------------------------------------- Getter Methodes ---------------------------------------- \\

    public String getElement(Circle_Element element)
    {
        return element.getName() + ":\"" + defaultElements.get(element) + "\"";
    }

}
