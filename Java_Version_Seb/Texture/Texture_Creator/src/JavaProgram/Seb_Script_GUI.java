package JavaProgram;

import Script_Element.TirSu_Tools.TirSu_Master;

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
    private JPanel mainPanel;

    public Seb_Script_GUI() {
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sentences.setText("");
                filename.setText("");
                languages.setSelectedIndex(0);
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
                boolean correctLanguage = true;
                if (fileName.equalsIgnoreCase(""))
                {
                    fileName = text;
                }

                if (!text.equalsIgnoreCase(""))
                {
                    switch (languages.getSelectedItem().toString())
                    {
                        case "Githyanki":
                        {
                            TirSu_Master master = new TirSu_Master(text, fileName, true);
                            break;
                        }
                        case "Githzerai":
                        {
                            TirSu_Master master = new TirSu_Master(text, fileName, false);
                            break;
                        }
                        default:
                        {
                            JOptionPane.showMessageDialog(null, "Please select a valid language!");
                            correctLanguage = false;
                            break;
                        }
                    }
                    if (correctLanguage)
                    {
                        JOptionPane.showMessageDialog(null, "Created \"" + text + "\" using the " + languages.getSelectedItem().toString() + " script!\n" +
                                "The file was saved as \"" + fileName + "\".svg in the working directory!");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please enter a frase to transcribe!");
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Seb_Script_GUI");
        frame.setContentPane(new Seb_Script_GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
