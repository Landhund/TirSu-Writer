package SVG_Tools.SVG_Elements;

public enum Rectangle_Element
{
    X("x", "0"), Y("y", "0"), WIDTH("width", "0"), HIGHT("hight", "0"), RX("rx", "0"), RY("ry", "0");

    private Rectangle_Element(String name, String value)
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
