package Script_Element;

import java.io.File;
import java.io.IOException;

public class FileHandler {

    public static void saveFile() {

    }

    public static void fileSetup(String filename) {
        try {
            File file1 = new File(filename + ".svg");
            if (file1.createNewFile()) {
                System.out.println("File created: " + file1.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
