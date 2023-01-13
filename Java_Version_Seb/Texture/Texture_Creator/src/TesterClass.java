import Script_Element.Script_Master;

public class TesterClass
{
    public static void main(String[] args) {
        String text = "";
        char letter = 'a';
        for (int i = 0; i < 5; i++)
        {
            text += letter;
            letter++;
            Script_Master script_master = new Script_Master(text, "test~" + text, "Githyanki");
            // Script_Master script_master = new Script_Master(text, "test~" + text, "Githzerai");
        }
    }
}
