package SVG_Tools.SVG_Elements;

public enum General_Element
{
    FILL("fill", "none"), STROKE("stroke", "black"), STROKE_WIDTH("stroke-width", "1"), STROKE_DASHARRAY("stroke-dasharray", "0,0");

    private General_Element(String name, String defaultValue)
    {
        this.name = name;
        this.value = defaultValue;
    }

    private String name;
    private String value;


    public void setValue(String value) {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public String getElement()
    {
        return this.name + ":\"" + value + "\" ";
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
