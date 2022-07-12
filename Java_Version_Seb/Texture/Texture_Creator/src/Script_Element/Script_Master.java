package Script_Element;

import Script_Element.TirSu_Tools.Symbol_Library.Letter_Element;
import Script_Element.TirSu_Tools.Symbol_Library.TirSu_Alphabet;
import Script_Element.TirSu_Tools.TirSu_Master;

import java.util.List;

public class Script_Master
{
    private List<String> tirSu_Alphabet;

    private void requestScriptSymbols()
    {
        this.tirSu_Alphabet = TirSu_Alphabet.getScriptureAlphabet();
    }

    public Script_Master(String text, String filename, String selectedScript)
    {
        requestScriptSymbols();
        textToScript(text, filename, selectedScript);
    }

    // -------------------- Text Handler -------------------- \\
    private String textToScript(String text, String filename, String selectedScript)
    {
        List<String> selectedAlphabet;


        switch (selectedScript)
        {
            case "Githyanki": {
                selectedAlphabet = tirSu_Alphabet;
                TirSu_Master master = new TirSu_Master(text, filename, selectedAlphabet,true);
                break;
            }
            case "Githzerai": {
                selectedAlphabet = tirSu_Alphabet;
                TirSu_Master master = new TirSu_Master(text, filename, selectedAlphabet,false);
                break;
            }
            default: selectedAlphabet = null; throw new IllegalArgumentException("Bad Input: No Script selected!");
        }

        if (selectedAlphabet != null)
        {

        }
        return null;
    }

    {
        // String[] words = text.split(" ");
        //
        // for (int i = 0; i < words.length; i++) {
        //     for (int j = 0; j < words[i].length(); j++) {
        //         String combination = "";
        //         String first = String.valueOf(words[i].charAt(j)).toUpperCase();
        //         String second = "";
        //
        //         if (words[i].length() > j + 1)
        //         {
        //             second = String.valueOf(words[i].charAt(j+1)).toUpperCase();
        //         }
        //
        //         combination = (first + second).toLowerCase();
        //
        //         if (selectedAlphabet.contains(combination))
        //         {
        //             TirSu_Alphabet letter_element = TirSu_Alphabet.valueOf(combination);
        //         }
        //         else
        //         {
        //             throw new IllegalArgumentException(combination + "");
        //         }
        //
        //
        //     }
        // }
    }
}
