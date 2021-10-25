package SVG_Tools;

import SVG_Tools.SVG_Elements.General_Element;

public class Group_Generator
{
    private String resultingGroup = "";
    private String groupedElements = "";

    public Group_Generator(String groupedElements)
    {
        this.groupedElements = groupedElements;
    }

    public void createGroupe(General_Element... groupeByTheseWithValues)
    {
        // Groupe Header
        resultingGroup =  "  <g ";
        for (General_Element element: groupeByTheseWithValues)
        {
            resultingGroup += element.getElement() + " ";
        }
        resultingGroup += ">\n";

        // Groupe Elements
        for (String groupedElements : groupedElements.split("\n"))
        {
            resultingGroup += "    " + groupedElements + "\n";
        }

        // end of group
        resultingGroup += "  </g>\n";

    }

    public String getResultingGroup() {
        return resultingGroup;
    }


}
