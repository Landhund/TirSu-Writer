package SVG_Tools.JunkClasses.SVG_Elements.SVG_Parameters;

public interface IF_SVG_Parameter
{
    boolean equals(IF_SVG_Parameter element);

    String getIdentifier();
    String getDefaultValue();

    @Override
    String toString();
}
