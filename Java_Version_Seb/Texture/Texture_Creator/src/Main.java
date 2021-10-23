import SVG_Tools.Path_Generator;
import TirSu_Tools.TirSu_Circle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)  throws IOException
    {
        // Tirsu_Ringe.circle(2000, 2000, 750, 10, 9, true);

        Path_Generator test = new Path_Generator();
        test.saveSVG();
    }





    @Deprecated
    public static void createRandomHightmap() throws IOException
    {
        int width = 2000;
        int length = 2000;
        int maxValue = 300;
        ColorInterpreter ci = new ColorInterpreter(maxValue);

        AreaHightmap map = new AreaHightmap(length, width,maxValue);
        double[][] map_values = map.getHightmap();

        AreaHightmap flat = map.flattenHightMap();
        double[][] flat_values = flat.getHightmap();

        AreaHightmap flat_flat = map.flattenHightMap();
        double[][] flat_flat_values = flat_flat.getHightmap();

        AreaHightmap flat_flat_flat = map.flattenHightMap();
        double[][] flat_flat_flat_values = flat_flat_flat.getHightmap();

// __________________________________________________________________________________________________________ \\
        // Bild erstellen
        BufferedImage image = new BufferedImage(width, length, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        //Bildpunkte für map setzen
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                double value = map_values[i][j];
                g2d.setColor(ci.createColorOnScale(value));
                g2d.fillRect(i, j,1,1);
            }
        }
        g2d.dispose();

        // Bild erstellen
        BufferedImage image_flat = new BufferedImage(width, length, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d_flat = image_flat.createGraphics();

        //Bildpunkte für flat setzen
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                double value = flat_values[i][j];
                g2d_flat.setColor(ci.createColorOnScale(value));
                g2d_flat.fillRect(i, j,1,1);
            }
        }
        g2d_flat.dispose();

        // Bild erstellen
        BufferedImage image_flat_flat = new BufferedImage(width, length, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d_flat_flat   = image_flat_flat.createGraphics();

        //Bildpunkte für flat setzen
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                double value = flat_flat_values[i][j];
                g2d_flat_flat.setColor(ci.createColorOnScale(value));
                g2d_flat_flat.fillRect(i, j,1,1);
            }
        }
        g2d_flat_flat.dispose();

        // Bild erstellen
        BufferedImage image_flat_flat_flat = new BufferedImage(width, length, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d_flat_flat_flat = image_flat_flat_flat.createGraphics();

        //Bildpunkte für flat setzen
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                double value = flat_flat_flat_values[i][j];
                g2d_flat_flat_flat.setColor(ci.createColorOnScale(value));
                g2d_flat_flat_flat.fillRect(i, j,1,1);
            }
        }
        g2d_flat_flat_flat.dispose();




        // speichern
        // String desktopPath = System.getProperty("user.home") + "/Desktop/";
        File file1 = new File("original.png");
        ImageIO.write(image, "png", file1);

        File file2 = new File("iteration1.png");
        ImageIO.write(image_flat, "png", file2);

        File file3 = new File("iteration2.png");
        ImageIO.write(image_flat_flat, "png", file3);

        File file4 = new File("iteration3.png");
        ImageIO.write(image_flat_flat_flat, "png", file4);
    }

}
