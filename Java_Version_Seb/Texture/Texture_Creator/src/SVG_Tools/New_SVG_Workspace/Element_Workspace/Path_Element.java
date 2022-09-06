package SVG_Tools.New_SVG_Workspace.Element_Workspace;

import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;

import java.util.List;

public class Path_Element implements Element
{

    /*
    *
    M = moveto
    L = lineto
    H = horizontal lineto
    V = vertical lineto
    C = curveto
    S = smooth curveto
    Q = quadratic Bézier curve
    T = smooth quadratic Bézier curveto
    A = elliptical Arc
    Z = closepath
    *
    */

    @Override
    public List<AttributeValue> getAttributeValues() {
        return null;
    }

    @Override
    public boolean containsMinAttributes() {
        return false;
    }

    @Override
    public void appendAttribute(Global_Att global_att, String value) {

    }

    @Override
    public void removeGlobalAttribute(Global_Att att) {

    }
}
