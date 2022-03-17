package SVG_Tools.New_SVG_Workspace.Element_Workspace;

import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Polyline_Att;

import java.util.ArrayList;
import java.util.List;

public class Polyline_Element implements Element
{
    List<AttributeValue> attributeValues = new ArrayList<>();

    public Polyline_Element()
    {
        attributeValues.add(new AttributeValue(Polyline_Att.POINTS));
    }

    /**
     * Add a value to a relevant Element
     * @param x_pos
     * @param y_pos
     */
    public Polyline_Element withNextPoint(int x_pos, int y_pos)
    {
        AttributeValue tester = new AttributeValue(Polyline_Att.POINTS);
        if (attributeValues.contains(tester))
        {
            String value = attributeValues.get(attributeValues.indexOf(tester)).getValue();
            value += " " + x_pos + "," + y_pos;
            attributeValues.get(attributeValues.indexOf(tester)).withValue(value);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param x_pos
     * @param y_pos
     */
    public Polyline_Element withStartPoint(int x_pos, int y_pos)
    {
        AttributeValue tester = new AttributeValue(Polyline_Att.POINTS);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(x_pos +"," + y_pos);
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
        boolean point = false;
        for (AttributeValue circleAttribute : attributeValues)
        {
            if (circleAttribute.equals(new AttributeValue(Polyline_Att.POINTS)))
            {
                point = true;
                continue;
            }
        }
        return point;
    }

    /**
     * Strings all relevant Attributes together
     * @return Circle_Element as a String for the SVG File
     */

    @Override
    public String toString()
    {
        String points = "";

        if (containsMinAttributes())
        {
            String polyline_element =  "<polyline";
            for (AttributeValue attributeValue : attributeValues)
            {
                if (attributeValue.equals(new AttributeValue(Polyline_Att.POINTS)))
                {
                    points = attributeValue.getValue();
                }
                polyline_element += " " + attributeValue.toString();
            }
            polyline_element += "/>";
            System.out.println(points);
            return polyline_element;
        }
        else return null;
    }


    @Override
    public void removeGlobalAttribute(Global_Att att) 
    {
        this.attributeValues.remove(new AttributeValue(att));
    }
 
}
