package Script_Element.TirSu;


import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Circle_Element;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Element;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Group_Element;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.Line_Element;
import SVG_Tools.New_SVG_Workspace.Header_Generator;
import Script_Element.FileHandler;
import Script_Element.TirSu.TirSu_Symbol_Library.TirSu_Alphabet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TirSu_Circle {
    private final String filename;
    private final String word;
    private int word_length;
    private int radius;
    private int boxSize;
    private List<String> tirSu_alphabet;

    private Header_Generator header_generator;
    private Circle_Element circleTirSu;
    private final Line_Element marker;

    private final Group_Element wordGroup = new Group_Element(1).withAttributes(new AttributeValue(Global_Att.FILL), new AttributeValue(Global_Att.STROKE));

    private final Element[] letters;
    private List<Element> letters_new;
    private List<String> correctedStringList;


    /**
     * Konstruktor für einzelne wörter
     *
     * @param word      the word to be constructed
     * @param githyanki the dialect to be used
     */
    public TirSu_Circle(String word, boolean githyanki) {
        this.filename = word;
        this.word = word;
        this.word_length = word.length();

        letters = new Element[word.length()];
        getLetterElements();

        getLetterElements();
        createHeader();
        createTirSuCircle(githyanki);


        if (githyanki) {
            rotateLettersGITHYANKI();
            marker = new Line_Element().withStartPoint(0, -(4 * radius / 5)).withEndPoint(0, -radius);
            marker.appendAttribute(Global_Att.STROKE, "black");
        } else {
            rotateLettersGITHZERAI();
            marker = new Line_Element().withStartPoint(0, (4 * radius / 5)).withEndPoint(0, radius);
            marker.appendAttribute(Global_Att.STROKE, "black");
        }

    }

    /**
     * Constructor using a word in a selected script variation using the alphabet variation of the code
     *
     * @param word           the word to be constructed
     * @param tirSu_alphabet a List of the letters in the alphabet
     * @param githyanki      the dialect to be used
     */
    public TirSu_Circle(String word, List<String> tirSu_alphabet, boolean githyanki) {
        this.filename = word;
        this.word = word;
        this.word_length = word.length();
        this.tirSu_alphabet = tirSu_alphabet;

        letters = new Element[word.length()];
        letters_new = new ArrayList<>();

        getLetterElementsNew();
        calcDimensions();
        getLettersFromCorrectedString();
        createHeader();
        createTirSuCircle(githyanki);

        if (githyanki) {
            newRotateLettersGITHYANKI();
            marker = new Line_Element().withStartPoint(0, -(4 * radius / 5)).withEndPoint(0, -radius);
            marker.appendAttribute(Global_Att.STROKE, "black");
        } else {
            newRotateLettersGITHZERAI();
            marker = new Line_Element().withStartPoint(0, (4 * radius / 5)).withEndPoint(0, radius);
            marker.appendAttribute(Global_Att.STROKE, "black");
        }

    }

    /**
     * Constructor for words with a selected filename and a selected script
     *
     * @param word      the word to be constructed
     * @param filename  the name that the file should be saved as
     * @param githyanki the dialect to be used
     */
    public TirSu_Circle(String word, String filename, boolean githyanki) {
        this.filename = filename;
        this.word = word;
        this.word_length = word.length();

        letters = new Element[word.length()];
        getLetterElements();

        calcDimensions();
        getLetterElements();
        createHeader();
        createTirSuCircle(githyanki);


        if (githyanki) {
            rotateLettersGITHYANKI();
            marker = new Line_Element().withStartPoint(0, -(4 * radius / 5)).withEndPoint(0, -radius);
            marker.appendAttribute(Global_Att.STROKE, "black");
        } else {
            rotateLettersGITHZERAI();
            marker = new Line_Element().withStartPoint(0, (4 * radius / 5)).withEndPoint(0, radius);
            marker.appendAttribute(Global_Att.STROKE, "black");
        }

    }

    /**
     * Standard Constructor that is used
     * Contains the word with a selected filename and a selected script
     * Uses the alphabet vatiation of my code
     *
     * @param word           the word to be constructed
     * @param filename       the name that the file should be saved as
     * @param tirSu_alphabet a List of the letters in the alphabet
     * @param githyanki      the dialect to be used
     */
    public TirSu_Circle(String word, String filename, List<String> tirSu_alphabet, boolean githyanki) {
        this.word = word;
        this.filename = filename;
        this.tirSu_alphabet = tirSu_alphabet;

        letters = new Element[word.length()];
        letters_new = new ArrayList<>();

        getLetterElementsNew();
        calcDimensions();
        getLettersFromCorrectedString();
        createHeader();
        createTirSuCircle(githyanki);

        if (githyanki) {
            newRotateLettersGITHYANKI();
            // rotateLettersGITHYANKI();
            marker = new Line_Element().withStartPoint(0, -(4 * radius / 5)).withEndPoint(0, -radius);
            marker.appendAttribute(Global_Att.STROKE, "black");
        } else {
            newRotateLettersGITHZERAI();
            // rotateLettersGITHZERAI();
            marker = new Line_Element().withStartPoint(0, (4 * radius / 5)).withEndPoint(0, radius);
            marker.appendAttribute(Global_Att.STROKE, "black");
        }

    }


    // -------------------- String Input -------------------- \\

    private void getLetterElements() {
        String combination = "";
        int combination_counter = 0;

        for (int i = 0; i < word.length(); i++) {
            // letters[i] = TirSu_Alphabet.valueOf(String.valueOf(word.charAt(i)).toUpperCase()).getLetter();

            combination = findLetterCombinations(i);
            letters[i] = TirSu_Alphabet.valueOf(combination).getLetter();
            letters[i].appendAttribute(Global_Att.TRANSFORM, "translate(0," + radius + ")");
            letters[i] = new Group_Element(1).withElements(letters[i]);
            if (combination.length() > 1) {
                i++;
            }
            combination = "";
            combination_counter++;
        }
        word_length = combination_counter;
    }

    private String findLetterCombinations(int pos_letter) {
        String combination = "";
        String first = String.valueOf(word.charAt(pos_letter)).toUpperCase();
        String second = "";

        if (word.length() > pos_letter + 1) {
            second = String.valueOf(word.charAt(pos_letter + 1)).toUpperCase();
        }

        try {
            combination = first + second;
            TirSu_Alphabet.valueOf(combination).getLetter();
            return combination;
        } catch (Exception e) {
            return first;
        }

    }

    // -----

    private void getLetterElementsNew() {
        word_length = 0;
        this.correctedStringList = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            String combination = "";
            String first = String.valueOf(word.charAt(i)).toUpperCase();
            String second = "";

            if (word.length() > i + 1) {
                second = String.valueOf(word.charAt(i + 1)).toUpperCase();
            }

            combination = (first + second).toLowerCase();

            if (this.tirSu_alphabet.contains((combination).toLowerCase())) {
                correctedStringList.add(combination.toUpperCase());
                i++;
            } else if (this.tirSu_alphabet.contains((first).toLowerCase())) {
                correctedStringList.add(first.toUpperCase());
            } else {
                throw new IllegalArgumentException("\"" + combination + "\" is not contained in the defined Alphabet!");
            }

            word_length++;
        }
    }

    private void getLettersFromCorrectedString() {
        for (String letter : correctedStringList) {
            Group_Element letter_element = TirSu_Alphabet.valueOf(letter).getLetter();
            letter_element.appendAttribute(Global_Att.TRANSFORM, "translate(0," + radius + ")");
            letters_new.add(new Group_Element(1).withElements(letter_element));

        }
    }

    // -------------------- Element Input -------------------- \\

    //-------------------------------------------------------- \\

    // -------------------- TirSuCircle Header -------------------- \\

    private void createHeader() {
        header_generator = new Header_Generator();
        header_generator.createSVGHeader(1000, 1000);
        header_generator.createCenteredOnOriginViewbox(boxSize, boxSize);
    }

    private void calcDimensions() {
        this.radius = (word_length * 5) + 20;
        this.boxSize = radius * 2 + 45 * 3;
    }

    //-------------------------------------------------------- \\

    private void createTirSuCircle(boolean githyanki) {
        double rot = 270 + ((360.0 / word_length) / 5) * 3;
        circleTirSu = new Circle_Element().withRadius(radius).withSegments(word_length);
        circleTirSu.appendAttribute(Global_Att.FILL, "none");
        circleTirSu.appendAttribute(Global_Att.STROKE, "black");

        if (!githyanki) {
            rot += 180;
        }
        circleTirSu.appendAttribute(Global_Att.TRANSFORM, "rotate(" + rot + ")");
    }


    public Group_Element getWordGroup() {
        Group_Element wordGroup = new Group_Element();
        wordGroup.addElementsToGroup(this.wordGroup, this.circleTirSu, this.marker);
        return wordGroup;
    }

    // -------------------- Save ----------------------- \\
    public void saveTIRSU(boolean override) {
        if (override) {
            try {
                Files.deleteIfExists(Path.of(filename + ".svg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Override File!");
        }


        FileHandler.fileSetup(filename);

        StringBuilder stringBuilder = new StringBuilder(filename + ".svg");
        stringBuilder.append(header_generator.getHeader());
        stringBuilder.append(wordGroup.toString() + "\n");
        stringBuilder.append("\t" + circleTirSu.toString() + "\n");
        stringBuilder.append("\t" + marker.toString() + "\n");
        stringBuilder.append("</svg>");

        try {
            FileWriter fileWriter = new FileWriter(filename + ".svg");
            //    fileWriter.write(header_generator.getHeader());
            //    fileWriter.write(wordGroup.toString() + "\n");
            //    fileWriter.write("\t" + circleTirSu.toString() + "\n");
            //    fileWriter.write("\t" + marker.toString() + "\n");
            //    fileWriter.write("</svg>");
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //-------------------------------------------------------- \\


    // -------------------- Getter and Setter ----------------------- \\

    public int getBoxSize() {
        return boxSize;
    }

    public String getWord() {
        return this.word;
    }
    //-------------------------------------------------------- \\


    // --------------- githyanki --------------- \\ Clockwise from top
    private void rotateLettersGITHYANKI() {
        double segmentAngle = 360 / ((double) word_length);
        double tempAngle = (180);

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] instanceof Group_Element) {
                Group_Element letter = (Group_Element) letters[i];
                letter.appendAttribute(Global_Att.TRANSFORM, "rotate(" + tempAngle + ", 0, 0)");
                tempAngle = (tempAngle + segmentAngle);
                wordGroup.addElementsToGroup(letter);
            }
        }
        wordGroup.appendAttribute(Global_Att.ID, word);
    }

    private void newRotateLettersGITHYANKI() {
        double segmentAngle = 360 / ((double) word_length);
        double tempAngle = (180);

        for (Element letter : letters_new) {

            if (letter instanceof Group_Element) {
                letter.appendAttribute(Global_Att.TRANSFORM, "rotate(" + tempAngle + ", 0, 0)");
                tempAngle = (tempAngle + segmentAngle);
                wordGroup.addElementsToGroup(letter);
            }
        }
        wordGroup.appendAttribute(Global_Att.ID, word);
    }
    //-------------------------------------------------------- \\


    // --------------- githzerai --------------- \\ Counter Clockwise from Bottom
    private void rotateLettersGITHZERAI() {
        double segmentAngle = 360 / ((double) word_length);
        double tempAngle = (0);

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] instanceof Group_Element) {
                Group_Element letter = (Group_Element) letters[i];
                letter.appendAttribute(Global_Att.TRANSFORM, "rotate(" + -tempAngle + ", 0, 0)");
                tempAngle = (tempAngle + segmentAngle);
                wordGroup.addElementsToGroup(letter);
            }
        }
        wordGroup.appendAttribute(Global_Att.ID, word);
    }

    private void newRotateLettersGITHZERAI() {
        double segmentAngle = 360 / ((double) word_length);
        double tempAngle = (0);

        for (Element letter : letters_new) {
            if (letter instanceof Group_Element) {
                letter.appendAttribute(Global_Att.TRANSFORM, "rotate(" + -tempAngle + ", 0, 0)");
                tempAngle = (tempAngle + segmentAngle);
                wordGroup.addElementsToGroup(letter);
            }
        }
        wordGroup.appendAttribute(Global_Att.ID, word);
    }
    //-------------------------------------------------------- \\


    // -------------------- DEPRICATED -------------------- \\
    @Deprecated
    private String toSting() {
        String word = "";
        word += wordGroup.toString() + "\n";
        word += "\t" + circleTirSu.toString() + "\n";
        word += "\t" + marker.toString() + "\n";
        return word;
    }

    private String newToSting() {
        String word = "";
        word += wordGroup.toString() + "\n";
        word += "\t" + circleTirSu.toString() + "\n";
        word += "\t" + marker.toString() + "\n";
        return word;
    }
    //-------------------------------------------------------- \\
}
