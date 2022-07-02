package SVG_Tools.JunkClasses;


@Deprecated
public class Group_Generator
{
    private String resultingGroup = "";
    private String groupedElements = "";

    public Group_Generator(String groupedElements)
    {
        this.groupedElements = groupedElements;
    }


    public String getResultingGroup() {
        return resultingGroup;
    }


}
