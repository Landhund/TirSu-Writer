package SVG_Tools.New_SVG_Workspace.AttributeLibrary;

public interface Attribute
{
    /** Dieses Interface soll für die folgenden Implementierungen aller SVG Parameter verwendet werden. */
    String getIdentifier();
    String getDefaultValue();

    boolean isEquals(Attribute attribute);
}
