package Script_Element;

import Script_Element.TirSu_Tools.Symbol_Library.Letter_Element;
import Script_Element.TirSu_Tools.Symbol_Library.TirSu_Alphabet;
import java.util.List;

public class Script_Master
{
    private List<String> tirSu_Alphabet;

    private void requestScriptSymbols()
    {
        this.tirSu_Alphabet = TirSu_Alphabet.getScriptureAlphabet();
    }

    // -------------------- Text Handler -------------------- \\
    private String getAdjustedInput(String text, String selectedScript)
    {
        String result;
        List<String> selectedAlphabet;


        switch (selectedScript)
        {
            case "TirSu": selectedAlphabet = tirSu_Alphabet; break;
            default: selectedAlphabet = null; throw new IllegalArgumentException("Bad Input: No Script selected!");
        }

        if (selectedAlphabet != null)
        {
            String[] words = text.split(" ");

            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    String combination = "";
                    String first = String.valueOf(words[i].charAt(j)).toUpperCase();
                    String second = "";

                    if (words[i].length() > j + 1)
                    {
                        second = String.valueOf(words[i].charAt(j+1)).toUpperCase();
                    }

                    combination = (first + second).toLowerCase();

                    if (selectedAlphabet.contains(combination))
                    {
                        TirSu_Alphabet letter_element = TirSu_Alphabet.valueOf(combination);
                    }
                    else
                    {
                        throw new IllegalArgumentException(combination + "");
                    }


                }
            }

        }
        return null;
    }
}
