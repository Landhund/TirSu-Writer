import TirSu_Tools.TirSu_Circle;
import TirSu_Tools.TirSu_Sentences;

public class TirSu_Generator
{
    public static void main(String[] args)
    {
        // TirSu_Circle test = new TirSu_Circle("Kiaranyth", true);
        // test.saveTIRSU(true);

        TirSu_Sentences tester = new TirSu_Sentences("Hello World und was sonst so abgeht", true);
        tester.saveTIRSU(true);
    }
}
