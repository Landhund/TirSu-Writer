package TirSu_Tools;

import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Group_Element;
import SVG_Tools.New_SVG_Workspace.Header_Generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TirSu_Sentences
{
    private String fileName;
    private String sentence;
    private int wordCount;
    private String[] words;
    private int x_distance;
    private int y_distance;

    private Header_Generator header_generator;

    private TirSu_Circle[] wordsCircles;
    private Group_Element sentenceGroup;

    private boolean githyanki;



    // -------------------- Konstruktor -------------------- \\
    public TirSu_Sentences(String sentence, boolean githyanki)
    {
        this.fileName = sentence;
        this.sentence = sentence;
        this.githyanki = githyanki;
        spliceSentence();
        createWordSymbols();
        buildSentence();
        headerGenerator();
    }

    public TirSu_Sentences(String sentence, String fileName, boolean githyanki)
    {
        this.fileName = fileName;
        this.sentence = sentence;
        this.githyanki = githyanki;
        spliceSentence();
        createWordSymbols();
        buildSentence();
        headerGenerator();
    }


    // -------------------- word-creator -------------------- \\
    private void spliceSentence()
    {
        this.words = this.sentence.split(" ");
        wordCount = this.words.length;
        this.wordsCircles = new TirSu_Circle[wordCount];
    }

    private void createWordSymbols()
    {
        for (int i = 0; i < wordCount; i++) {
            this.wordsCircles[i] = new TirSu_Circle(words[i], githyanki);
        }
    }

    // -------------------- sentence-builder -------------------- \\
    private void buildSentence()
    {
        this.sentenceGroup = new Group_Element(1);
        this.sentenceGroup.appendAttribute(Global_Att.ID, sentence);
        int offset = 0;
        for (TirSu_Circle word : wordsCircles)
        {
            offset += word.getBoxSize()/2;

            Group_Element wordGroup = word.getWordGroup();
            wordGroup.appendAttribute(Global_Att.TRANSFORM, "translate(" + offset + " 0)");
            this.sentenceGroup.addElementsToGroup(wordGroup);

            offset += word.getBoxSize()/2;

            if (y_distance < word.getBoxSize())
            {
                this.y_distance = word.getBoxSize();
            }
        }
        this.x_distance = offset;
    }


    // -------------------- Header-Generation -------------------- \\
    private void headerGenerator()
    {
        int modifier = headerCalculator();

        this.header_generator = new Header_Generator();
        this.header_generator.createSVGHeader(1000, 1000/modifier);
        this.header_generator.createViewBox(0, -y_distance/2, x_distance, y_distance);
    }

    private int headerCalculator()
    {
        return x_distance/y_distance;
    }


    // -------------------- save ----------------------- \\
    public void saveTIRSU(boolean override)
    {

        if (override == true)
        {
            try {
                Files.deleteIfExists(Path.of(fileName + ".svg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Override File!");
        }


        try {
            File file1 = new File(fileName + ".svg");
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
            FileWriter fileWriter = new FileWriter(fileName + ".svg");
            fileWriter.write(header_generator.getHeader());
            fileWriter.write(sentenceGroup.toString() + "\n");
            fileWriter.write("</svg>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
