package SVG_Tools.New_SVG_Workspace.AttributeLibrary;

public enum Rectangle_Att implements Attribute {
    X("x", "0"),
    Y("y", "0"),
    WIDTH("width", "100%"),
    HEIGHT("height", "100%"),
    RX("rx", "auto"),
    RY("ry", "auto"),
    PATHLENGTH("pathLength", "none");

    /**
     *
     * @param identifier parameter that is used in a SVG
     * @param defaultValue parameter that should be set as default if no additional information are given
     */

    Rectangle_Att(String identifier, String defaultValue)
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
        if (attribute instanceof Rectangle_Att)
        {
            Rectangle_Att attributeIn = (Rectangle_Att) attribute;
            return attributeIn == this;
        }
        else return false;
    }
}
