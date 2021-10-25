package SVG_Tools.SVG_Elements;

public enum Polyline_Element
{
    POINTS("points", "0,0"), PATHLENGTH("pathLength", "0");

    private Polyline_Element(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    private String name;
    private String value;


    public String getElement() {
        return name + ":\"" + value + "\"";
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
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
