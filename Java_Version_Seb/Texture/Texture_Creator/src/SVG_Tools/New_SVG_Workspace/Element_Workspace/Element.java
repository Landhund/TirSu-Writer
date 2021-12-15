package SVG_Tools.New_SVG_Workspace.Element_Workspace;

import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Attribute;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;

import java.util.List;

public interface Element
{

    /** Dieses Interface soll für die folgenden Implementierungen aller SVG Elemente verwendet werden. */
    @Override
    String toString();

    List<AttributeValue> getAttributeValues();

    boolean containsMinAttributes();

    void appendAttribute(Global_Att global_att, String value);

    void removeGlobalAttribute(Global_Att att);
}
