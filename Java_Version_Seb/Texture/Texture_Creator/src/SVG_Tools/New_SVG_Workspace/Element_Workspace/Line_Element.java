package SVG_Tools.New_SVG_Workspace.Element_Workspace;

import java.util.ArrayList;
import java.util.List;

import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Line_Att;

public class Line_Element implements Element
{
    List<AttributeValue> attributeValues = new ArrayList<>();

    public Line_Element()
    {
        attributeValues.add(new AttributeValue(Line_Att.X1));
        attributeValues.add(new AttributeValue(Line_Att.Y1));
        attributeValues.add(new AttributeValue(Line_Att.X2));
        attributeValues.add(new AttributeValue(Line_Att.Y2));
    }

    /**
     * Add a value to a relevant Element
     * @param x1_pos
     * @param y1_pos 
     */
    public Line_Element withStartPoint(int x1_pos, int y1_pos)
    {
        AttributeValue testerX = new AttributeValue(Line_Att.X1);
        AttributeValue testerY = new AttributeValue(Line_Att.Y1);
        if (attributeValues.contains(testerX) && attributeValues.contains(testerY))
        {
            attributeValues.get(attributeValues.indexOf(testerX)).withValue(x1_pos);
            attributeValues.get(attributeValues.indexOf(testerY)).withValue(y1_pos);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param x2_pos
     * @param y2_pos 
     */
    public Line_Element withEndPoint(int x2_pos, int y2_pos)
    {
        AttributeValue testerX = new AttributeValue(Line_Att.X2);
        AttributeValue testerY = new AttributeValue(Line_Att.Y2);
        if (attributeValues.contains(testerX) && attributeValues.contains(testerY))
        {
            attributeValues.get(attributeValues.indexOf(testerX)).withValue(x2_pos);
            attributeValues.get(attributeValues.indexOf(testerY)).withValue(y2_pos);
        }
        return this;
    }

    // --------------------------- Specific Values of Points --------------------------------- \\ 
    
    /**
     * Add a value to a relevant Element
     * @param x1_pos
     */
    public Line_Element withX1(int x1_pos)
    {
        AttributeValue tester = new AttributeValue(Line_Att.X1);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(x1_pos);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param y1_pos
     */
    public Line_Element withY1(int y1_pos)
    {
        AttributeValue tester = new AttributeValue(Line_Att.Y1);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(y1_pos);
        }
        return this;
    }
    
    /**
     * Add a value to a relevant Element
     * @param x2_pos
     */
    public Line_Element withX2(int x2_pos)
    {
        AttributeValue tester = new AttributeValue(Line_Att.X2);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(x2_pos);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param y2_pos
     */
    public Line_Element withY2(int y2_pos)
    {
        AttributeValue tester = new AttributeValue(Line_Att.Y2);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(y2_pos);
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
        boolean x1 = false, y1 = false, x2 = false, y2 = false;
        for (AttributeValue circleAttribute : attributeValues)
        {
            if (circleAttribute.equals(new AttributeValue(Line_Att.X1)))
            {
                x1 = true;
                continue;
            }
            if (circleAttribute.equals(new AttributeValue(Line_Att.Y1)))
            {
                y1 = true;
                continue;
            }
            if (circleAttribute.equals(new AttributeValue(Line_Att.X2)))
            {
                x2 = true;
                continue;
            }
            if (circleAttribute.equals(new AttributeValue(Line_Att.Y2)))
            {
                y2 = true;
                continue;
            }
        }
        return x1 && y1 && x2 && y2;
    }

    /**
     * Strings all relevant Attributes together
     * @return Circle_Element as a String for the SVG File
     */

    @Override
    public String toString()
    {
        String x1 = "";
        String y1 = "";
        String x2 = "";
        String y2 = "";

        if (containsMinAttributes())
        {
            String line_Element =  "<line";
            for (AttributeValue attributeValue : attributeValues)
            {
                if (attributeValue.equals(new AttributeValue(Line_Att.X1)))
                {
                    x1 = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(Line_Att.Y1)))
                {
                    y1 = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(Line_Att.X2)))
                {
                    x2 = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(Line_Att.Y2)))
                {
                    y2 = attributeValue.getValue();
                }
                line_Element += " " + attributeValue.toString();
            }
            line_Element += "/>";
            System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 );
            return line_Element;
        }
        else return null;
    }


    @Override
    public void removeGlobalAttribute(Global_Att att) 
    {
        this.attributeValues.remove(new AttributeValue(att));
    }
 
}
