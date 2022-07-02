package SVG_Tools.New_SVG_Workspace.AttributeLibrary;

import java.util.HashSet;

import org.w3c.dom.Attr;

public enum Global_Att implements Attribute
{

    ID("id", "0"),
    TABINDEX("tabindex", "0"),
    FILL("fill", "none"),
    FILL_OPACITY("fill-opacity", "1"),
    STROKE("stroke", "black"),
    STROKE_DASHARRAY("stroke-dasharray", ""),
    STROKE_DASHOFFSET("stroke-dashoffset", "0"),
    STROKE_LINECAP("stroke-linecap", "butt"),
    STROKE_LINEJOIN("stroke-linejoin", "miter"),
    TRANSFORM("transform", ""),
    PATHLENGTH("pathLength", "0");

    /**
     *
     * @param identifier parameter that is used in a SVG
     * @param defaultValue parameter that should be set as default if no additional information are given
     */

    Global_Att(String identifier, String defaultValue)
            {
        this.identifier = identifier;
        this.defaultValue = defaultValue;
            }

    String identifier;
    String defaultValue;
    private static HashSet<Attribute> values = new HashSet<Attribute>();;

    /** Methode to return the Identifier from the Parameter
     *
     * @return String of identifier
     */

    @Override
    public String getIdentifier() {
        return this.identifier;
    }

    /** Methode to return the default Value from the given parameter
     *
     * @return String of defaultValue
     */

    @Override
    public String getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public boolean isEquals(Attribute attribute)
    {
        if (getEnums().contains(attribute))
        {
            Global_Att attributeIn = (Global_Att) attribute;
            return attributeIn == this;
        }
        else return false;
    }

    private static HashSet<Attribute> getEnums() 
    {
        for (Attribute c : Global_Att.values()) 
        {
            values.add(c);
        }
      
        return values;
    }

    public static boolean isInEnum(Attribute att)
    {
        return (getEnums().contains(att)) ? true : false;
    }
}
