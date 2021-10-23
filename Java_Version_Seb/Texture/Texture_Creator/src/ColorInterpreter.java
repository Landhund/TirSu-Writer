// import org.w3c.dom.css.RGBColor;

import java.awt.*;
// import java.util.Map;

@Deprecated
public class ColorInterpreter
{
    // private int maxValue;

    private float[] white = new float[] {(float) 0.33, (float) 0.33, (float) 0.33};
    private float valueWhite = 0.00f;
    private float[] blue = new float[] {(float) 0.00, (float) 0.00, (float) 1.00};
    private float valueBlue;
    private float[] green = new float[] {(float) 0.00, (float) 1.00, (float) 0.00};
    private float valueGreen;
    private float[] red = new float[] {(float) 1.00, (float) 0.00, (float) 0.00};
    private float valueRed;


    public ColorInterpreter(int maxValue)
    {
        valueBlue = (float) (maxValue*0.33);
        valueGreen = (float) (maxValue*0.67);
        valueRed = maxValue;
    }

    public Color createColorOnScale(double value)
    {
        // Get Bounds on Spectrum
        float vLow = getValueLow(value);
        float vHigh = getValueHigh(value);
        double prop = (value - vLow) / (vHigh - vLow);

        // Calculate RGB-Values
        float rVal = getFloatValues(vLow)[0] + (float) prop * (getFloatValues(vHigh)[0] - getFloatValues(vLow)[0]);
        float gVal = getFloatValues(vLow)[1] + (float) prop * (getFloatValues(vHigh)[1] - getFloatValues(vLow)[1]);
        float bVal = getFloatValues(vLow)[2] + (float) prop * (getFloatValues(vHigh)[2] - getFloatValues(vLow)[2]);

        // Create Color
        Color color = new Color(rVal, gVal, bVal);
        return color;
    }

    private float getValueLow(double value)
    {
        if (value > valueBlue)
        {
            if (value > valueGreen)
            {
                return valueGreen;
            }
            else return valueBlue;
        }
        else return valueWhite;
    }

    private float getValueHigh(double value)
    {
        if (value > valueBlue)
        {
            if (value > valueGreen)
            {
                return valueRed;
            }
            else return valueGreen;
        }
        else return valueBlue;
    }

    private float[] getFloatValues(double value)
    {
        if (value == valueWhite)
        {
            return white;
        }
        if (value == valueBlue)
        {
            return blue;
        }
        if (value == valueGreen)
        {
            return green;
        }
        if (value == valueRed)
        {
            return red;
        }
        return null;
    }
}
