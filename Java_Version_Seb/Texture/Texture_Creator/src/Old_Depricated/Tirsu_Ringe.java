package Old_Depricated;// import com.sun.source.tree.BreakTree;

import Old_Depricated.AreaHightmap;
import Old_Depricated.Circle_Generation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Deprecated
public class Tirsu_Ringe
{
    public static void createRing(int size, boolean startTop) throws IOException
    {
        Circle_Generation.circle(2000, 2000, 750, 20, size, startTop);
    }

    public static void circle(int width, int length, int radius, int linesize, int segments, boolean startTop) throws IOException {
        AreaHightmap map = new AreaHightmap(length, width, true);
        double[][] map_values = map.getHightmap();

        double[][] circleMap = calculateCircle(map_values, width/2, length/2,radius, linesize,segments, startTop);


        // __________________________________________________________________________________________________________ \\
        // Bild erstellen
        BufferedImage image = new BufferedImage(width, length, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        //Bildpunkte für map setzen
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                double value = circleMap[i][j];
                if (value == 0.0)
                {
                    g2d.setColor(Color.white);
                }
                else if (value == 1.0)
                {
                    g2d.setColor(Color.black);
                }
                g2d.fillRect(i, j, 1, 1);
            }
        }
        g2d.dispose();



        // speichern
        // String desktopPath = System.getProperty("user.home") + "/Desktop/";
        File file1 = new File("circle_Original.png");
        ImageIO.write(image, "png", file1);
    }

    private static double[][] calculateCircle(double[][] emptyMap, int startX, int startY ,int radius, int linesize, int segments, boolean startTop) {

        if (radius <= linesize)
        {
            linesize = 5;
        }

        for (int x = -radius; x <= radius; ++x)
        {
            for (int y = -radius; y <= radius; ++y)
            {
                if (x * x + y * y <= radius * radius && !( x * x + y * y <= (radius-linesize) * (radius-linesize)) )
                {
                    if (startTop)
                    {
                        if (isInSegment(segments, x, y, startTop))
                        {
                            emptyMap[startX+x][startY+y] = 1.0;
                        }
                    }
                    else
                    {
                        if (isInSegment(segments, x, y, startTop))
                        {
                            emptyMap[startX+x][startY+y] = 1.0;

                        }
                    }
                }

                if(Math.abs(x) < (linesize/2))
                {
                    if (!startTop)
                    {
                        if (y > (radius*3/5) && y < radius)
                        {
                            emptyMap[startX+x][startY+y] = 1.0;
                        }
                    }
                    else
                    {
                        if (y < -(radius*3/5) && y > -radius)
                        {
                            emptyMap[startX+x][startY+y] = 1.0;
                        }
                    }
                }
            }
        }
        return emptyMap;
    }


    private static boolean isInSegment(int segments, int x, int y, boolean startTop)
    {

        if (segments > 1)
        {
            double angle = 360.0/segments;
            double angleSegment = angle*4/5;

            double phi = ((Math.atan2(y, x)*180)/Math.PI);
            double phi2;
            if (startTop == true)
            {
                phi2 = ((phi+90+(angleSegment/2))%angle );
            }
            else
            {
                phi2 = ((phi-90+(angleSegment/2))%angle );
            }

            if (phi2 < 0)
            {
                phi2 = angle + phi2;
            }

            if ( phi2 <= angleSegment)
            {
                return true;
            }
            else return false;
        }
        else return true;
    }

}
