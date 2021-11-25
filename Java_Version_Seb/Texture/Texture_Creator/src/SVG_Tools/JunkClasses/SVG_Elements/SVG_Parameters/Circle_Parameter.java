package SVG_Tools.JunkClasses.SVG_Elements.SVG_Parameters;

@Deprecated
public enum Circle_Parameter implements IF_SVG_Parameter
{
    CX("cx", "0"), CY("cy", "0"), R("r", "0"), SE("se", "0");

    private Circle_Parameter(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    private String name;
    private String value;


    // ---------- Element Methodes ---------- \\

    @Override
    public String toString()
    {
        return name + ":\"" + value + "\"";
    }

    @Override
    public boolean equals(IF_SVG_Parameter element) {
        if(this.name == element.getIdentifier())
        {
            return true;
        }
        else return false;
    }

    @Override
    public String getIdentifier() {
        return name;
    }

    @Override
    public String getDefaultValue() {
        return value;
    }
}
