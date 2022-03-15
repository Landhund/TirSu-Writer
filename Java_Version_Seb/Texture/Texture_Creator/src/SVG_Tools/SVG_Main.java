package SVG_Tools;


import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.*;
import SVG_Tools.New_SVG_Workspace.Header_Generator;
import TirSu_Tools.Symbol_Library.Letter_Element;
import TirSu_Tools.Symbol_Library.TirSu_Alphabet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SVG_Main
{
    public static void main(String[] args)
    {
        Header_Generator header_generator = new Header_Generator();
        header_generator.createSVGHeader(1000, 1000);
        header_generator.createCenteredOnOriginViewbox(80, 80);

        // testSVG();

        Group_Element group = TirSu_Alphabet.A.getLetter();

        /* Build */
        saveSVG("LetterA", header_generator, true, group);
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private static void testSVG() {
        Header_Generator header_generator = new Header_Generator();
        header_generator.createSVGHeader(1000, 1000);
        header_generator.createCenteredOnOriginViewbox(20, 20);

        Circle_Element testCircle = new Circle_Element()
                .withRadius(8)
                .withSegments(5);
        testCircle.appendAttribute(Global_Att.FILL, "none");
        testCircle.appendAttribute(Global_Att.STROKE, "black");

        Rectangle_Element testRec = new Rectangle_Element()
                .withXandY(-5, -5)
                .withWidthAndHeight(10, 10);
        testRec.appendAttribute(Global_Att.FILL, "none");
        testRec.appendAttribute(Global_Att.STROKE, "black");

        Group_Element group = new Group_Element(true, testCircle, testRec);


        // Build
        saveSVG("Test_SVG",header_generator, true, group);
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void saveSVG(Header_Generator header, Element... element)
    {

        try {
            File file1 = new File("SVG_Test" + ".svg");
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
            FileWriter fileWriter = new FileWriter("NewExperimental_5" + ".svg");
            fileWriter.write(header.getHeader());
            for (Element ele : element)
            {
                fileWriter.write("  " + ele.toString() + "\n");
            }
            fileWriter.write("\n</svg>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveSVG(String savename, Header_Generator header, boolean override, Element... element)
    {

        if (override == true)
        {
            try {
                Files.deleteIfExists(Path.of(savename + ".svg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Override File!");
        }


        try {
            File file1 = new File(savename + ".svg");
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
            FileWriter fileWriter = new FileWriter(savename + ".svg");
            fileWriter.write(header.getHeader());
            for (Element ele : element)
            {
                fileWriter.write("  " + ele.toString() + "\n");
            }
            fileWriter.write("</svg>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
