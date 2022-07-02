package SVG_Tools.New_SVG_Workspace.AttributeLibrary;

public enum Line_Att  implements Attribute{
   
    X1("x1", "0"),
    X2("x2", "0"),
    Y1("y1", "0"),
    Y2("y2", "0"),
    PATHLENGTH("pathLength", "none");

    /**
     *
     * @param identifier parameter that is used in a SVG
     * @param defaultValue parameter that should be set as default if no additional information are given
     */

    Line_Att(String identifier, String defaultValue)
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
        if (attribute instanceof Line_Att)
        {
            Line_Att attributeIn = (Line_Att) attribute;
            return attributeIn == this;
        }
        else return false;
    }

}
