package SVG_Tools.New_SVG_Workspace.Element_Workspace;

import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Rectangle_Att;

import java.util.ArrayList;
import java.util.List;

public class Rectangle_Element implements Element
{

    private List<AttributeValue> attributeValues = new ArrayList<>();

    public Rectangle_Element()
    {
        attributeValues.add(new AttributeValue(Rectangle_Att.X));
        attributeValues.add(new AttributeValue(Rectangle_Att.Y));
        attributeValues.add(new AttributeValue(Rectangle_Att.WIDTH));
        attributeValues.add(new AttributeValue(Rectangle_Att.HEIGHT));
    }

    /**
     * Add a value to a relevant Element
     * @param x
     * @param y
     */
    public Rectangle_Element withXandY(int x, int y)
    {
        AttributeValue testerX = new AttributeValue(Rectangle_Att.X);
        AttributeValue testerY = new AttributeValue(Rectangle_Att.Y);
        if (attributeValues.contains(testerX) && attributeValues.contains(testerY))
        {
            attributeValues.get(attributeValues.indexOf(testerX)).withValue(x);
            attributeValues.get(attributeValues.indexOf(testerY)).withValue(y);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param width
     * @param height
     */
    public Rectangle_Element withWidthAndHeight(int width, int height)
    {
        AttributeValue testerWidth = new AttributeValue(Rectangle_Att.WIDTH);
        AttributeValue testerHeight = new AttributeValue(Rectangle_Att.HEIGHT);
        if (attributeValues.contains(testerWidth) && attributeValues.contains(testerHeight))
        {
            attributeValues.get(attributeValues.indexOf(testerWidth)).withValue(width);
            attributeValues.get(attributeValues.indexOf(testerHeight)).withValue(height);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param rx
     * @param ry
     */
    public Rectangle_Element withRXandRY(int rx, int ry)
    {
        AttributeValue testerRX = new AttributeValue(Rectangle_Att.RY);
        AttributeValue testerRY = new AttributeValue(Rectangle_Att.RY);
        if (attributeValues.contains(testerRX) && attributeValues.contains(testerRY))
        {
            attributeValues.get(attributeValues.indexOf(testerRX)).withValue(rx);
            attributeValues.get(attributeValues.indexOf(testerRY)).withValue(ry);
        }
        return this;
    }



    // --------------------------- Specific Values of Points --------------------------------- \\

    /**
     * Add a value to a relevant Element
     * @param x
     */
    public Rectangle_Element withX(int x)
    {
        AttributeValue tester = new AttributeValue(Rectangle_Att.X);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(x);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param y
     */
    public Rectangle_Element withY(int y)
    {
        AttributeValue tester = new AttributeValue(Rectangle_Att.Y);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(y);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param width
     */
    public Rectangle_Element withWidth(int width)
    {
        AttributeValue tester = new AttributeValue(Rectangle_Att.WIDTH);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(width);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param hight
     */
    public Rectangle_Element withHight(int hight)
    {
        AttributeValue tester = new AttributeValue(Rectangle_Att.HEIGHT);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(hight);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param rx
     */
    public Rectangle_Element withRX(int rx)
    {
        AttributeValue tester = new AttributeValue(Rectangle_Att.RX);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(rx);
        }
        return this;
    }

    /**
     * Add a value to a relevant Element
     * @param ry
     */
    public Rectangle_Element withRY(int ry)
    {
        AttributeValue tester = new AttributeValue(Rectangle_Att.RY);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(ry);
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
     * Check if all 6 important Parameters are contained in the Rectangle Element
     * @return
     */

    @Override
    public boolean containsMinAttributes() {
        boolean x = false, y = false, width = false, hight = false;
        for (AttributeValue rectangleAttribute : attributeValues)
        {
            if (rectangleAttribute.equals(new AttributeValue(Rectangle_Att.X)))
            {
                x = true;
                continue;
            }
            if (rectangleAttribute.equals(new AttributeValue(Rectangle_Att.Y)))
            {
                y = true;
                continue;
            }
            if (rectangleAttribute.equals(new AttributeValue(Rectangle_Att.WIDTH)))
            {
                width= true;
                continue;
            }

            if (rectangleAttribute.equals(new AttributeValue(Rectangle_Att.HEIGHT)))
            {
                hight = true;
                continue;
            }
        }
        return x && y && width && hight;
    }

    /**
     * Strings all relevant Attributes together
     * @return Rectangle_Element as a String for the SVG File
     */

    @Override
    public String toString()
    {
        String x = "";
        String y = "";
        String width = "";
        String height = "";
        String rx = "";
        String ry = "";

        if (containsMinAttributes())
        {
            String rectangle_Element =  "<rect";
            for (AttributeValue attributeValue : attributeValues)
            {
                if (attributeValue.equals(new AttributeValue(Rectangle_Att.X)))
                {
                    x = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(Rectangle_Att.Y)))
                {
                    y = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(Rectangle_Att.WIDTH)))
                {
                    width = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(Rectangle_Att.HEIGHT)))
                {
                    height = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(Rectangle_Att.RX)))
                {
                    rx = attributeValue.getValue();
                }
                else if (attributeValue.equals(new AttributeValue(Rectangle_Att.RY)))
                {
                    ry = attributeValue.getValue();
                }
                rectangle_Element += " " + attributeValue.toString();
            }
            rectangle_Element += "/>";
            System.out.println(x + " " + y + " " + width + " " + height + " " + rx + " " + ry );
            return rectangle_Element;
        }
        else return null;
    }


    @Override
    public void removeGlobalAttribute(Global_Att att)
    {
        this.attributeValues.remove(new AttributeValue(att));
    }
}
