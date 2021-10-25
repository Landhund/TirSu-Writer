package SVG_Tools;

import SVG_Tools.SVG_Elements.Circle_Creator_V2;
import SVG_Tools.SVG_Elements.Circle_Element;
import SVG_Tools.SVG_Elements.General_Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SVG_Constructor
{
    private static int id = 0;
    private Header_Generator header;
    private String description;
    private Element_Generator element;
    private Group_Generator group;

    public  SVG_Constructor(String description)
    {
        // Header of SVG
        header = new Header_Generator();
        {
            // Create and String together each Header element
            header.createSVGHeader(2000, 2000);
            header.createCenteredOnOriginViewbox(500, 500);
        }


        // Create Elements of SVG
        element = new Element_Generator();
        {
            element.segmentedCircle(200, 5, 5, "none");
            element.circle(20, 2, "none");
            element.roundedRectangle(30, 30, 5, 5);

        }

        // // Create Group
        // // Circle_Creator circlGen = new Circle_Creator();
        // Circle_Creator_V2 circle_creator_v2 = new Circle_Creator_V2(200, 5);
        // // String circle1 = circlGen.generateCircle(Circle_Element.CX, Circle_Element.CY, Circle_Element.SE, null);
        // String circle2 = circle_creator_v2.generateCircle(null) + "/>";
        //
        //  group = new Group_Generator(element.getElements());
        // {
        //     General_Element first = General_Element.FILL;
        //     first.setValue("none");
        //     group.createGroupe(first);
        // }

        this.description = description;
    }


    public void saveSVG()
    {

        try {
            File file1 = new File("svg_test" + id + ".svg");
            if (file1.createNewFile()) {
                System.out.println("File created: " + file1.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("svg_test" + id + ".svg");
            fileWriter.write(header.getHeader());
            fileWriter.write(element.getElements());
            fileWriter.write("</svg>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        id++;
    }


}
