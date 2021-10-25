package SVG_Tools.SVG_Elements;

public enum Line_Element
{
    X1("x1", "0"), X2("x2", "0"), Y1("y1", "0"), Y2("y2", "0"), PATHLENGTH("pathLength", "0");

    private Line_Element(String name, String value)
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
