package SVG_Tools.New_SVG_Workspace.Element_Workspace;

import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Ellipse_Att;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;

import java.util.ArrayList;
import java.util.List;

public class Ellipse_Element implements Element
{

    private List<AttributeValue> attributeValues = new ArrayList<>();

    public Ellipse_Element()
    {
        attributeValues.add(new AttributeValue(Ellipse_Att.CX));
        attributeValues.add(new AttributeValue(Ellipse_Att.CY));
        attributeValues.add(new AttributeValue(Ellipse_Att.RX));
        attributeValues.add(new AttributeValue(Ellipse_Att.RY));
    }

    /**
     * Add a value to a relevant Element
     * @param x_pos
     * @param y_pos
     */
    public Ellipse_Element withCenter(int x_pos, int y_pos)
    {
        AttributeValue testerX = new AttributeValue(Ellipse_Att.CX);
        AttributeValue testerY = new AttributeValue(Ellipse_Att.CY);
        if (attributeValues.contains(testerX) && attributeValues.contains(testerY))
        {
            attributeValues.get(attributeValues.indexOf(testerX)).withValue(x_pos);
            attributeValues.get(attributeValues.indexOf(testerY)).withValue(y_pos);
        }
        return this;
    }



    /**
     * Add a value to a relevant Element
     * @param rad_x
     * @param rad_y
     */
    public Ellipse_Element withXandYRadius(int rad_x, int rad_y)
    {
        AttributeValue testerX = new AttributeValue(Ellipse_Att.RX);
        AttributeValue testerY = new AttributeValue(Ellipse_Att.RY);
        if (attributeValues.contains(testerX) && attributeValues.contains(testerY))
        {
            attributeValues.get(attributeValues.indexOf(testerX)).withValue(rad_x);
            attributeValues.get(attributeValues.indexOf(testerY)).withValue(rad_y);
        }
        return this;
    }


    /**
     * Add a value to a relevant Element
     * @param radius
     */
    public Ellipse_Element withRadius(int radius)
    {
        AttributeValue testerX = new AttributeValue(Ellipse_Att.RX);
        AttributeValue testerY = new AttributeValue(Ellipse_Att.RY);
        if (attributeValues.contains(testerX) && attributeValues.contains(testerY))
        {
            attributeValues.get(attributeValues.indexOf(testerX)).withValue(radius);
            attributeValues.get(attributeValues.indexOf(testerX)).withValue(radius);
        }
        return this;
    }


    /**
     * Add a value to a relevant Element
     * @param x_pos
     */
    public Ellipse_Element withCenterX(int x_pos)
    {
        AttributeValue tester = new AttributeValue(Ellipse_Att.CX);
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
    public Ellipse_Element withCenterY(int y_pos)
    {
        AttributeValue tester = new AttributeValue(Ellipse_Att.CY);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(y_pos);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param radius_X
     * @return
     */
    public Ellipse_Element withRadiusX(int radius_X)
    {
        AttributeValue tester = new AttributeValue(Ellipse_Att.RX);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(radius_X);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param radius_Y
     * @return
     */
    public Ellipse_Element withRadiusY(int radius_Y)
    {
        AttributeValue tester = new AttributeValue(Ellipse_Att.RY);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(radius_Y);
        }
        return this;
    }

    public Ellipse_Element withPathlength(String value)
    {
        AttributeValue tester = new AttributeValue(Ellipse_Att.PATHLENGTH);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(value);
        }
        return this;
    }

    public Ellipse_Element asU(int x, int y)
    {
        AttributeValue dashArray = new AttributeValue(Global_Att.STROKE_DASHARRAY).withValue("28,36167");
        attributeValues.add(dashArray);
        AttributeValue transform = new AttributeValue(Global_Att.TRANSFORM).withValue("rotate(180," + x + "," + y + ")");
        attributeValues.add(transform);
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
        boolean cx = false, cy = false, rx = false, ry = false;
        for (AttributeValue circleAttribute : attributeValues)
        {
            if (circleAttribute.equals(new AttributeValue(Ellipse_Att.CX)))
            {
                cx = true;
                continue;
            }
            if (circleAttribute.equals(new AttributeValue(Ellipse_Att.CY)))
            {
                cy = true;
                continue;
            }
            if (circleAttribute.equals(new AttributeValue(Ellipse_Att.RX)))
            {
                rx = true;
                continue;
            }
            if (circleAttribute.equals(new AttributeValue(Ellipse_Att.RY)))
            {
                ry = true;
                continue;
            }
        }
        return cx && cy && rx && ry;
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
        String rx = "";
        String ry = "";

        if (containsMinAttributes())
        {
            String ellipse_Element =  "<ellipse";
            for (AttributeValue attributeValue : attributeValues)
            {
                if (attributeValue.equals(new AttributeValue(Ellipse_Att.CX)))
                {
                    cx = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(Ellipse_Att.CY)))
                {
                    cy = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(Ellipse_Att.RX)))
                {
                    rx = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(Ellipse_Att.RY)))
                {
                    ry = attributeValue.getValue();
                }
                ellipse_Element += " " + attributeValue.toString();
            }
            ellipse_Element += "/>";
            return ellipse_Element;
        }
        else return null;
    }

    @Override
    public void removeGlobalAttribute(Global_Att att) 
    {
        this.attributeValues.remove(new AttributeValue(att));
    }
}
