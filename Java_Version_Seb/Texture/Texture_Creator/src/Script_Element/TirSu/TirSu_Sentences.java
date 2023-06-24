package Script_Element.TirSu;

import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Group_Element;
import SVG_Tools.New_SVG_Workspace.Header_Generator;
import Script_Element.FileHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TirSu_Sentences {
    private final String fileName;
    private final String sentence;
    private int wordCount;
    private String[] words;
    private int x_distance;
    private int y_distance;
    private List<String> tirSu_alphabet;


    private Header_Generator header_generator;
    private TirSu_Circle[] wordsCircles;
    private Group_Element sentenceGroup;

    private final boolean githyanki;


    // -------------------- Konstruktor -------------------- \\
    public TirSu_Sentences(String sentence, boolean githyanki) {
        this.fileName = sentence;
        this.sentence = sentence;
        this.githyanki = githyanki;
        spliceSentence();
        createWordSymbols();
        buildSentence();
        headerGenerator();
    }

    public TirSu_Sentences(String sentence, List<String> tirSu_alphabet, boolean githyanki) {
        this.fileName = sentence;
        this.sentence = sentence;
        this.githyanki = githyanki;
        this.tirSu_alphabet = tirSu_alphabet;
        spliceSentence();
        createWordSymbolsUsingAlphabet();
        buildSentence();
        headerGenerator();
    }

    public TirSu_Sentences(String sentence, String fileName, boolean githyanki) {
        this.fileName = fileName;
        this.sentence = sentence;
        this.githyanki = githyanki;
        spliceSentence();
        createWordSymbols();
        buildSentence();
        headerGenerator();
    }

    public TirSu_Sentences(String sentence, String fileName, List<String> tirSu_alphabet, boolean githyanki) {
        this.fileName = fileName;
        this.sentence = sentence;
        this.githyanki = githyanki;
        this.tirSu_alphabet = tirSu_alphabet;
        spliceSentence();
        createWordSymbolsUsingAlphabet();
        buildSentence();
        headerGenerator();
    }


    // -------------------- word-creator -------------------- \\
    private void spliceSentence() {
        this.words = this.sentence.split(" ");
        wordCount = this.words.length;
        this.wordsCircles = new TirSu_Circle[wordCount];
    }

    private void createWordSymbols() {
        for (int i = 0; i < wordCount; i++) {
            this.wordsCircles[i] = new TirSu_Circle(words[i], githyanki);
        }
    }

    private void createWordSymbolsUsingAlphabet() {
        for (int i = 0; i < wordCount; i++) {
            this.wordsCircles[i] = new TirSu_Circle(words[i], this.tirSu_alphabet, githyanki);
        }
    }

    // -------------------- sentence-builder -------------------- \\
    private void buildSentence() {
        this.sentenceGroup = new Group_Element(1);
        this.sentenceGroup.appendAttribute(Global_Att.ID, sentence);
        int offset = 0;
        for (TirSu_Circle word : wordsCircles) {
            offset += word.getBoxSize() / 2;

            Group_Element wordGroup = word.getWordGroup();
            wordGroup.appendAttribute(Global_Att.TRANSFORM, "translate(" + offset + " 0)");
            this.sentenceGroup.addElementsToGroup(wordGroup);

            offset += word.getBoxSize() / 2;

            if (y_distance < word.getBoxSize()) {
                this.y_distance = word.getBoxSize();
            }
        }
        this.x_distance = offset;
    }


    // -------------------- Header-Generation -------------------- \\
    private void headerGenerator() {
        int modifier = headerCalculator();
        if (modifier == 0) {
            modifier = 1;
        }

        this.header_generator = new Header_Generator();
        this.header_generator.createSVGHeader(1000, 1000 / modifier);
        this.header_generator.createViewBox(0, -y_distance / 2, x_distance, y_distance);
    }

    private int headerCalculator() {
        if (y_distance != 0) {
            return x_distance / y_distance;
        } else return 0;
    }


    // -------------------- save ----------------------- \\
    public void saveTIRSU(boolean override) {

        if (override == true) {
            try {
                Files.deleteIfExists(Path.of(fileName + ".svg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Override File!");
        }


        FileHandler.fileSetup(fileName);


        StringBuilder builder = new StringBuilder();
        builder.append(header_generator.getHeader());
        builder.append(sentenceGroup.toString() + "\n");
        builder.append("</svg>");

        try {
            FileWriter fileWriter = new FileWriter(fileName + ".svg");
            // fileWriter.write(header_generator.getHeader());
            // fileWriter.write(sentenceGroup.toString() + "\n");
            // fileWriter.write("</svg>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
