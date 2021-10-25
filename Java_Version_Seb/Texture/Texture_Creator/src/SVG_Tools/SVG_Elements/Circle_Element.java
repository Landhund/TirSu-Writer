package SVG_Tools.SVG_Elements;

public enum Circle_Element
{
    CX("cx", "0"), CY("cy", "0"), R("r", "0"), SE("se", "0");

    private Circle_Element(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    private String name;
    private String value;


    public String getElement() {
        return name + ":\"" + value + "\"";
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean equals(Circle_Element element)
    {
        if(this.name == element.getName())
        {
            return true;
        }
        else return false;
    }
}
