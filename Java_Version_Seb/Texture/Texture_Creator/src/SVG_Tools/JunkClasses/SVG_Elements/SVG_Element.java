package SVG_Tools.JunkClasses.SVG_Elements;

import SVG_Tools.JunkClasses.SVG_Elements.SVG_Parameters.SVG_Parameter;

public class SVG_Element implements IF_SVG_Element
{

    SVG_Parameter identifier;
    String value;

    public SVG_Element()
    {

    }

    public SVG_Element(SVG_Parameter element)
    {
        this.identifier = element;
        this.value = element.getDefaultValue();
    }

    public void withValue(String value)
    {
        if (value != null)
       {
           this.value = value;
       }
    }

    public void withValue(int value)
    {
        if (value != Integer.parseInt(this.value))
        {
            this.value = String.valueOf(value);
        }
    }
}
