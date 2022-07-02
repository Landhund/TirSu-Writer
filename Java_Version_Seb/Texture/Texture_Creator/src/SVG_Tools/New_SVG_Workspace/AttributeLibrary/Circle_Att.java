package SVG_Tools.New_SVG_Workspace.AttributeLibrary;

public enum Circle_Att implements Attribute
{
    CX("cx", "0"),
    CY("cy", "0"),
    R("r", "0"),
    PATHLENGTH("pathLength", "none"),
    SE("se", "0");

    /**
     *
     * @param identifier parameter that is used in a SVG
     * @param defaultValue parameter that should be set as default if no additional information are given
     */

    Circle_Att(String identifier, String defaultValue)
    {
        this.identifier = identifier;
        this.defaultValue = defaultValue;
    }

    String identifier;
    String defaultValue;


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
        if (attribute instanceof Circle_Att)
        {
            Circle_Att attributeIn = (Circle_Att) attribute;
            return attributeIn == this;
        }
        else return false;
    }
}
