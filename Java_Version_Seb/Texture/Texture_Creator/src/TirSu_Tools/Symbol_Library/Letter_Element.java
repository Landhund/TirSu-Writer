package TirSu_Tools.Symbol_Library;

/**
 * Letter_Element
 */
public enum Letter_Element          // TODO: #25 Write the Elements of witch the Alphabet Symbols consist
{
    CENTER_LINE_1(1), CENTER_LINE_2(2), CENTER_LINE_3(3);

    private Letter_Element(int relativeSize)
    {
        this.relativeSize = relativeSize;
    }

    private int relativeSize;

    public int getRelativeSize() {
        return relativeSize;
    }
}