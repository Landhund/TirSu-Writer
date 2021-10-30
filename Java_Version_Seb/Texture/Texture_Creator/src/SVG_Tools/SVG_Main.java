package SVG_Tools;


import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Circle_Element;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Element;
import SVG_Tools.New_SVG_Workspace.Header_Generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SVG_Main
{
    public static void main(String[] args)
    {
        Header_Generator header_generator = new Header_Generator();
        header_generator.createSVGHeader(1000, 1000);
        header_generator.createCenteredOnOriginViewbox(20, 20);

        Circle_Element testCircle = new Circle_Element()
                .withRadius(8)
                .withSegents(5);
        testCircle.appendAttribute(Global_Att.FILL, "none");
        testCircle.appendAttribute(Global_Att.STROKE, "black");

        System.out.println(testCircle.toString());

        // Build
        saveSVG(header_generator, testCircle);
    }

    public static void saveSVG(Header_Generator header, Element... element)
    {

        try {
            File file1 = new File("NewExperimental" + ".svg");
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
            FileWriter fileWriter = new FileWriter("NewExperimental" + ".svg");
            fileWriter.write(header.getHeader());
            for (Element ele : element)
            {
                fileWriter.write("  " + ele.toString());
            }
            fileWriter.write("\n</svg>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
