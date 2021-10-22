import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
// import java.util.Arrays;

public class Circle_Generation
{

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

        // int[][] gapAreas = findGapAreas(segments, radius);

        for (int x = -radius; x <= radius; ++x)
        {
            for (int y = -radius; y <= radius; ++y)
            {
                if (x * x + y * y <= radius * radius && !( x * x + y * y <= (radius-linesize) * (radius-linesize)) )
                {
                    /*
                    if (isInSegment(segments, gapAreas, y))
                    {
                        emptyMap[startX+x][startY+y] = 1.0;
                    }
                     */
                    if (startTop)
                    {
                        if (isInSegment(segments, x, y, true))
                        {
                            emptyMap[startX+x][startY+y] = 1.0;
                        }
                    }
                    else
                    {
                        if (isInSegment(segments, x, y))
                        {
                            emptyMap[startX+x][startY+y] = 1.0;
                        }
                    }
                }
            }
        }
        return emptyMap;
    }

    /*
    private static int[][] findGapAreas(int segments, int radius)
    {
        if (segments == 1 || segments < 0)
        {
            return null;
        }

        else if ((segments & 1) == 1)
        {
            int[][] result = new int[(segments/2) + 1][2];
            int angle = Math.round(360/segments);
            int segmentAngle = Math.round((angle*4/5));
            int breakAngle =  angle-segmentAngle;
            System.out.println("Ungerade -> Angle:" + angle + " Segment:" + segmentAngle + " Break" + breakAngle);

            for (int i = 0; i < (segments/2) + 1; i++)
            {
                result[i][0] = (int) Math.round(radius*Math.cos((angle*i) + (segmentAngle/2) ) );
                result[i][1] = (int) Math.round(radius*Math.cos((angle*i) + (segmentAngle/2) + breakAngle ));

                System.out.println(Arrays.toString(result[i]));
            }
            return result;
        }
        else // if ((segments & 1) == 0)
        {
            int[][] result = new int[(segments/2)][2];
            int angle = Math.round(360/segments);
            int segmentAngle = Math.round((angle*4/5));
            int breakAngle =  angle-segmentAngle;
            System.out.println("Gerade -> Angle:" + angle + " Segment:" + segmentAngle + "Break" + breakAngle);

            for (int i = 0; i < (segments/2); i++)
            {
                result[i][0] = (int) Math.round(radius*Math.cos((angle*i) + (segmentAngle/2)));
                result[i][1] = (int) Math.round(radius*Math.cos((angle*i) + (segmentAngle/2) + breakAngle)) ;

                System.out.println(Arrays.toString(result[i]));
            }
            return result;
        }
        return null;
    }
    */

    /*
    private static boolean isInSegment(int segments, int[][] gapHights, int y)
    {
        if (gapHights == null)
        {
            return true;
        }
        else
        {
            for (int i = 0; i < gapHights.length; i++) {
                if ((y > gapHights[i][0] && y < gapHights[i][1]) || (y < gapHights[i][0] && y > gapHights[i][1]))
                {
                    return false;
                }
            }
        }
        return true;
    }
    */

    private static boolean isInSegment(int segments, int x, int y )
    {
        if (segments > 1)
        {
            double angle = 360.0/segments;
            double angleSegment = angle*4/5;

            double phi = ((Math.atan2(y, x)*180)/Math.PI);
            double phi2 = ((phi-90+(angleSegment/2))%angle );
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
        return true;


    }

    private static boolean isInSegment(int segments, int x, int y, boolean startTop )
    {
        if (segments > 1)
        {
            double angle = 360.0/segments;
            double angleSegment = angle*4/5;

            double phi = ((Math.atan2(y, x)*180)/Math.PI);
            double phi2 = ((phi+90+(angleSegment/2))%angle );
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
        return true;

    }

}
