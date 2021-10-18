import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Random;

public class AreaHightmap
{
    private double[][] hightmap;
    private int width;
    private int length;
    private int maxValue = 100;
    private int minValue = 0;


    public AreaHightmap(int size, int maxValue)
    {
        this.width = size;
        this.length = size;
        this.maxValue = maxValue;
        randomizeHightmap();
    }

    public AreaHightmap(int size, boolean empty)
    {
        if (empty)
        {
            this.width = size;
            this.length = size;
            emptyMap();
        }
    }

    public AreaHightmap(int length, int width, int maxValue)
    {
        this.width = width;
        this.length = length;
        this.maxValue = maxValue;
        randomizeHightmap();
    }

    public AreaHightmap(int length, int width, boolean empty)
    {
        if (empty)
        {
            this.width = width;
            this.length = length;
            emptyMap();
        }
    }

    public AreaHightmap(double[][] hightmap)
    {
        this.hightmap = hightmap;
        length = hightmap.length;
        width = hightmap[0].length;
    }


    public void emptyMap()
    {
        double[][] result = new double[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                result[i][j] = 0.0;
            }
        }

        hightmap = result;
    }

    public void randomizeHightmap()
    {
        double[][] result = new double[length][width];

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                double value = random.nextInt((maxValue - 1) - minValue) + random.nextDouble();
                result[i][j] = value;
            }
        }

        hightmap = result;
    }

    public void visualizeHightmap()
    {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(hightmap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public AreaHightmap flattenHightMap()
    {
        double[][] result = new double[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                double sum= 0;
                int sides = 1;
                if (i > 0)
                {
                    sum += hightmap[i-1][j];
                    sides++;
                }


                if (i < (length-1))
                {
                    sum += hightmap[i+1][j];
                    sides++;
                }


                if (j > 0)
                {
                    sum += hightmap[i][j-1];
                    sides++;
                }


                if (j < (width-1))
                {
                    sum += hightmap[i][j+1];
                    sides++;
                }


                sum += hightmap[i][j];
                double avg = sum/sides;
                result[i][j] = avg;
            }
        }
        return new AreaHightmap(result);
    }

    public double[][] getHightmap() {
        return hightmap;
    }
}
