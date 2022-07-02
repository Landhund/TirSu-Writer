package SVG_Tools;

import SVG_Tools.New_SVG_Workspace.Element_Workspace.Element;
import SVG_Tools.New_SVG_Workspace.Header_Generator;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SVG_Constructor
{
    private static int id;
    private String name;
    private Header_Generator header;
    private List<Element> elements = new ArrayList<>();

    public  SVG_Constructor(String name)
    {
       this.name = name;
       this.id++;

    }


    public void saveSVG(boolean override)
    {

        if (override == true)
        {
            try {
                Files.deleteIfExists(Path.of(name + id + ".svg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Override File!");
        }

        try {
            File file1 = new File(name + id + ".svg");
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
            FileWriter fileWriter = new FileWriter(name + id + ".svg");

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        id++;
    }


    private FileWriter writeSVG(FileWriter fileWriter) throws IOException
    {
        fileWriter.write(header.getHeader());
        for (Element element : elements)
        {
            fileWriter.write(element.toString());
        }
        fileWriter.write("</svg>");
        return fileWriter;
    }


}
