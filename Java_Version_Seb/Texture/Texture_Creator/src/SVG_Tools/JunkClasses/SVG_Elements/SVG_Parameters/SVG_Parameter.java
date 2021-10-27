package SVG_Tools.JunkClasses.SVG_Elements.SVG_Parameters;

public class SVG_Parameter implements IF_SVG_Parameter
{
    private String name;
    private String value;

    private SVG_Parameter(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

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
