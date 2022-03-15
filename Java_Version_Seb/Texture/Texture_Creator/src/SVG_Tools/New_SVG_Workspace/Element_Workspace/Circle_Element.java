package SVG_Tools.New_SVG_Workspace.Element_Workspace;

import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Circle_Att;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;

import java.util.ArrayList;
import java.util.List;

import static SVG_Tools.New_SVG_Workspace.AttributeLibrary.Circle_Att.*;

public class Circle_Element implements Element
{

    private List<AttributeValue> attributeValues = new ArrayList<>();

    public Circle_Element()
    {
        attributeValues.add(new AttributeValue(CX));
        attributeValues.add(new AttributeValue(Circle_Att.CY));
        attributeValues.add(new AttributeValue(Circle_Att.R));
    }

    /**
     * Add a value to a relevant Element
     * @param x_pos
     */
    public Circle_Element withCenterX(int x_pos)
    {
        AttributeValue tester = new AttributeValue(CX);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(x_pos);
        }
        return this;
    }

    /**
     * Set the y_Position Value of the center
     * @param y_pos
     */
    public Circle_Element withCenterY(int y_pos)
    {
        AttributeValue tester = new AttributeValue(Circle_Att.CY);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(y_pos);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param radius
     * @return
     */
    public Circle_Element withRadius(int radius)
    {
        AttributeValue tester = new AttributeValue(Circle_Att.R);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(radius);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param segmentAmounnt
     * @return
     */
    public Circle_Element withSegments(int segmentAmounnt)
    {
        if (attributeValues.contains(Circle_Att.SE))
        {
            attributeValues.get(attributeValues.indexOf(Circle_Att.SE)).withValue(segmentAmounnt);
        }
        else
        {
            attributeValues.add(new AttributeValue(Circle_Att.SE).withValue(segmentAmounnt));
        }
        return this;
    }

    public void appendAttribute(Global_Att global_att, String value)
    {
        AttributeValue tester = new AttributeValue(global_att).withValue(value);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(value);
        }
        else
        {
            attributeValues.add(tester);
        }

    }

    @Override
    public List<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    /**
     * Check if all 3 important Parameters are contained in the Circle Element
     * @return
     */

    @Override
    public boolean containsMinAttributes() {
        boolean cx = false, cy = false, r = false;
        for (AttributeValue circleAttribute : attributeValues)
        {
            if (circleAttribute.equals(new AttributeValue(CX)))
            {
                cx = true;
                continue;
            }
            if (circleAttribute.equals(new AttributeValue(CY)))
            {
                cy = true;
                continue;
            }
            if (circleAttribute.equals(new AttributeValue(R)))
            {
                r = true;
                continue;
            }
        }
        return cx && cy && r;
    }

    /**
     * Strings all relevant Attributes together
     * @return Circle_Element as a String for the SVG File
     */

    @Override
    public String toString()
    {
        String cx = "";
        String cy = "";
        String r = "";
        String se = "";

        if (containsMinAttributes())
        {
            String circle_Element =  "<circle";
            for (AttributeValue attributeValue : attributeValues)
            {
                if (attributeValue.equals(new AttributeValue(CX)))
                {
                    cx = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(CY)))
                {
                    cy = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(R)))
                {
                    r = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(Circle_Att.SE)))
                {
                    se = attributeValue.getValue();
                    AttributeValue stroke_dasharray = new AttributeValue(Global_Att.STROKE_DASHARRAY);
                    double segmentLength = calculateStroke_Dasharray(se, r);
                    stroke_dasharray.withValue(segmentLength*4 + ", " + segmentLength*1);
                    circle_Element += " " + stroke_dasharray.toString();
                    continue;
                }
                circle_Element += " " + attributeValue.toString();
            }
            circle_Element += "/>";
            return circle_Element;
        }
        else return null;
    }

    /**
     * Calculate the optimal relative distances for Circle Segments
     * @param se
     * @param r
     * @return
     */

    private double calculateStroke_Dasharray(String se, String r)
    {

        int radius = Integer.parseInt(r);
        int segmentAmount = Integer.parseInt(se);

        double lengthOfCircle = 2*Math.PI*radius;
        double lengthOfSegment = lengthOfCircle/segmentAmount;
        double lengthOfLineInSegment = lengthOfSegment/5;
        return lengthOfLineInSegment;
    }

    @Deprecated
    private double angleOfRotation(int segmentAmount)
    {
        double angleOfSegment = 360.0/segmentAmount;
        double angleOfSegmentStroke = (angleOfSegment/5)*3;
        return angleOfSegmentStroke-90;
    }

    @Override
    public void removeGlobalAttribute(Global_Att att) 
    {
        this.attributeValues.remove(new AttributeValue(att));
    }
}
