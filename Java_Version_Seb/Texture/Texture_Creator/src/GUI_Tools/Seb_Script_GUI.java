package GUI_Tools;

import TirSu_Tools.TirSu_Sentences;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Seb_Script_GUI {
    private JTextField filename;
    private JTextField sentences;
    private JButton clearButton;
    private JButton createButton;
    private JComboBox languages;
    private JButton exitButton;

    public Seb_Script_GUI() {
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sentences.setText("");
                filename.setText("");
                languages.setSelectedIndex(1);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = sentences.getText();
                String fileName = filename.getText();
                switch (languages.getSelectedItem().toString())
                {
                    case "Githyanki":
                    {
                        TirSu_Sentences symbol = new TirSu_Sentences(text, fileName, true);
                        symbol.saveTIRSU(true);
                        break;
                    }
                    case "Githzerai":
                    {
                        TirSu_Sentences symbol = new TirSu_Sentences(text, fileName, false);
                        symbol.saveTIRSU(true);
                        break;
                    }
                    default:
                    {
                        break;
                    }
                }
            }
        });
    }
}
