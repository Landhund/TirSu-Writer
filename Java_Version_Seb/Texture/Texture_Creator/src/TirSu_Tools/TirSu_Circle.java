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
    private int word_length;
    private int radius;
    private int boxSize;

    private Header_Generator header_generator;
    private Circle_Element circleTirSu;
    private Line_Element marker;

    private Group_Element wordGroup = new Group_Element(1).withAttributes(new AttributeValue(Global_Att.FILL), new AttributeValue(Global_Att.STROKE));

    private Element[] letters;



    public TirSu_Circle(String word, boolean githyanki)
    {
        this.word = word;
        this.word_length = word.length();

        radius = (word.length()*5) + 20;
        boxSize = radius*2 + 45*3;

        header_generator = new Header_Generator();
        header_generator.createSVGHeader(1000, 1000);
        header_generator.createCenteredOnOriginViewbox(boxSize, boxSize);

        letters = new Element[word.length()]; getLetterElements();

        getLetterElements();
        createTirSuCircle(githyanki);


        if (githyanki)
        {
            rotateLettersGITHYANKI();
            marker = new Line_Element().withStartPoint(0,-(4*radius/5)).withEndPoint(0,-radius);
            marker.appendAttribute(Global_Att.STROKE, "black");
        }
        else
        {
            rotateLettersGITHZERAI();
            marker = new Line_Element().withStartPoint(0,(4*radius/5)).withEndPoint(0,radius);
            marker.appendAttribute(Global_Att.STROKE, "black");
        }

    }


    private void getLetterElements()
    {
        String combination = "";
        int combination_counter = 0;

        for (int i = 0; i < word.length(); i++)
        {
            // letters[i] = TirSu_Alphabet.valueOf(String.valueOf(word.charAt(i)).toUpperCase()).getLetter();

            combination = findLetterCombinations(i);
            letters[i] = TirSu_Alphabet.valueOf(combination).getLetter();
            letters[i].appendAttribute(Global_Att.TRANSFORM, "translate(0," + radius + ")");
            letters[i] = new Group_Element(1).withElements(letters[i]);
            if (combination.length() > 1)
            {
                i++;
            }
            combination = "";
            combination_counter++;
        }
        word_length = combination_counter;
    }

    private String findLetterCombinations(int pos_letter)
    {
        String combination = "";
        String first = String.valueOf(word.charAt(pos_letter)).toUpperCase();
        String second = "";

        if (word.length() > pos_letter + 1)
        {
            second = String.valueOf(word.charAt(pos_letter+1)).toUpperCase();
        }

        try
        {
            combination = first + second;
            TirSu_Alphabet.valueOf(combination).getLetter();
            return combination;
        }
        catch (Exception e)
        {
            return first;
        }

    }


    private void createTirSuCircle(boolean githyanki)
    {
        double rot = 270 + ((360.0/word_length)/5)*3;
        circleTirSu = new Circle_Element().withRadius(radius).withSegments(word_length);
        circleTirSu.appendAttribute(Global_Att.FILL, "none");
        circleTirSu.appendAttribute(Global_Att.STROKE, "black");

        if (!githyanki)
        {
            rot += 180;
        }
        circleTirSu.appendAttribute(Global_Att.TRANSFORM, "rotate(" + rot + ")");
    }


    @Deprecated
    private String toSting()
    {
        String word  = "";
        word += wordGroup.toString() + "\n";
        word += "\t" + circleTirSu.toString() + "\n";
        word += "\t" + marker.toString() + "\n";
        return word;
    }

    public Group_Element getWordGroup()
    {
        Group_Element wordGroup = new Group_Element();
        wordGroup.addElementsToGroup(this.wordGroup, this.circleTirSu, this.marker);
        return wordGroup;
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
            fileWriter.write(wordGroup.toString() + "\n");
            fileWriter.write("\t" + circleTirSu.toString() + "\n");
            fileWriter.write("\t" + marker.toString() + "\n");
            fileWriter.write("</svg>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getBoxSize() {
        return boxSize;
    }

    public String getWord()
    {
        return this.word;
    }

    // --------------- githyanki --------------- \\ Clockwise from top
    private void rotateLettersGITHYANKI()
    {
        double segmentAngle = 360/((double) word_length);
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



    // --------------- githzerai --------------- \\ Counter Clockwise from Bottom
    private void rotateLettersGITHZERAI()
    {
        double segmentAngle = 360/((double) word_length);
        double tempAngle = (0);

        for (int i = 0; i < letters.length; i++)
        {
            if (letters[i] instanceof Group_Element)
            {
                Group_Element letter = (Group_Element) letters[i];
                letter.appendAttribute(Global_Att.TRANSFORM, "rotate(" + -tempAngle + ", 0, 0)");
                tempAngle = (tempAngle + segmentAngle);
                wordGroup.addElementsToGroup(letter);
            }
        }
        wordGroup.appendAttribute(Global_Att.ID, word);
    }

}
