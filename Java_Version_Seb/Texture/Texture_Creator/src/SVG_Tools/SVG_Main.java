package SVG_Tools;


import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;
import SVG_Tools.New_SVG_Workspace.Element_Workspace.*;
import SVG_Tools.New_SVG_Workspace.Header_Generator;
import TirSu_Tools.Symbol_Library.Letter_Element;
import TirSu_Tools.Symbol_Library.TirSu_Alphabet;
import TirSu_Tools.TirSu_Circle;

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
       // TirSu_Circle test = new TirSu_Circle("tuwuest");
       // test.saveTIRSU(true);

        allLetters();
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

        Group_Element group1 = new Group_Element(true).withElements(testCircle);

        Group_Element group2 = new Group_Element(true).withElements(testCircle, group1);

        Group_Element group3 = new Group_Element(true).withElements(testCircle, group2);




        // Build
        saveSVG("Test_SVG",header_generator, true, group1, group2, group3);
    }

    private static void allLetters()
    {
        Header_Generator header_generator = new Header_Generator();
        header_generator.createSVGHeader(1000, 1000);
        header_generator.createCenteredOnOriginViewbox(80, 80);

        // testSVG();

        Group_Element a = TirSu_Alphabet.A.getLetter(); a.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element b = TirSu_Alphabet.B.getLetter(); b.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element c = TirSu_Alphabet.C.getLetter(); c.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element d = TirSu_Alphabet.D.getLetter(); d.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element e = TirSu_Alphabet.E.getLetter(); e.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element f = TirSu_Alphabet.F.getLetter(); f.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element g = TirSu_Alphabet.G.getLetter(); g.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element h = TirSu_Alphabet.H.getLetter(); h.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element i = TirSu_Alphabet.I.getLetter(); i.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element j = TirSu_Alphabet.J.getLetter(); j.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element k = TirSu_Alphabet.K.getLetter(); k.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element l = TirSu_Alphabet.L.getLetter(); l.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element m = TirSu_Alphabet.M.getLetter(); m.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element n = TirSu_Alphabet.N.getLetter(); n.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element o = TirSu_Alphabet.O.getLetter(); o.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element p = TirSu_Alphabet.P.getLetter(); p.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element q = TirSu_Alphabet.Q.getLetter(); q.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element r = TirSu_Alphabet.R.getLetter(); r.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element s = TirSu_Alphabet.S.getLetter(); s.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element t = TirSu_Alphabet.T.getLetter(); t.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element u = TirSu_Alphabet.U.getLetter(); u.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element v = TirSu_Alphabet.V.getLetter(); v.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element w = TirSu_Alphabet.W.getLetter(); w.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element x = TirSu_Alphabet.X.getLetter(); x.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element y = TirSu_Alphabet.Y.getLetter(); y.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");
        Group_Element z = TirSu_Alphabet.Z.getLetter(); z.appendAttribute(Global_Att.TRANSFORM, "rotate(180, 0, 0)");


        /* Build */
        saveSVG("LetterA,V2", header_generator, true, a);
        saveSVG("LetterB,V2", header_generator, true, b);
        saveSVG("LetterC,V2", header_generator, true, c);
        saveSVG("LetterD,V2", header_generator, true, d);
        saveSVG("LetterE,V2", header_generator, true, e);
        saveSVG("LetterF,V2", header_generator, true, f);
        saveSVG("LetterG,V2", header_generator, true, g);
        saveSVG("LetterH,V2", header_generator, true, h);
        saveSVG("LetterI,V2", header_generator, true, i);
        saveSVG("LetterJ,V2", header_generator, true, j);
        saveSVG("LetterK,V2", header_generator, true, k);
        saveSVG("LetterL,V2", header_generator, true, l);
        saveSVG("LetterM,V2", header_generator, true, m);
        saveSVG("LetterN,V2", header_generator, true, n);
        saveSVG("LetterO,V2", header_generator, true, o);
        saveSVG("LetterP,V2", header_generator, true, p);
        saveSVG("LetterQ,V2", header_generator, true, q);
        saveSVG("LetterR,V2", header_generator, true, r);
        saveSVG("LetterS,V2", header_generator, true, s);
        saveSVG("LetterT,V2", header_generator, true, t);
        saveSVG("LetterU,V2", header_generator, true, u);
        saveSVG("LetterV,V2", header_generator, true, v);
        saveSVG("LetterW,V2", header_generator, true, w);
        saveSVG("LetterX,V2", header_generator, true, x);
        saveSVG("LetterY,V2", header_generator, true, y);
        saveSVG("LetterZ,V2", header_generator, true, z);
    }

    private static void testLenth()
    {
        String name = "aa";
        for (int i = 2; i < 21; i++) {
            TirSu_Circle test = new TirSu_Circle(name);
            test.saveTIRSU(true);
            name+="a";
        }
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
                if (ele instanceof Group_Element)
                {
                    Group_Element grele = (Group_Element) ele;
                    if (grele.getIndentAmount() == 0)
                    {
                        grele.setTextIndent(1);
                    }
                }
                fileWriter.write(ele.toString() + "\n");
            }
            fileWriter.write("</svg>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
