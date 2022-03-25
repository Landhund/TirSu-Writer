package TirSu_Tools;


import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Circle_Element;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Element;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Group_Element;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Line_Element;
import SVG_Tools.New_SVG_Workspace.Header_Generator;
import TirSu_Tools.Symbol_Library.TirSu_Alphabet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TirSu_Circle
{
    private String word;

    private int radius;
    private int boxSize;

    private Header_Generator header_generator;
    private Circle_Element circleTirSu;
    private Line_Element marker;

    private Group_Element wordGroup = new Group_Element(0).withAttributes(new AttributeValue(Global_Att.FILL), new AttributeValue(Global_Att.STROKE));

    private Element[] letters;



    public TirSu_Circle(String word)
    {
        this.word = word;
        radius = (word.length()*5) + 20;
        boxSize = radius*2 + 45*3;

        header_generator = new Header_Generator();
        header_generator.createSVGHeader(1000, 1000);
        header_generator.createCenteredOnOriginViewbox(boxSize, boxSize);

        marker = new Line_Element().withStartPoint(0,-(4*radius/5)).withEndPoint(0,-radius);
        marker.appendAttribute(Global_Att.STROKE, "black");

        letters = new Element[word.length()]; getLetterElements();

        createTirSuCircle();
        getLetterElements();
        rotateLettersAndGroup();

    }

    private void getLetterElements()
    {
        for (int i = 0; i < word.length(); i++)
        {
            letters[i] = TirSu_Alphabet.valueOf(String.valueOf(word.charAt(i)).toUpperCase()).getLetter();
            letters[i].appendAttribute(Global_Att.TRANSFORM, "translate(0," + radius + ")");
            letters[i] = new Group_Element(1).withElements(letters[i]);
        }
    }

    private void createTirSuCircle()
    {
        double rot = 270 + ((360.0/word.length())/5)*3;
        circleTirSu = new Circle_Element().withRadius(radius).withSegments(word.length());
        circleTirSu.appendAttribute(Global_Att.FILL, "none");
        circleTirSu.appendAttribute(Global_Att.STROKE, "black");
        circleTirSu.appendAttribute(Global_Att.TRANSFORM, "rotate(" + rot + ")");
    }

    public void rotateLettersAndGroup()
    {
        double segmentAngle = 360/((double) word.length());
        double tempAngle = (180);

        for (int i = 0; i < letters.length; i++)
        {
            if (letters[i] instanceof Group_Element)
            {
                Group_Element letter = (Group_Element) letters[i];
                letter.appendAttribute(Global_Att.TRANSFORM, "rotate(" + tempAngle + ", 0, 0)");
                tempAngle = (tempAngle + segmentAngle);
                wordGroup.addElementsToGroup(letter);
            }
        }
        wordGroup.appendAttribute(Global_Att.ID, word);
    }

    public void saveTIRSU(boolean override)
    {

        if (override == true)
        {
            try {
                Files.deleteIfExists(Path.of(word + ".svg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Override File!");
        }


        try {
            File file1 = new File(word + ".svg");
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
            FileWriter fileWriter = new FileWriter(word + ".svg");
            fileWriter.write(header_generator.getHeader());
            fileWriter.write("\t" + wordGroup.toString() + "\n");
            fileWriter.write("\t" + circleTirSu.toString() + "\n");
            fileWriter.write("\t" + marker.toString() + "\n");
          //  for (Element ele : letters)
          //  {
          //      fileWriter.write("  " + ele.toString() + "\n");
          //  }
            fileWriter.write("</svg>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
